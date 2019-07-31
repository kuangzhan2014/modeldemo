package com.maitianer.layuiadmin.modules.common.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: Leo
 * Date: 2018/2/15 下午9:17
 */
@RestController("commonUploadController")
@RequestMapping(value = "/upload", method = RequestMethod.POST)
public class UploadController {

    @RequestMapping("file")
    public ResponseEntity<?> uploadFile(HttpServletRequest request, HttpServletResponse response) {
//        List<String> fileNames = UploadUtils.uploadFile(request);
//
//        if (fileNames.size() > 0) {
//            return new ResponseEntity<>(fileNames, HttpStatus.OK);
//        }else {
//            return new ResponseEntity<>( Message.warn("请选择要上传的文件！"), HttpStatus.BAD_REQUEST);
//        }
        return null;
    }

    @RequestMapping("image")
    public Object uploadImage(HttpServletRequest request, HttpServletResponse response) {
//        List<String> fileNames = UploadUtils.uploadImage(request, false);
//        if (fileNames.size() > 0) {
//            return fileNames;
//        }else {
//            return new ResponseEntity<>( Message.warn("请选择要上传的文件！"), HttpStatus.BAD_REQUEST);
//        }
        return null;
    }

    @RequestMapping("imageByInputStream")
    public Object uploadImageByInputStream(HttpServletRequest request, HttpServletResponse response) {
//        List<String> fileNames = UploadUtils.uploadImageByInputStream(request, false);
//        if (fileNames.size() > 0) {
//            return fileNames;
//        }else {
//            return new ResponseEntity<>( Message.warn("请选择要上传的文件！"), HttpStatus.BAD_REQUEST);
//        }
        return null;
    }

}
