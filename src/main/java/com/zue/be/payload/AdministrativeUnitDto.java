package com.zue.be.payload;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class AdministrativeUnitDto {
    private Integer id;
    private String fullName;
}
