package com.woniu.hospital_information_system.exception;

public class PasswordErrorException extends RuntimeException{
    public PasswordErrorException(){}
    public PasswordErrorException(String message){
        super(message);
    }
}
