package com.zue.be.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CitizenDto {
    private String id;
    private String name;
    private String sex;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private ProvinceDto province;
    private DistrictDto district;
    private WardDto ward;

}
