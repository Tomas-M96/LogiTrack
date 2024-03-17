package com.tomasmoore.assetmanagement.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private long inventoryId;
    @Column(name = "last_updated")
    private Date lastUpdated;
    @Id
    @Column(name = "employee_id")
    private long employeeId;

    public Inventory() {
    }

    public Inventory(Date lastUpdated, long employeeId) {
        this.lastUpdated = lastUpdated;
        this.employeeId = employeeId;
    }

    public long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
}
