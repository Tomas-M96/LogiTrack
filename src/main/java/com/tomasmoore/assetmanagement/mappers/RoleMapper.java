package com.tomasmoore.assetmanagement.mappers;

import com.tomasmoore.assetmanagement.dtos.RoleDTO;
import com.tomasmoore.assetmanagement.entities.Role;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDTO convertToDTO(Role entity);
    Role convertToEntity(RoleDTO dto);

    @Mapping(target = "roleId", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateRoleFromDTO(RoleDTO dto, @MappingTarget Role entity);
}