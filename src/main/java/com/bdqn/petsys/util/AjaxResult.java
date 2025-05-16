package com.bdqn.petsys.util;


public class AjaxResult<T> {
    private int code;   // 状态码（200=成功，非200=异常）
    private String message; // 提示信息
    private T data;     // 返回的数据（泛型）

    private AjaxResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    // 成功（无数据）
    public static AjaxResult<Void> success() {
        return success("操作成功");
    }

    // 成功（带提示消息）
    public static AjaxResult<Void> success(String msg) {
        return new AjaxResult<>(200, msg, null);
    }

    // 成功（带数据）
    public static <T> AjaxResult<T> success(T data) {
        return new AjaxResult<>(200, "操作成功", data);
    }
    // 成功（带数据）
    public static <T> AjaxResult<T> success(String msg,T data) {
        return new AjaxResult<>(200, msg, data);
    }

    public static AjaxResult<Void> error(String msg) {
        return new AjaxResult<>(500, msg, null);
    }
    public static AjaxResult<Void> error() {
        return new AjaxResult<>(500, "操作失败", null);
    }
    // 失败
    public static AjaxResult<Void> error(int code, String msg) {
        return new AjaxResult<>(code, msg, null);
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
