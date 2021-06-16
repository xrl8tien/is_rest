package com.is.issystem.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class CampaignDTO {

    @Column
    @Id
    private Integer id;

    @Column
    private String code;

    @Column
    private String full_name;

    @Column
    private String create_time;

    @Column
    private String end_time;

    @Column
    private int id_customer;
}
