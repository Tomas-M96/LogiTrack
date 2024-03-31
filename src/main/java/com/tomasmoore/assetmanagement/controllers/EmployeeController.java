package com.tomasmoore.assetmanagement.controllers;

import com.tomasmoore.assetmanagement.dtos.EmployeeDTO;
import com.tomasmoore.assetmanagement.entities.Employee;
import com.tomasmoore.assetmanagement.exceptions.NoEmployeesFoundException;
import com.tomasmoore.assetmanagement.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/employees")
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeDTO> getEmployees() {
        List<Employee> employees = employeeService.findAll();

        if (!employees.isEmpty()) {
            List<EmployeeDTO> employeeDTOs = new ArrayList<>();
            for (Employee employee : employees) {
                employeeDTOs.add(employee.convertToDTO());
            }
            return employeeDTOs;
        } else {
            throw new NoEmployeesFoundException("No employees found.");
        }
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployee(@PathVariable int id) {
        //Find employee
        Employee employee = employeeService.findById(id);

        //Return employee as DTO
        return employee.convertToDTO();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        employeeService.create(employeeDTO.convertToEmployee());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void putEmployee(@Valid @PathVariable int id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeDTO.convertToEmployee();
        employee.setEmployeeId(id);
        employeeService.replace(employee);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void patchEmployee() {
        //To-do
        //How do we handle this?
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteEmployee(@PathVariable int id) {
        int idDeleted = employeeService.delete(id);

        if (idDeleted != 0) {
            return "Deleted Employee ID: " + id;
        } else {
            throw new RuntimeException();
        }
    }
}
