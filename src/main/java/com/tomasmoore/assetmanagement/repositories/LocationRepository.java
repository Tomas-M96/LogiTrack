package com.tomasmoore.assetmanagement.repositories;

import com.tomasmoore.assetmanagement.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LocationRepository extends JpaRepository<Location, Integer> {
}
