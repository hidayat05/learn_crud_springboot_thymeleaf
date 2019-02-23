package com.kipli.learnspring.samples.service;

import com.kipli.learnspring.samples.dao.EmployeeDao;
import com.kipli.learnspring.samples.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class EmployeeServiceImp implements EmployeeService {

    /*
    Sample Using Spring Data JPA

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee;
        if (result.isPresent()) {
            employee = result.get();
        } else {
            throw new RuntimeException("not found");
        }
        return employee;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
    */


    private EmployeeDao employeeDao;

    /**
     * Sample using hibernate or JPA
     * @param employeeDao from DI
     * for using JPA qualifier must set employeeDaoJpaImp
     * or using Hibernate set employeeDaoHibernateImp
     * @Qualifier annotation if more than 1 EmployeeDao Imp
     */

    @Autowired
    public EmployeeServiceImp(@Qualifier("employeeDaoJpaImp") EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int id) {
        return employeeDao.findByEmployeeId(id);
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDao.deleteById(id);
    }

}
