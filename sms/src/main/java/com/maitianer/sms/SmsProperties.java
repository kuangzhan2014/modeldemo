package com.maitianer.sms;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: Mr.Zhang
 * @Date: 2018-12-18 17:50
 */
@ConfigurationProperties(prefix = "sms")
public class SmsProperties {

    public enum Platform {
        ZhuanXinYun, NetEase
    }

    private Platform platform;
    private String apiGateway;
    private String appKey;
    private String appSecret;
    private String signName;

    public Platform getPlatform() {
        return platform;
    }

    public SmsProperties setPlatform(Platform platform) {
        this.platform = platform;
        return this;
    }

    public String getApiGateway() {
        return apiGateway;
    }

    public SmsProperties setApiGateway(String apiGateway) {
        this.apiGateway = apiGateway;
        return this;
    }

    public String getAppKey() {
        return appKey;
    }

    public SmsProperties setAppKey(String appKey) {
        this.appKey = appKey;
        return this;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public SmsProperties setAppSecret(String appSecret) {
        this.appSecret = appSecret;
        return this;
    }

    public String getSignName() {
        return signName;
    }

    public SmsProperties setSignName(String signName) {
        this.signName = signName;
        return this;
    }
}
