package com.tomasmoore.assetmanagement.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
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
    @JoinColumn(name = "employee_id", foreignKey = @ForeignKey(name = "FK_EMPLOYEE"))
    private Employee employee;
}