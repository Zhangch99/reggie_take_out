package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhangch
 * @Description
 * @date 2023/7/24 18:10
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
