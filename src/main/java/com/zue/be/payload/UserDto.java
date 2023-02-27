package com.zue.be.payload;
import lombok.Data;

@Data
public class UserDto {
    private String username;
    private Boolean isActive;
    private ProvinceDto province;
    private DistrictDto district;
    private WardDto ward;
}
