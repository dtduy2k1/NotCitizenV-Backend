package com.zue.be.payload;

import lombok.Data;

@Data
public class DistrictDto {
    private String code;
    private String name;
    private ProvinceDto province;
    private AdministrativeUnitDto administrativeUnit;
}
