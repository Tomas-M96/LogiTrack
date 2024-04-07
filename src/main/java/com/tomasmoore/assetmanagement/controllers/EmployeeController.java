package com.tomasmoore.assetmanagement.controllers;

import com.tomasmoore.assetmanagement.dtos.EmployeeDTO;
import com.tomasmoore.assetmanagement.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/employees")
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeDTO> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployee(@PathVariable int id) {
        //Find employee
        return employeeService.findById(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        employeeService.create(employeeDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void putEmployee(@Valid @PathVariable int id, @Valid @RequestBody EmployeeDTO payload) {
        employeeService.replace(payload, id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void patchEmployee(@Valid @PathVariable int id, @RequestBody EmployeeDTO payload) {
        employeeService.update(payload, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteEmployee(@PathVariable int id) {
        int idDeleted = employeeService.delete(id);

        if (idDeleted != 0) {
            return "Deleted Employee ID: " + id;
        } else {
            throw new RuntimeException();
        }
    }
}
