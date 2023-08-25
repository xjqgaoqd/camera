package com.demo.camera.common;

public class ApiResponse<T> {
    private int code;
    private String message;
    private T data;
    private long total;

    // 构造函数
    public ApiResponse(int code, String message, T data, long total) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.total = total;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    // Getter 和 Setter 方法
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    // 静态方法：返回成功响应
    public static <T> ApiResponse<T> success(T data,long total) {
        return new ApiResponse<>(200, "Success", data,total);
    }

    // 静态方法：返回失败响应
    public static <T> ApiResponse<T> error(int code, String message) {
        return new ApiResponse<>(code, message, null,0);
    }
}

