package com.metaboy.athena.model;

import java.io.Serializable;

/**
 * Created by metaboy on 16/5/12.
 */
public class RestResult<T> implements Serializable {
    public static final int SUCCESS = 0;
    public static final int FAIL = -1;
    private static final long serialVersionUID = 3957844632399394006L;
    private int result;
    private String message;
    private int size;
    private T data;

    public RestResult() {
        this.result = FAIL;
    }

    public RestResult(int result, String message, T data) {
        this(result, message, data, 0);
    }

    public RestResult(int result, String message, T data, int size) {
        this.result = result;
        this.message = message;
        this.data = data;
        this.size = size;
    }

    public static <T> RestResult<T> ok(String message, T data) {
        return new RestResult<T>(RestResult.SUCCESS, message, data);
    }

    public static <T> RestResult<T> fail(String message, T data) {
        return new RestResult<T>(RestResult.FAIL, message, data);
    }

    /**
     * 不实用isSuccess是为了spring在json中添加success字段
     *
     * @return
     */
    public boolean checkSuccess() {
        return this.result == SUCCESS;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("result=").append(result);
        sb.append(",message=").append(message);
        sb.append(",data=").append(data);
        return sb.toString();
    }

    //===============getter & setter========================================================

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
