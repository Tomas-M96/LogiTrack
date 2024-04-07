package com.tomasmoore.assetmanagement.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LocationDTO {

    private int locationId;
    private int buildingNumber;
    private String buildingName;
    @NotBlank
    private String street;
    @NotBlank
    private String county;
    @NotBlank
    private String country;

}
