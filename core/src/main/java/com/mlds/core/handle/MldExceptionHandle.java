package com.mlds.core.handle;

import com.mlds.core.base.Result;
import com.mlds.core.exception.MldsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 统一异常处理类
 * @version 1.0
 * @Author chenyunxuan
 * @Date 2017-04-27 19:25
 */
@ControllerAdvice
public class MldExceptionHandle {
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Result handle(Exception exception){
        Logger logger= LoggerFactory.getLogger(this.getClass());
        Result result=new Result();
        logger.error("---------errorInfo----------",exception);
        if(exception instanceof MldsException){
            MldsException mldsException= (MldsException) exception;
            result.setMsg( mldsException.getMessage());
            result.setCode(mldsException.getCode());
        }else{
            result.setMsg("程序内部错误");
            result.setCode(-1);
        }
        return result;
    }
}
