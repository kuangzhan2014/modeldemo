package com.maitianer.common.core.filesystem.provider.qiniu;

import com.maitianer.common.core.filesystem.UploadObject;
import com.maitianer.common.core.filesystem.provider.AbstractProvider;
import com.maitianer.common.core.filesystem.provider.FSOperErrorException;
import com.maitianer.common.core.filesystem.utils.FilePathHelper;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.io.IOException;
import java.util.Map;

/**
 * 七牛文件服务
 *
 * @author <a href="mailto:vakinge@gmail.com">vakin</a>
 * @description <br>
 * @date 2017年1月5日
 */
public class QiniuProvider extends AbstractProvider {

    public static final String NAME = "qiniu";

    private static UploadManager uploadManager;
    private static BucketManager bucketManager;
    private Auth auth;
    private boolean isPrivate;

    public QiniuProvider(String urlprefix, String bucketName, String accessKey, String secretKey, boolean isPrivate) {

        Validate.notBlank(bucketName, "[bucketName] not defined");
        Validate.notBlank(accessKey, "[accessKey] not defined");
        Validate.notBlank(secretKey, "[secretKey] not defined");
        Validate.notBlank(urlprefix, "[urlPrefix] not defined");

        this.urlPrefix = urlprefix.endsWith(DIR_SPLITTER) ? urlprefix : urlprefix + DIR_SPLITTER;
        this.bucketName = bucketName;
        auth = Auth.create(accessKey, secretKey);

        Zone z = (Zone) Zone.autoZone();
        Configuration c = new Configuration(z);
        uploadManager = new UploadManager(c);
        bucketManager = new BucketManager(auth, c);

        this.isPrivate = isPrivate;
    }

    @Override
    public String upload(UploadObject object) {
        String fileName = object.getFileName();
        if (StringUtils.isNotBlank(object.getCatalog())) {
            fileName = object.getCatalog().concat(FilePathHelper.DIR_SPLITER).concat(fileName);
        }
        try {
            Response res = null;
            String upToken = getUpToken(object.getMetadata());
            if (object.getFile() != null) {
                res = uploadManager.put(object.getFile(), fileName, upToken);
            } else if (object.getBytes() != null) {
                res = uploadManager.put(object.getBytes(), fileName, upToken);
            } else if (object.getInputStream() != null) {
                res = uploadManager.put(object.getInputStream(), fileName, upToken, null, object.getMimeType());
            } else if (StringUtils.isNotBlank(object.getUrl())) {
                return bucketManager.fetch(object.getUrl(), bucketName, fileName).key;
            } else {
                throw new IllegalArgumentException("upload object is NULL");
            }
            return processUploadResponse(res);
        } catch (QiniuException e) {
            processUploadException(fileName, e);
        }
        return null;
    }

    @Override
    public String getDownloadUrl(String file) {
        String path = getFullPath(file);
        if (isPrivate) {
            path = auth.privateDownloadUrl(path, 3600);
        }
        return path;
    }

    @Override
    public boolean delete(String fileName) {
        try {
            if (fileName.contains(DIR_SPLITTER))
                fileName = fileName.replace(urlPrefix, "");
            bucketManager.delete(bucketName, fileName);
            return true;
        } catch (QiniuException e) {
            processUploadException(fileName, e);
        }
        return false;
    }

    @Override
    public String createUploadToken(Map<String, Object> metadata, long expires, String... fileNames) {
        StringMap policy = null;
        if (metadata != null && !metadata.isEmpty()) {
            policy = new StringMap(metadata);
        }
        if (fileNames != null && fileNames.length > 0 && fileNames[0] != null) {
            return auth.uploadToken(bucketName, fileNames[0], expires, policy, true);
        }
        return auth.uploadToken(bucketName, null, expires, policy, true);
    }

    @Override
    public void close() throws IOException {
    }

    @Override
    public String name() {
        return NAME;
    }


    /**
     * 处理上传结果，返回文件url
     *
     * @return
     * @throws QiniuException
     */
    private String processUploadResponse(Response res) throws QiniuException {
        if (res.isOK()) {
            UploadResult ret = res.jsonToObject(UploadResult.class);
            return getFullPath(ret.key);
        }
        throw new FSOperErrorException(name(), res.toString());
    }

    private void processUploadException(String fileName, QiniuException e) {
        Response r = e.response;
        String message;
        try {
            message = r.bodyString();
        } catch (Exception e2) {
            message = r.toString();
        }
        throw new FSOperErrorException(name(), e.code(), message);
    }


    private String getUpToken(Map<String, Object> metadata) {
        return auth.uploadToken(bucketName);
    }


}
