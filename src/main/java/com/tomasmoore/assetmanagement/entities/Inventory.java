package com.tomasmoore.assetmanagement.entities;

import jakarta.persistence.*;

import java.util.Date;

/*
@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private long inventoryId;
    @Column(name = "last_updated")
    private Date lastUpdated;
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Inventory() {
    }

    public Inventory(Date lastUpdated, Employee employee) {
        this.lastUpdated = lastUpdated;
        this.employee = employee;
    }

    /*
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

    public long getEmployee() {
        return employee;
        }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }



}
*/
