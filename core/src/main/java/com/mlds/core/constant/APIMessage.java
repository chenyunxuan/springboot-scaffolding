package com.mlds.core.constant;

/**
 * 异常枚举
 * @version 1.0
 * @Author chenyunxuan
 * @Date 2017-04-27 19:20
 */
public enum APIMessage {
    DEMO(1000,"AHAHAH")
    ;
    //异常编号
    private Integer code;
    //异常提示
    private String msg;

    APIMessage(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
