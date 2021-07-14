package com.is.issystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ContactDTO {

    private List<Integer> ids;
    private String dateFrom;
    private String dateTo;
    private String searchValue;

}
