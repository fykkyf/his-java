package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.exception.UnLiquidatedHospitalChargesException;
import com.woniu.hospital_information_system.exception.VerifyCodeErrorException;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity doException(Exception e){
        e.printStackTrace();
        log.info("exception={}",e.getClass());
        log.info("exception={}",e.getMessage());
        return new ResponseEntity(500,"error",e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity doMethodArgumentNotValidException(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        Map<String,String> errors = new HashMap<>();
        bindingResult.getFieldErrors().forEach(item -> errors.put(item.getField(), item.getDefaultMessage()));
        return new ResponseEntity(100,"vaild error",errors);
    }

    @ExceptionHandler(UnLiquidatedHospitalChargesException.class)
    public ResponseEntity unLiquidatedHospitalChargesException(UnLiquidatedHospitalChargesException e){
        log.info("exception={}",e.getClass());
        log.info("exception={}",e.getMessage());
        return new ResponseEntity(511,"error",e.getMessage());
    }

//    @ExceptionHandler
//    public ResponseEntity doPasswordErrorException(PasswordErrorException e){
//        log.info("exception={}",e.getClass());
//        log.info("exception={}",e.getMessage());
//        return new ResponseEntity(501,"error",e.getMessage());
//    }
//
//
//    @ExceptionHandler
//    public ResponseEntity doMenuReferenceException(MenuReferenceException e){
//        log.info("exception={}",e.getClass());
//        log.info("exception={}",e.getMessage());
//        return new ResponseEntity(500,"error",e.getMessage());
//    }
//
//
//    @ExceptionHandler
//    public ResponseEntity doPermissionReferenceException(PermissionReferenceException e){
//        log.info("exception={}",e.getClass());
//        log.info("exception={}",e.getMessage());
//        return new ResponseEntity(500,"error",e.getMessage());
//    }
//
//    @ExceptionHandler
//    public ResponseEntity doEnameNotExistException(EnameNotExistException e){
//        log.info("exception={}",e.getClass());
//        log.info("exception={}",e.getMessage());
//        return new ResponseEntity(500,"error",e.getMessage());
//    }



    @ExceptionHandler
    public ResponseEntity doVerifyCodeErrorException(VerifyCodeErrorException e){
        log.info("exception={}",e.getClass());
        log.info("exception={}",e.getMessage());
        return new ResponseEntity(500,"error",e.getMessage());
    }
}
