package com.mlds.core.exception;

import com.mlds.core.constant.APIMessage;

/**
 * 自定义的处理异常
 * @version 1.0
 * @Author chenyunxuan
 * @Date 2017-05-02 10:26
 */
public class MldsException extends RuntimeException {

    //异常编号
    private Integer code;

    public MldsException(Integer code,String message){
        super(message);
        this.code=code;
    }

    public MldsException(APIMessage api){
        //沿用父类的传值
        super(api.getMsg());
        this.code=api.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
