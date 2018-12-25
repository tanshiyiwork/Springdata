package com.wonders.service;

import com.wonders.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void update(Integer id,Integer age){
        employeeRepository.update(id,age);
    }
}
