package com.tomasmoore.assetmanagement.controllers;

import com.tomasmoore.assetmanagement.dtos.RoleDTO;
import com.tomasmoore.assetmanagement.entities.Employee;
import com.tomasmoore.assetmanagement.entities.Role;
import com.tomasmoore.assetmanagement.exceptions.NoRolesFoundException;
import com.tomasmoore.assetmanagement.repositories.RoleRepository;
import com.tomasmoore.assetmanagement.services.RoleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/roles")
@RestController
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<RoleDTO> getRoles() {
        List<Role> roles = roleService.findAll();

        if (!roles.isEmpty()) {
            List<RoleDTO> roleDTOs = new ArrayList<>();
            for (Role role : roles) {
                roleDTOs.add(role.convertToDTO());
            }
            return roleDTOs;
        } else {
            throw new NoRolesFoundException("No roles found");
        }
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RoleDTO getRole(@Valid @PathVariable int id) {
        return roleService.findById(id).convertToDTO();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void postRole(@Valid @RequestBody RoleDTO payload) {
        roleService.create(payload.convertToRole());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void putRole(@Valid @PathVariable int id, @Valid @RequestBody RoleDTO payload) {
        Role role = payload.convertToRole();
        role.setRoleId(id);
        roleService.replace(role);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void patchRole(@Valid @PathVariable int id, @RequestBody RoleDTO payload) {
        Role role = payload.convertToRole();
        role.setRoleId(id);
        roleService.update(role);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteRole(@Valid @PathVariable int id) {
        int idDeleted = roleService.delete(id);

        if (idDeleted != 0) {
            return "Deleted Role ID: " + id;
        } else {
            throw new RuntimeException();
        }
    }
}
