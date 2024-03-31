package com.tomasmoore.assetmanagement.controllers;

import com.tomasmoore.assetmanagement.dtos.LocationDTO;
import com.tomasmoore.assetmanagement.dtos.RoleDTO;
import com.tomasmoore.assetmanagement.entities.Location;
import com.tomasmoore.assetmanagement.entities.Role;
import com.tomasmoore.assetmanagement.exceptions.NoLocationsFoundException;
import com.tomasmoore.assetmanagement.exceptions.NoRolesFoundException;
import com.tomasmoore.assetmanagement.services.LocationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/locations")
@RestController
public class LocationController {
    public final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LocationDTO getLocation(@Valid @PathVariable int id) {
        return locationService.findById(id).convertToDTO();
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<LocationDTO> getLocations() {

        List<Location> locations = locationService.findAll();

        if (!locations.isEmpty()) {
            List<LocationDTO> locationDTOs = new ArrayList<>();
            for (Location location : locations) {
                locationDTOs.add(location.convertToDTO());
            }
            return locationDTOs;
        } else {
            throw new NoLocationsFoundException("No locations found");
        }
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void postLocation(@Valid @RequestBody LocationDTO payload) {
        locationService.create(payload.convertToLocation());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void putLocation(@Valid @PathVariable int id, @Valid @RequestBody LocationDTO payload) {
        Location location = payload.convertToLocation();
        location.setLocationId(id);
        locationService.replace(location);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void patchLocation(@Valid @PathVariable int id, @RequestBody LocationDTO payload) {
        Location location = payload.convertToLocation();
        location.setLocationId(id);
        locationService.update(location);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteLocation(@Valid @PathVariable int id) {
        int idDeleted = locationService.delete(id);

        if (idDeleted != 0) {
            return "Deleted Location ID: " + id;
        } else {
            throw new RuntimeException();
        }
    }
}
