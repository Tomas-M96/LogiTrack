package com.tomasmoore.assetmanagement.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private int locationId;
    @Column(name = "building_number")
    private int buildingNumber;
    @Column(name = "building_name")
    private String buildingName;
    @Column(name = "street")
    private String street;
    @Column(name = "county")
    private String county;
    @Column(name = "country")
    private String country;

    /*
    public Location(int buildingNumber, String street, String county, String country) {
        this.buildingNumber = buildingNumber;
        this.street = street;
        this.county = county;
        this.country = country;
    }

    public Location(String buildingName, String street, String county, String country) {
        this.buildingName = buildingName;
        this.street = street;
        this.county = county;
        this.country = country;
    }
     */
}
