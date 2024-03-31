package com.tomasmoore.assetmanagement.entities;

import com.tomasmoore.assetmanagement.dtos.RoleDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "role_department")
    private String roleDepartment;

    public RoleDTO convertToDTO() {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleName(roleName);
        roleDTO.setRoleDepartment(roleDepartment);
        return roleDTO;
    }
}

