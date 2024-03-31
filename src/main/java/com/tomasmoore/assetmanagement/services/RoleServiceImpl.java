package com.tomasmoore.assetmanagement.services;

import com.tomasmoore.assetmanagement.entities.Role;
import com.tomasmoore.assetmanagement.exceptions.NoEmployeesFoundException;
import com.tomasmoore.assetmanagement.exceptions.NoRolesFoundException;
import com.tomasmoore.assetmanagement.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void create(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role findById(int id) {
        Optional<Role> role = roleRepository.findById(id);

        if (role.isPresent())
            return role.get();
        else
            throw new NoRolesFoundException("No roles found with that ID");
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public void replace(Role role) {
        //Find the already existing role
        Role currentRole = findById(role.getRoleId());

        //Check if the role exists
        if (currentRole == null)
            throw new NoRolesFoundException("No roles found with that ID");
        else
            roleRepository.save(role);
    }

    @Override
    public void update(Role role) {
        Role currentRole = findById(role.getRoleId());

        //Check if the role exists
        if (currentRole == null)
            throw new NoRolesFoundException("No roles found with that ID");
        else {
            currentRole.setRoleName((role.getRoleName() != null) ? role.getRoleName() :  currentRole.getRoleName());
            currentRole.setRoleDepartment((role.getRoleDepartment() != null) ? role.getRoleDepartment() :  currentRole.getRoleDepartment());
            roleRepository.save(currentRole);
        }
    }

    @Override
    public int delete(int id) {
        Role roleToDelete = findById(id);

        if (roleToDelete == null)
            throw new NoRolesFoundException("No roles found with that ID");
        else {
            roleRepository.delete(roleToDelete);
            return roleToDelete.getRoleId();
        }
    }
}
