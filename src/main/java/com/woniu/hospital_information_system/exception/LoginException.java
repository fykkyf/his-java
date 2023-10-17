package com.woniu.hospital_information_system.exception;

public class LoginException extends RuntimeException{
    public LoginException(){}
    public LoginException(String message){
        super(message);
    }
}
