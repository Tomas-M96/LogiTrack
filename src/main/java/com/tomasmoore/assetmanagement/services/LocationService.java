package com.tomasmoore.assetmanagement.services;

import com.tomasmoore.assetmanagement.entities.Location;

import java.util.List;

public interface LocationService {
    public void create(Location location);
    public Location findById(int id);
    public List<Location> findAll();
    public void replace(Location location);
    public void update(Location location);
    public int delete(int id);
}
