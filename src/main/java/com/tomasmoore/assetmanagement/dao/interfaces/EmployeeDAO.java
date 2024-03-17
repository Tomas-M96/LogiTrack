package com.tomasmoore.assetmanagement.dao.interfaces;

import com.tomasmoore.assetmanagement.entities.Employee;

import java.util.List;

public interface EmployeeDAO {
    void add(Employee employee);
    void update(Employee employee);
    void delete(long id);
    Employee findById(long id);
    List<Employee> findAll();
    int clean();
}
