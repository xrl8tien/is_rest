package com.is.issystem.dto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerInfoDTO {
    private List<String> codes_saler;
    private String dateFrom;
    private String dateTo;
    private String searchValue;
}
