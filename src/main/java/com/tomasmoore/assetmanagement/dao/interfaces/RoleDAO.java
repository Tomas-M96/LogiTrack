package com.tomasmoore.assetmanagement.dao.interfaces;

import com.tomasmoore.assetmanagement.entities.Role;

import java.util.List;

public interface RoleDAO {
    void add(Role role);
    void update(Role role);
    void delete(long id);
    Role findById(long id);
    List<Role> findAll();
    int clean();
}
