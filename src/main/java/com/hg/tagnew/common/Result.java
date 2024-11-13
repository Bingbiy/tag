package com.hg.tagnew.common;

import lombok.Data;

/**
 * Date 2024/9/28 14:17
 * Author Yu
 * Description
 */

@Data
public class Result<T> {

    private int code;
    private String msg;
    private T data;
    private long timestamp;


    private Result(){
        timestamp = System.currentTimeMillis();
    }



    public static <T> Result<T> build(T data, Integer code , String msg) {
        Result<T> result = new Result<>();
        result.setData(data);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> build (T data ,ResultCodeEnum resultCodeEnum){
        return build(data,resultCodeEnum.getCode(),resultCodeEnum.getMessage());
    }
}
