package com.tomasmoore.assetmanagement.dtos;

import com.tomasmoore.assetmanagement.entities.Location;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LocationDTO {

    private int buildingNumber;
    private String buildingName;
    @NotBlank
    private String street;
    @NotBlank
    private String county;
    @NotBlank
    private String country;

    public Location convertToLocation() {
        Location location = new Location();
        if (buildingName != null) {
            location.setBuildingName(buildingName);
        } else {
            location.setBuildingNumber(buildingNumber);
        }
        location.setStreet(street);
        location.setCounty(county);
        location.setCountry(country);
        return location;
    }
}
