package com.maitianer.sms.core;

import java.util.Map;

/**
 * 短信类
 * @author chen
 */
public interface SmsClient {

    /**
     * 向一个手机号码发送短信
     * 暂支持云峰
     * @param mobile
     * @param content
     */
    boolean sendSms(String mobile, String content) throws SmsClientException;

    /**
     * 向多个手机号码发送短信
     * 暂支持云峰
     * @param mobiles
     * @param content
     */
    boolean sendSms(String[] mobiles, String content) throws SmsClientException;

    /**
     * 向一个手机号码发送模板短信
     * @param mobile
     * @param templateId
     * @param params
     */
    boolean sendTemplateSms(String mobile, String templateId, Map<String, Object> params) throws SmsClientException;

    /**
     * 向多个手机号码发送模板短信
     * @param mobiles
     * @param templateId
     * @param params
     */
    boolean sendTemplateSms(String[] mobiles, String templateId, Map<String, Object> params) throws SmsClientException;
}
