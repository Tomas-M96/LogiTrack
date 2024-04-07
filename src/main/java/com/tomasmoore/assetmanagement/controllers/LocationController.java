package com.tomasmoore.assetmanagement.controllers;

import com.tomasmoore.assetmanagement.dtos.LocationDTO;
import com.tomasmoore.assetmanagement.services.LocationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        return locationService.findById(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<LocationDTO> getLocations() {
        return locationService.findAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void postLocation(@Valid @RequestBody LocationDTO payload) {
        locationService.create(payload);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void putLocation(@Valid @PathVariable int id, @Valid @RequestBody LocationDTO payload) {
        locationService.replace(payload, id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void patchLocation(@Valid @PathVariable int id, @RequestBody LocationDTO payload) {
        locationService.update(payload, id);
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
