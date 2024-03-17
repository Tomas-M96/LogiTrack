package com.tomasmoore.assetmanagement.entities;

import jakarta.persistence.*;

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

    public Location() {}

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

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
