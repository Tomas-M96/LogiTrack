package com.tomasmoore.assetmanagement.dao.impl;

import com.tomasmoore.assetmanagement.dao.interfaces.RoleDAO;
import com.tomasmoore.assetmanagement.entities.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class RoleDAOImpl implements RoleDAO {

    private EntityManager entityManager;

    public RoleDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void update(Role role) {
        entityManager.merge(role);
    }

    @Override
    public void delete(long id) {
        Role role = entityManager.find(Role.class, id);
        entityManager.remove(role);
    }

    @Override
    public Role findById(long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public List<Role> findAll() {
        TypedQuery<Role> query = entityManager.createQuery("FROM Role", Role.class);
        return query.getResultList();
    }

    @Override
    public int clean() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Role").executeUpdate();
        return numRowsDeleted;
    }
}
