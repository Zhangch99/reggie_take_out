package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.entity.Category;

/**
 * @author zhangch
 * @Description
 * @date 2023/7/25 18:18
 */
public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
