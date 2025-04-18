package com.huntforwind.software.commons.res;

public enum ReturnCode {

    /**
     * 操作成功
     **/
    RC200(200, "请求成功"),

    /**
     * access_denied
     **/
    RC403(403, "无访问权限,请联系管理员授予权限"),

    /**
     * 服务异常
     **/
    RC500(500, "系统异常，请稍后重试");

    /**
     * 自定义状态码
     **/
    private final int code;

    /**
     * 自定义描述
     **/
    private final String message;

    ReturnCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

