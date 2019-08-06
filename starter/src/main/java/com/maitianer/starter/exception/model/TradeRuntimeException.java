package com.maitianer.starter.exception.model;

/**
 * @Author yuzhe
 * @Date 2018/11/14 17:23
 **/
public class TradeRuntimeException extends RuntimeException {
    /**
     * 异常代码
     */
    private int code;

    public TradeRuntimeException() {
    }

    public TradeRuntimeException(Throwable cause) {
        super(cause);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
