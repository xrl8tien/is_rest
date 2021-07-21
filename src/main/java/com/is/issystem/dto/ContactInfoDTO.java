package com.is.issystem.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class ContactInfoDTO {
    @Id
    @Column
    private Integer id;
    @Column
    private String customer_name;
    @Column
    private String phone;
    @Column
    private Integer id_province;
    @Column
    private Integer id_district;
    @Column
    private String question;
    @Column
    private String status;
    @Column
    private Date create_time;
    @Column
    private String code_sale;
    @Column
    private String name;
}
