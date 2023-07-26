package com.itheima.reggie.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author zhangch
 * @Description： 全局异常注解
 * @date 2023/7/25 11:44
 */

@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody  //底下方法的返回结果为json数据，所以需要添加ResponseBody注解
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 异常处理方法，当ControllerAdvice中定义的注解中出现了对应的异常，则进行处理
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> exceptionHandler(SQLIntegrityConstraintViolationException ex){
        log.error("错误提示信息为：{}", ex.getMessage());
        if (ex.getMessage().contains("Duplicate entry")){
            String[] s = ex.getMessage().split(" ");
            String msg = s[2] + "已存在";
            return R.error(msg);
        }
        return R.error("失败了！！！");
    }

    @ExceptionHandler(CustomException.class)
    public R<String> exceptionHandler(CustomException ex){
        log.error("错误提示信息为：{}", ex.getMessage());
        return R.error(ex.getMessage());
    }
}
