package com.tomasmoore.assetmanagement.services;

import com.tomasmoore.assetmanagement.dtos.RoleDTO;

import java.util.List;

public interface RoleService {
    void create(RoleDTO role);
    RoleDTO findById(int id);
    List<RoleDTO> findAll();
    void replace(RoleDTO role, int id);
    void update(RoleDTO role, int id);
    int delete(int id);
}
