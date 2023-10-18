package com.woniu.hospital_information_system.exception;

public class VerifyCodeErrorException extends RuntimeException{

    public VerifyCodeErrorException() {
    }

    public VerifyCodeErrorException(String message) {
        super(message);
    }

    public VerifyCodeErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public VerifyCodeErrorException(Throwable cause) {
        super(cause);
    }

    public VerifyCodeErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
