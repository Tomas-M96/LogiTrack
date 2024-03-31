package com.tomasmoore.assetmanagement.services;

import com.tomasmoore.assetmanagement.entities.Location;
import com.tomasmoore.assetmanagement.exceptions.NoLocationsFoundException;
import com.tomasmoore.assetmanagement.repositories.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public void create(Location location) {
        locationRepository.save(location);
    }

    @Override
    public Location findById(int id) {
        Optional<Location> location = locationRepository.findById(id);

        if (location.isPresent())
            return location.get();
        else
            throw new NoLocationsFoundException("No locations found with that ID");
    }

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public void replace(Location location) {
        //Find location
        Location currentLocation = findById(location.getLocationId());

        //Verify it exists
        if (currentLocation == null)
            throw new NoLocationsFoundException("No locations found with that ID");
        else
            locationRepository.save(location);
    }

    @Override
    public void update(Location location) {
        //Find location
        Location currentLocation = findById(location.getLocationId());
        if (currentLocation == null)
            throw new NoLocationsFoundException("No locations found with that ID");
        else {
            currentLocation.setBuildingNumber((location.getBuildingNumber() != 0) ? location.getBuildingNumber() : currentLocation.getBuildingNumber());
            currentLocation.setBuildingName((location.getBuildingName() != null) ? location.getBuildingName() : currentLocation.getBuildingName());
            currentLocation.setStreet((location.getStreet() != null) ? location.getStreet() : currentLocation.getStreet());
            currentLocation.setCounty((location.getCounty() != null) ? location.getCounty() : currentLocation.getCounty());
            currentLocation.setCountry((location.getCountry() != null) ? location.getCountry() : currentLocation.getCountry());
            locationRepository.save(currentLocation);
        }
    }

    @Override
    public int delete(int id) {
        Location locationToDelete = findById(id);

        if (locationToDelete == null)
            throw new NoLocationsFoundException("No locations found with that ID");
        else {
            locationRepository.delete(locationToDelete);
            return locationToDelete.getLocationId();
        }
    }
}
