package com.tomasmoore.assetmanagement.services;

import com.tomasmoore.assetmanagement.dtos.EmployeeDTO;
import com.tomasmoore.assetmanagement.entities.Employee;
import com.tomasmoore.assetmanagement.entities.Location;
import com.tomasmoore.assetmanagement.entities.Role;
import com.tomasmoore.assetmanagement.exceptions.NoEmployeesFoundException;
import com.tomasmoore.assetmanagement.exceptions.NoLocationsFoundException;
import com.tomasmoore.assetmanagement.exceptions.NoRolesFoundException;
import com.tomasmoore.assetmanagement.mappers.EmployeeMapper;
import com.tomasmoore.assetmanagement.repositories.EmployeeRepository;
import com.tomasmoore.assetmanagement.repositories.LocationRepository;
import com.tomasmoore.assetmanagement.repositories.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;
    private final LocationRepository locationRepository;
    private final RoleRepository roleRepository;
    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, LocationRepository locationRepository, RoleRepository roleRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.locationRepository = locationRepository;
        this.roleRepository = roleRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    @Transactional
    public void create(EmployeeDTO dto) {
        //Find the location
        Optional<Location> location = locationRepository.findById(dto.getLocationId());

        //Find the role
        Optional<Role> role = roleRepository.findById(dto.getRoleId());

        //Check if location is empty
        if (location.isEmpty())
            throw new NoLocationsFoundException("No locations found with that Id");

        //Check if role is empty
        if (role.isEmpty())
            throw new NoRolesFoundException("No roles found with that Id");

        //Convert the dto to an entity
        Employee newEmployee = employeeMapper.convertToEntity(dto);

        //Set the location and role id
        newEmployee.setLocation(location.get());
        newEmployee.setRole(role.get());

        //Save to DB
        employeeRepository.save(newEmployee);
    }

    @Override
    public EmployeeDTO findById(int id) {
        //Find the employee
        Optional<Employee> employee = employeeRepository.findById(id);

        //If the employee is present
        if (employee.isPresent())
            //Return
            return employeeMapper.convertToDTO(employee.get());
        else
            //Otherwise throw error
            throw new NoEmployeesFoundException("No employees found with that ID");
    }

    @Override
    public List<EmployeeDTO> findAll() {
        //Find all employees
        List<Employee> employees = employeeRepository.findAll();

        //If the employee list is not empty
        if (!employees.isEmpty()) {
            //Create a list of EmployeeDTOs and add each entity to it
            List<EmployeeDTO> employeeDTOs = new ArrayList<>();
            for (Employee employee : employees) {
                employeeDTOs.add(employeeMapper.convertToDTO(employee));
            }
            //Return
            return employeeDTOs;
        } else {
            //Otherwise throw error
            throw new NoEmployeesFoundException("No employees found.");
        }

    }

    @Override
    @Transactional
    public void replace(EmployeeDTO dto, int id) {
        //Find the Employee
        Employee employeeToReplace = employeeMapper.convertToEntity(findById(id));

        //Update the dto with the employee id of the entity to replace
        dto.setEmployeeId(employeeToReplace.getEmployeeId());

        //Save to DB
        employeeRepository.save(employeeMapper.convertToEntity(dto));
    }

    @Override
    @Transactional
    public void update(EmployeeDTO employee, int id) {
        //Find the employee
        Employee employeeToUpdate = employeeMapper.convertToEntity(findById(id));

        //Map the DTO to the entity
        employeeMapper.updateEmployeeFromDTO(employee, employeeToUpdate);

        //Update the DB
        employeeRepository.save(employeeToUpdate);
    }

    @Override
    @Transactional
    public int delete(int id) {
        //Find the entity
        Employee employee = employeeMapper.convertToEntity(findById(id));

        //Delete from the DB and return the id
        employeeRepository.delete(employee);
        return employee.getEmployeeId();

    }
}
