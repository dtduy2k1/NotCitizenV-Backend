package com.zue.be.payload;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
public class WardDto {
    private String code;
    private String name;
    private DistrictDto district;
    private AdministrativeUnitDto administrativeUnit;
}
