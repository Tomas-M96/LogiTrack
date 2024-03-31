package com.tomasmoore.assetmanagement.services;

import com.tomasmoore.assetmanagement.entities.Employee;
import com.tomasmoore.assetmanagement.exceptions.NoEmployeesFoundException;
import com.tomasmoore.assetmanagement.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void replace(Employee employee) {

        Employee foundEmployee = findById(employee.getEmployeeId());

        if (foundEmployee == null)
            throw new NoEmployeesFoundException("No employees found with that ID");

        if (foundEmployee.getEmployeeId() == employee.getEmployeeId()) {
            employeeRepository.save(employee);
        } else {
            throw new NoEmployeesFoundException("No employee matches that ID");
        }
    }

    @Override
    public void update(Employee employee) {
        //TO-DO
    }

    @Override
    public int delete(int id) {
        Employee employee = findById(id);

        if(employee != null) {
            employeeRepository.delete(employee);
            return employee.getEmployeeId();
        } else {
            throw new NoEmployeesFoundException("No employee matches that ID");
        }
    }
}
