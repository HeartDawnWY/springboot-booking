package com.jingen.booking.biz.service;

import com.jingen.booking.biz.common.model.Employee;
import com.jingen.booking.biz.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * describe:
 *
 * @author heart-dawn
 * @date 2019/02/24
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> getEmployees(){
        return employeeMapper.selectEmployees();
    }
}
