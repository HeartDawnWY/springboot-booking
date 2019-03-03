package com.jingen.booking.biz.mapper;

import com.jingen.booking.biz.common.model.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * describe:
 *
 * @author heart-dawn
 * @date 2019/02/24
 */
@Mapper
public interface EmployeeMapper {
    List<Employee> selectEmployees();
}
