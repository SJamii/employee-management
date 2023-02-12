package com.example.empManagement.dao;

import com.example.empManagement.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
    @Override
    List<Employee> findAll();
}
