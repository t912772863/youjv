package com.gongxiangcloud.youjv.common.business;

/**
 * Created by tianxiong on 16/10/10.
 */
public class ResponseData {

    /**
     * 一个成功返回常用的实例
     */
    public static ResponseData SUCCESS_DATA = new ResponseData(200,"success");

    public static ResponseData FAILED_DATA = new ResponseData(100,"failed");

    /** 返回状态码200表示成功*/
    private int code;
    /** 消息说明*/
    private String msg;
    /** 当请求成功时,所包含的业务数据*/
    private Object data;

    public ResponseData(){}

    public ResponseData(int code,String msg){
        this.code=code;
        this.msg = msg;
    }

    public ResponseData(int code,String msg,Object data){
        this.code=code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public ResponseData setCode(int code) {
        this.code = code;
        return this;

    }

    public String getMsg() {
        return msg;
    }

    public ResponseData setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResponseData setData(Object data) {
        this.data = data;
        return this;
    }
}
