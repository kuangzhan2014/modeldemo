package com.maitianer.pay.wxpay;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * User: Leo
 * Date: 2018/10/2 9:18 PM
 */
@ConfigurationProperties(prefix = "wxpay")
public class WxPayProperties {

    /**
     * 设置微信公众号的appid
     */
    private String appId;

    /**
     * 微信支付商户号
     */
    private String mchId;

    /**
     * 微信支付商户密钥
     */
    private String mchKey;

    /**
     * 服务商模式下的子商户公众账号ID
     */
    private String subAppId;

    /**
     * 服务商模式下的子商户号
     */
    private String subMchId;

    /**
     * apiclient_cert.p12的文件的绝对路径
     */
    private String keyPath;

    public String getAppId() {
        return appId;
    }

    public WxPayProperties setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public String getMchId() {
        return mchId;
    }

    public WxPayProperties setMchId(String mchId) {
        this.mchId = mchId;
        return this;
    }

    public String getMchKey() {
        return mchKey;
    }

    public WxPayProperties setMchKey(String mchKey) {
        this.mchKey = mchKey;
        return this;
    }

    public String getSubAppId() {
        return subAppId;
    }

    public WxPayProperties setSubAppId(String subAppId) {
        this.subAppId = subAppId;
        return this;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public WxPayProperties setSubMchId(String subMchId) {
        this.subMchId = subMchId;
        return this;
    }

    public String getKeyPath() {
        return keyPath;
    }

    public WxPayProperties setKeyPath(String keyPath) {
        this.keyPath = keyPath;
        return this;
    }
}
