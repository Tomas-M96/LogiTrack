package com.tomasmoore.assetmanagement.services;

import com.tomasmoore.assetmanagement.entities.Role;

import java.util.List;

public interface RoleService {
    public void create(Role role);
    public Role findById(int id);
    public List<Role> findAll();
    public void replace(Role role);
    public void update(Role role);
    public int delete(int id);
}
