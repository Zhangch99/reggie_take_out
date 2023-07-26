package com.itheima.reggie.common;

/**
 * @author zhangch
 * @Description 基于ThreadLocal封装工具类，用户保存和获取当前登录用户的id
 * @date 2023/7/25 17:27
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    // 工具类，使用静态方法
    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }

    public static Long getCurrentId(){
        return threadLocal.get();
    }
}
