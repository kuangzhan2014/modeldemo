package com.maitianer.pay.alipay;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * User: Leo
 * Date: 2018/10/2 9:03 PM
 */
@ConfigurationProperties(prefix = "alipay")
public class AlipayProperties {

    private String serviceUrl;
    private String appId;
    private String privateKey;
    private String alipayPublicKey;
    private String charset;
    private String signType;
    private String format;

    public String getServiceUrl() {
        return serviceUrl;
    }

    public AlipayProperties setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
        return this;
    }

    public String getAppId() {
        return appId;
    }

    public AlipayProperties setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public AlipayProperties setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
        return this;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public AlipayProperties setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
        return this;
    }

    public String getCharset() {
        return charset;
    }

    public AlipayProperties setCharset(String charset) {
        this.charset = charset;
        return this;
    }

    public String getSignType() {
        return signType;
    }

    public AlipayProperties setSignType(String signType) {
        this.signType = signType;
        return this;
    }

    public String getFormat() {
        return format;
    }

    public AlipayProperties setFormat(String format) {
        this.format = format;
        return this;
    }
}
