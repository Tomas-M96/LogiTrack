package com.tomasmoore.assetmanagement.services;

import com.tomasmoore.assetmanagement.dtos.LocationDTO;
import com.tomasmoore.assetmanagement.entities.Location;
import com.tomasmoore.assetmanagement.exceptions.NoLocationsFoundException;
import com.tomasmoore.assetmanagement.mappers.LocationMapper;
import com.tomasmoore.assetmanagement.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class LocationServiceImpl implements LocationService {


    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository, LocationMapper locationMapper) {
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
    }

    @Override
    public void create(LocationDTO location) {
        locationRepository.save(locationMapper.convertToEntity(location));
    }

    @Override
    public LocationDTO findById(int id) {
        Optional<Location> location = locationRepository.findById(id);

        if (location.isPresent())
            return locationMapper.convertToDTO(location.get());
        else
            throw new NoLocationsFoundException("No locations found with that ID");
    }

    @Override
    public List<LocationDTO> findAll() {

        List<Location> locations = locationRepository.findAll();

        if (!locations.isEmpty()) {
            List<LocationDTO> locationDTOs = new ArrayList<>();
            for (Location location : locations) {
                locationDTOs.add(locationMapper.convertToDTO(location));
            }
            return locationDTOs;
        } else {
            throw new NoLocationsFoundException("No locations found");
        }
    }

    @Override
    public void replace(LocationDTO dto, int id) {
        //Find the entity
        Location locationToReplace = locationMapper.convertToEntity(findById(id));

        //Update the dto with the employee id of the entity to replace
        dto.setLocationId(locationToReplace.getLocationId());

        //Save to DB
        locationRepository.save(locationMapper.convertToEntity(dto));
    }

    @Override
    public void update(LocationDTO dto, int id) {
        //Find the entity
        Location locationToUpdate = locationMapper.convertToEntity(findById(id));

        //Map the DTO to the entity
        locationMapper.updateLocationFromDTO(dto, locationToUpdate);

        //Update the DB
        locationRepository.save(locationToUpdate);
    }

    @Override
    public int delete(int id) {
        Location locationToDelete = locationMapper.convertToEntity(findById(id));

        locationRepository.delete(locationToDelete);
        return locationToDelete.getLocationId();
    }
}