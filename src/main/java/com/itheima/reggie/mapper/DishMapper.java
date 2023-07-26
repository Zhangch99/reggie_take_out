package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhangch
 * @Description
 * @date 2023/7/25 22:50
 */
@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
