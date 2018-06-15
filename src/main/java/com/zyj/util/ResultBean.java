package com.zyj.util;

/**
 * @Author: ZhangYajie
 * @Description:
 * @Date: Created in 13:20 2018/6/15
 */
public class ResultBean {

    private Object data;

    private  int code;

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

    public ResultBean(Object data, int code) {
        this.data = data;
        this.code = code;
    }

    public static ResultBean getResultBean(Object data){
        return new ResultBean(data,200);
    }
}
