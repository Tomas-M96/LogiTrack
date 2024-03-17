package com.tomasmoore.assetmanagement.dao.impl;

import com.tomasmoore.assetmanagement.dao.interfaces.LocationDAO;
import com.tomasmoore.assetmanagement.entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocationDAOImpl implements LocationDAO {

    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using contructor injection
    @Autowired
    public LocationDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void add(Location location) {
        entityManager.persist(location);
    }

    @Override
    public Location findById(long id) {
        return entityManager.find(Location.class, id);
    }

    @Override
    public List<Location> findAll() {
        TypedQuery<Location> query = entityManager.createQuery("FROM Location", Location.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Location location) {
        entityManager.merge(location);
    }

    @Override
    @Transactional
    public void delete(long id) {
        Location location = entityManager.find(Location.class, id);
        entityManager.remove(location);
    }

    @Override
    @Transactional
    public int clean() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Location").executeUpdate();
        return 0;
    }
}
