package com.example.demo131.exception;


import lombok.Data;

/**
 * 自定义异常
 */
@Data
public class CustomException extends RuntimeException{
    //错误代码
    private String errorCode;
    //代码描述
    private String errorCodeDes;

    public CustomException(String message){
        super(message);
    }

    public CustomException(String errorCode, String errorCodeDes){
        super(errorCode);
        this.errorCode = errorCode;
        this.errorCodeDes = errorCodeDes;
    }
}
