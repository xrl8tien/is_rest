package com.is.issystem.dto;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Getter
@Setter
@Entity
public class DetailRequestDTO
{
    @Id
    @Column
    private int id_request;
    @Column
    private int id_employee;
    @Column
    private String request_status;
    @Column
    private int id_contract;
    @Column
    private int id_illustration;
    @Column
    private Date start_time;
    @Column
    private int id;
    @Column
    private java.util.Date birth_date;
    @Column
    private Integer age;
    @Column
    private String birth_address;
    @Column
    private String types_identification;
    @Column
    private String id_card;
    @Column
    private String nationality_1;
    @Column
    private String nationality_2;
    @Column
    private String nation;
    @Column
    private String job;
    @Column
    private String career;
    @Column
    private String position;
    @Column
    private String occupation_group;
    @Column
    private String company_name;
    @Column
    private String main_business;
    @Column
    private String specific_work;
    @Column
    private float monthly_income;
    @Column
    private String email;
    @Column
    private String phone_1;
    @Column
    private String phone_2;
    @Column
    private Integer id_account;
    @Column
    private String full_name;
    @Column
    private String code;
    @Column
    private boolean status;
    @Column
    private String conadd_no_street;
    @Column
    private String conadd_city;
    @Column
    private String conadd_district;
    @Column
    private String conadd_wards;

    @Column
    private String curadd_no_street;
    @Column
    private String curadd_city;
    @Column
    private String curadd_district;
    @Column
    private String curadd_wards;

    @Column
    private String peradd_no_street;

    @Column
    private String code_em_support;

    @Column
    private boolean gender;

    @Column
    private String peradd_city;
    @Column
    private String peradd_district;
    @Column
    private String peradd_wards;

    @Column
    private String workadd_no_street;
    @Column
    private String workadd_city;
    @Column
    private String workadd_district;
    @Column
    private String workadd_wards;
    @Column
    private Integer id_current_address;
    @Column
    private Integer id_permanent_address;
    @Column
    private Integer id_contact_address;
    @Column
    private Integer id_workplace_address;
    @Column
    private java.util.Date updated_time;
    @Column
    private boolean marital_status;
    @Column
    private java.util.Date created_time;
    @Column
    private String source;
}
