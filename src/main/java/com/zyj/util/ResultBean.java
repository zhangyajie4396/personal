package com.zyj.util;

/**
 * @Author: ZhangYajie
 * @Description:
 * @Date: Created in 13:20 2018/6/15
 */
public class ResultBean {

    private Object data;

    private  int code;

    private String msg;

    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ResultBean() {
    }

    public ResultBean(Object data, int code, String msg, boolean success) {
        this.data = data;
        this.code = code;
        this.msg = msg;
        this.success = success;
    }


}
