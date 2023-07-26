package com.itheima.reggie.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author zhangch
 * @Description 自定义元数据对象处理器
 * @date 2023/7/25 16:42
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("公共字段自动填充[insert]...");
        Long currentId = BaseContext.getCurrentId();

        metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("updateTime", LocalDateTime.now());
        metaObject.setValue("createUser", currentId); // 用户id稍后
        metaObject.setValue("updateUser", currentId); //
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("公共字段自动填充[update]...");

        Long currentId = BaseContext.getCurrentId();

        metaObject.setValue("updateTime", LocalDateTime.now());
        metaObject.setValue("updateUser", currentId); //
    }
}
