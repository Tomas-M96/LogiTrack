package com.tomasmoore.assetmanagement.dtos;

import com.tomasmoore.assetmanagement.entities.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RoleDTO {
    @NotBlank
    private String roleName;
    @NotBlank
    private String roleDepartment;

    public Role convertToRole() {
        Role role = new Role();
        role.setRoleName(roleName);
        role.setRoleDepartment(roleDepartment);
        return role;
    }
}
