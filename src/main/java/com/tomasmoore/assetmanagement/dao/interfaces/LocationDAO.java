package com.tomasmoore.assetmanagement.dao.interfaces;

import com.tomasmoore.assetmanagement.entities.Location;

import java.util.List;

public interface LocationDAO {
    void add(Location location);
    Location findById(long id);
    List<Location> findAll();
    void update(Location location);
    void delete(long id);
    int clean();
}
