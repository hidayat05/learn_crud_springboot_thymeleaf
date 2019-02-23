package com.kipli.learnspring.samples.dao;

import com.kipli.learnspring.samples.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee findByEmployeeId(int id);

    void save(Employee employee);

    void deleteById(int id);

}
