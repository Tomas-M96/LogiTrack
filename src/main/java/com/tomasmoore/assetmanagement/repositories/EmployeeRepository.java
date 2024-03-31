package com.tomasmoore.assetmanagement.repositories;


import com.tomasmoore.assetmanagement.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
