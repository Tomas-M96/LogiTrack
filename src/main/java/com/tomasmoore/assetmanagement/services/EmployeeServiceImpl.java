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
        if (employee.isPresent())
            return employee.get();
        else
            throw new NoEmployeesFoundException("No employees found with that ID");
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
        //Find the employee
        Employee currentEmployee = findById(employee.getEmployeeId());

        //Check to see if the employee exists
        if (currentEmployee == null)
            throw new NoEmployeesFoundException("No employee matches that ID");

        //Set the updated fields
        currentEmployee.setFirstName((employee.getFirstName() != null) ? employee.getFirstName() :  currentEmployee.getFirstName());
        currentEmployee.setLastName((employee.getLastName() != null) ? employee.getLastName() :  currentEmployee.getLastName());
        employeeRepository.save(currentEmployee);

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
