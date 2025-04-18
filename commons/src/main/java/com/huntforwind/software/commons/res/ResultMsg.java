package com.huntforwind.software.commons.res;

import lombok.Data;

@Data
public class ResultMsg<T> {

    /**
     * 状态码
     **/
    private int code;

    /**
     * 结果描述
     **/
    private String message;

    /**
     * 结果集
     **/
    private T data;

    /**
     * 时间戳
     **/
    private long timestamp;

// set、get方法等...

    public ResultMsg() {
        timestamp = System.currentTimeMillis();
    }

    public static <T> ResultMsg<T> success() {
        return success(null);
    }

    public static <T> ResultMsg<T> success(T data) {
        ResultMsg<T> resultMsg = new ResultMsg<>();
        resultMsg.setCode(ReturnCode.RC200.getCode());
        resultMsg.setMessage(ReturnCode.RC200.getMessage());
        resultMsg.setData(data);
        return resultMsg;
    }

    public static <T> ResultMsg<T> fail(String message) {
        return fail(ReturnCode.RC500.getCode(), message);
    }

    public static <T> ResultMsg<T> fail(ReturnCode returnCode) {
        return fail(returnCode.getCode(), returnCode.getMessage());
    }

    public static <T> ResultMsg<T> fail(int code, String message) {
        ResultMsg<T> resultMsg = new ResultMsg<>();
        resultMsg.setCode(code);
        resultMsg.setMessage(message);
        return resultMsg;
    }
}