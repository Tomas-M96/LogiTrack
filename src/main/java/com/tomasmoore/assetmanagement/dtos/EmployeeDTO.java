package com.tomasmoore.assetmanagement.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeDTO {

    private int employeeId;
    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    @NotNull(message = "Location is required")
    private int locationId;
    @NotNull(message = "Role is required")
    private int roleId;
}
