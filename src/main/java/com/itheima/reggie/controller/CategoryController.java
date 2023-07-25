package com.itheima.reggie.controller;

import ch.qos.logback.classic.spi.EventArgUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.reggie.common.R;
import com.itheima.reggie.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangch
 * @Description
 * @date 2023/7/25 16:07
 */
@RestController
@Slf4j
@RequestMapping("category/")
public class CategoryController {
    @Autowired
    EmployeeService employeeService;

    public R<Page> page(int page, int pageSize){
        IPage<Object> objectIPage = new Page();

        return null;
    }

}