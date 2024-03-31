package com.tomasmoore.assetmanagement.services;

import com.tomasmoore.assetmanagement.entities.Employee;

import java.util.List;

public interface EmployeeService {
    public void create(Employee employee);
    public Employee findById(int id);
    public List<Employee> findAll();
    public void replace(Employee employee);
    public void update(Employee employee);
    public int delete(int id);

}
