package com.zhh.controller.exceptionhandler;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    public String unauthorizedExceptionHandler(){
        return "403";
    }
}
