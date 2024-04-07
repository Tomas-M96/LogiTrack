package com.tomasmoore.assetmanagement.mappers;

import com.tomasmoore.assetmanagement.dtos.EmployeeDTO;
import com.tomasmoore.assetmanagement.entities.Employee;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mapping(target = "employeeId", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEmployeeFromDTO(EmployeeDTO dto, @MappingTarget Employee entity);

    @Mapping(source = "location.locationId", target = "locationId")
    @Mapping(source = "role.roleId", target = "roleId")
    EmployeeDTO convertToDTO(Employee entity);
    Employee convertToEntity(EmployeeDTO dto);
}
