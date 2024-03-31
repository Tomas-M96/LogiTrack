package com.tomasmoore.assetmanagement.repositories;

import com.tomasmoore.assetmanagement.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
