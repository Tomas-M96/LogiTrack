package com.tomasmoore.assetmanagement.services;

import com.tomasmoore.assetmanagement.dtos.LocationDTO;
import java.util.List;

public interface LocationService {
    void create(LocationDTO location);
    LocationDTO findById(int id);
    List<LocationDTO> findAll();
    void replace(LocationDTO location, int id);
    void update(LocationDTO location, int id);
    int delete(int id);
}
