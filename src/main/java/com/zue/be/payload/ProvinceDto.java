package com.zue.be.payload;

import lombok.*;

@Data
public class ProvinceDto {
    private String code;
    private String name;
    private AdministrativeUnitDto administrativeUnit;
    private AdministrativeRegionDto administrativeRegion;
}

