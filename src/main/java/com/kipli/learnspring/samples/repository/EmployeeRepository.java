package com.kipli.learnspring.samples.repository;

import com.kipli.learnspring.samples.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * annotation @RepositoryRestResource -> for custom url
 * by default url is add S on last entity
 * sample : BASE_URL_API/employees
 */
@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}
