package com.is.issystem.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class EmployeeInfoDTO {
    @Id
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private Date date_of_birth;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String id_card;
    @Column
    private Integer id_certificate;
    @Column
    private Date start_time;
    @Column
    private Date end_time;
    @Column
    private Boolean gender;
    @Column
    private Integer dept_id;
    @Column
    private Integer id_acc;
    @Column
    private Integer id_labour_contract;
    @Column
    private Integer id_current_address;
    @Column
    private Integer id_permanent_address;
    @Column
    private Integer id_contact_address;
    @Column
    private Boolean marital_status;
    @Column
    private String national;
    @Column
    private String conadd_city;
    @Column
    private String conadd_district;
    @Column
    private String conadd_no_street;
    @Column
    private String conadd_wards;
    @Column
    private String curadd_city;
    @Column
    private String curadd_district;
    @Column
    private String curadd_no_street;
    @Column
    private String curadd_wards;
    @Column
    private String peradd_city;
    @Column
    private String peradd_district;
    @Column
    private String peradd_no_street;
    @Column
    private String peradd_wards;
    @Column
    private int age;
    @Column
    private String code_ap_support;
    @Column
    private String in_dept;
    @Column
    private String code;
    @Column
    private String status;
}
