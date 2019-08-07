package com.maitianer.sms.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YunFengSmsClient extends AbstractSmsClient {

    private static final String SUCCESS_CODE = "000000";
    private static final String DEFAULT_CHARSET = "UTF-8";

    private final static String DEFAULT_API_GATEWAY = "https://api.zhuanxinyun.com/api/v2/sendSms.json";

    public YunFengSmsClient(String appKey, String appSecret, String signName) {
        this.apiGateway = DEFAULT_API_GATEWAY;
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.signName = signName;
        this.smsClientName = "专信云";
    }

    @Override
    public boolean sendSms(String[] mobiles, String content) throws SmsClientException {

        if (mobiles == null || mobiles.length == 0) {
            logger.warn("手机号码不能为空！");
            return false;
        }

        if (content == null || content.length() > 300) {
            logger.warn("短信内容不能大于300字！");
            return false;
        }

        // 过滤换行符
        content = content.replaceAll("(\r\n|\r|\n|\n\r)", "");

        // 内容如果不包含签名，加上签名
        String existsSign = matchSignName(content);
        if (existsSign == null) {
            content = "【" + signName + "】" + content;
        }


        try {
            URIBuilder builder = new URIBuilder(apiGateway);
            builder.setParameter("appKey", appKey);
            builder.setParameter("appSecret", appSecret);
            builder.setParameter("phones", StringUtils.join(mobiles, ","));
//            builder.setParameter("missionNums", appSecret);
            builder.setParameter("content", content);
//            builder.setParameter("batchNum", "");
//            builder.setParameter("extraNum", "");

            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost(builder.build());

            // 执行请求
            HttpResponse response = httpClient.execute(httpPost);
            String jsonResult = EntityUtils.toString(response.getEntity(), DEFAULT_CHARSET);

            JSONObject result = JSON.parseObject(jsonResult);

            String errorCode = result.getString("errorCode");
            if (SUCCESS_CODE.equals(errorCode)) {
                return true;
            }else {
                String errorMessage = result.getString("errorMsg");
                logger.error("{}：短信发送失败，错误代码：{}，错误信息：{}", smsClientName, errorCode, errorMessage);
                return false;
            }
        } catch (IOException e) {
            throw new SmsClientException(e);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean sendTemplateSms(String[] mobiles, String templateId, Map<String, Object> params) {
//        String message = StringUtils.formatTemplateToString(templateFormat,para);
        return true;
    }

    private static String matchSignName(String content) {
        Pattern p = Pattern.compile("^【(.*?)】");
        Matcher m = p.matcher(content);
        if (m.find()) {
            return m.group(1);
        }

        return null;
    }


    public static void main(String[] args) {
        System.out.println(YunFengSmsClient.matchSignName("【来 啦】哈哈哈"));
        System.out.println(YunFengSmsClient.matchSignName("【来 啦】哈哈哈【啦】"));
        System.out.println(YunFengSmsClient.matchSignName("哈哈哈【啦】"));
    }
}
