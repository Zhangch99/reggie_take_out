package com.itheima.reggie.common;

/**
 * @author zhangch
 * @Description 自定义异常类
 * @date 2023/7/26 10:10
 */
public class CustomException extends RuntimeException{
    public CustomException(String message){
        super(message);
    }
}
