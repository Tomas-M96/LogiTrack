package com.tomasmoore.assetmanagement.services;

import com.tomasmoore.assetmanagement.dtos.RoleDTO;
import com.tomasmoore.assetmanagement.entities.Role;
import com.tomasmoore.assetmanagement.exceptions.NoRolesFoundException;
import com.tomasmoore.assetmanagement.mappers.RoleMapper;
import com.tomasmoore.assetmanagement.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public void create(RoleDTO dto) {
        roleRepository.save(roleMapper.convertToEntity(dto));
    }

    @Override
    public RoleDTO findById(int id) {
        Optional<Role> role = roleRepository.findById(id);

        if (role.isPresent())
            return roleMapper.convertToDTO(role.get());
        else
            throw new NoRolesFoundException("No roles found with that ID");
    }

    @Override
    public List<RoleDTO> findAll() {
        List<Role> roles = roleRepository.findAll();

        if (!roles.isEmpty()) {
            List<RoleDTO> roleDTOs = new ArrayList<>();
            for (Role role : roles) {
                roleDTOs.add(roleMapper.convertToDTO(role));
            }
            return roleDTOs;
        } else {
            throw new NoRolesFoundException("No roles found");
        }
    }

    @Override
    public void replace(RoleDTO dto, int id) {
        //Find the entity
        Role roleToReplace = roleMapper.convertToEntity(findById(id));

        //Update the dto with the employee id of the entity to replace
        dto.setRoleId(roleToReplace.getRoleId());

        //Save to DB
        roleRepository.save(roleMapper.convertToEntity(dto));
    }

    @Override
    public void update(RoleDTO dto, int id) {
        //Find the entity
        Role roleToUpdate = roleMapper.convertToEntity(findById(id));

        //Map the DTO to the entity
        roleMapper.updateRoleFromDTO(dto, roleToUpdate);

        //Update the DB
        roleRepository.save(roleToUpdate);
    }

    @Override
    public int delete(int id) {
        Role roleToDelete = roleMapper.convertToEntity(findById(id));

        roleRepository.delete(roleToDelete);
        return roleToDelete.getRoleId();
    }
}