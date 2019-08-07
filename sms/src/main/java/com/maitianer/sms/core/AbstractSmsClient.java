package com.maitianer.sms.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * User: Leo
 * Date: 2018/5/28 下午9:09
 */
public abstract class AbstractSmsClient implements SmsClient {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    protected String apiGateway;
    protected String appKey;
    protected String appSecret;
    protected String signName;
    protected String smsClientName;

    @Override
    public boolean sendSms(String mobile, String content) throws SmsClientException {
        return sendSms(new String[] {mobile}, content);
    }

    @Override
    public boolean sendSms(String[] mobiles, String content) throws SmsClientException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean sendTemplateSms(String mobile, String templateId, Map<String, Object> params) throws SmsClientException {
        return sendTemplateSms(new String[] {mobile}, templateId, params);
    }

    @Override
    public abstract boolean sendTemplateSms(String[] mobiles, String templateId, Map<String, Object> params) throws SmsClientException;
}
