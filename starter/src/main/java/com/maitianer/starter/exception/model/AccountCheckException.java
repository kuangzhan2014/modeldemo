package com.maitianer.starter.exception.model;

import org.apache.shiro.authc.AccountException;

/**
 * @Author yuzhe
 * @Date 2019/1/10 17:30
 **/
public class AccountCheckException extends AccountException {

    public AccountCheckException() {
    }

    public AccountCheckException(String message) {
        super(message);
    }

    public AccountCheckException(Throwable cause) {
        super(cause);
    }

    public AccountCheckException(String message, Throwable cause) {
        super(message, cause);
    }

}
