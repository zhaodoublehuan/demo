package com.zhh.controller.exceptionhandler;

import com.zhh.exception.ZhhException;
import com.zhh.util.ReturnResult;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler {

    /**
     * 用户没有权限时异常处理
     * @return
     */
    @ExceptionHandler(UnauthorizedException.class)
    public String unauthorizedExceptionHandler(){
        return "403";
    }

    /**
     * 后台操作异常重新定义前台返回信息
     * @param e
     * @return
     */
    @ExceptionHandler(ZhhException.class)
    public ReturnResult zhhExceptionHandler(ZhhException e){
        ReturnResult result = new ReturnResult();
        result.setStatus(1);
        result.setMsg(e.getMessage());
        return result;
    }
}
