package com.maitianer.sms.core;

/**
 * User: Leo
 * Date: 2018/5/28 下午9:37
 */
public class SmsClientException extends Exception {

    public SmsClientException(String message) {
        super(message);
    }

    public SmsClientException(Throwable cause) {
        super(cause);
    }
}
