package com.tomasmoore.assetmanagement.controllers;

import com.tomasmoore.assetmanagement.dtos.RoleDTO;
import com.tomasmoore.assetmanagement.services.RoleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        return roleService.findAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RoleDTO getRole(@Valid @PathVariable int id) {
        return roleService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void postRole(@Valid @RequestBody RoleDTO payload) {
        roleService.create(payload);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void putRole(@Valid @PathVariable int id, @Valid @RequestBody RoleDTO payload) {
        roleService.replace(payload, id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void patchRole(@Valid @PathVariable int id, @RequestBody RoleDTO payload) {
        roleService.update(payload, id);
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