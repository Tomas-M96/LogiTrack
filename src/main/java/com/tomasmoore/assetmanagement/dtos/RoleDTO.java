package com.tomasmoore.assetmanagement.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RoleDTO {
    private int roleId;
    @NotBlank
    private String roleName;
    @NotBlank
    private String roleDepartment;

}
