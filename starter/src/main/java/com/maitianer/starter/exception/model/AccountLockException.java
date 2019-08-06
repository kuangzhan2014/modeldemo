package com.maitianer.starter.exception.model;

import org.apache.shiro.authc.AccountException;

/**
 * @Author yuzhe
 * @Date 2019/1/10 17:30
 **/
public class AccountLockException extends AccountException {

    public AccountLockException() {
    }

    public AccountLockException(String message) {
        super(message);
    }

    public AccountLockException(Throwable cause) {
        super(cause);
    }

    public AccountLockException(String message, Throwable cause) {
        super(message, cause);
    }

}
