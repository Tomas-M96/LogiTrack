package com.tomasmoore.assetmanagement.dtos;

import com.tomasmoore.assetmanagement.entities.Employee;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmployeeDTO {

    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;

    public Employee convertToEmployee() {
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        return employee;
    }

}
