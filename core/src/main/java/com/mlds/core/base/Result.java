package com.mlds.core.base;

/**
 * 返回的Json实体封装
 * @version 1.0
 * @Author chenyunxuan
 * @Date 2017-04-27 14:52
 */
public class Result<T> {

    //请求返回的状态码
    private Integer code;
    //请求返回的提示信息
    private String msg;
    //请求返回的数据集
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
