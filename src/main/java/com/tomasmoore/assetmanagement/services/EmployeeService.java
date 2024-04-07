package com.tomasmoore.assetmanagement.services;

import com.tomasmoore.assetmanagement.dtos.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    void create(EmployeeDTO employee);
    EmployeeDTO findById(int id);
    List<EmployeeDTO> findAll();
    void replace(EmployeeDTO employee, int id);
    void update(EmployeeDTO employee, int id);
    int delete(int id);
}
