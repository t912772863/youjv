package com.gongxiangcloud.youjv.common.business;

/**
 * 业务异常
 * Created by tianxiong on 16/10/10.
 */
public class BusinessException extends RuntimeException {
    private int errorCode;
    private String errorMessage;

    public BusinessException(){}

    public BusinessException(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public BusinessException(int errorCode,String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
