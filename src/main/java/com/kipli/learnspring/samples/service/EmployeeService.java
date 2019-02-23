package com.kipli.learnspring.samples.service;

import com.kipli.learnspring.samples.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);
}
