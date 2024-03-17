package com.tomasmoore.assetmanagement.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long roleId;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "role_department")
    private String roleDepartment;
    //@OneToMany
    //@JoinColumn(name = "role_lead_id")
    //private Employee roleLeadId;

    public Role() {
    }

    public Role(String roleName, String roleDepartment, long roleLeadId) {
        this.roleName = roleName;
        this.roleDepartment = roleDepartment;
        //this.roleLeadId = roleLeadId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDepartment() {
        return roleDepartment;
    }

    public void setRoleDepartment(String roleDepartment) {
        this.roleDepartment = roleDepartment;
    }
}
