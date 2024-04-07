package com.tomasmoore.assetmanagement.mappers;

import com.tomasmoore.assetmanagement.dtos.LocationDTO;
import com.tomasmoore.assetmanagement.entities.Location;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationDTO convertToDTO(Location entity);
    Location convertToEntity(LocationDTO dto);

    @Mapping(target = "locationId", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateLocationFromDTO(LocationDTO dto, @MappingTarget Location location);
}