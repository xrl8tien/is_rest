package com.is.issystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DistrictDTO {
    private Integer id;
    private String name;
    private String type;
    private Integer id_province;
    private List<String> codes_sale;
}
