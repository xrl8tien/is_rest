package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="customer_info")
public class CustomerInfo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "birth_date")
    private Date birth_date;
    @Column(name = "age")
    private Long age;
    @Column(name = "birth_address")
    private String birth_address;
    @Column(name = "types_identification")
    private String types_identification;
    @Column(name = "id_card")
    private String id_card;
    @Column(name = "nationality_1")
    private String nationality_1;
    @Column(name = "nationality_2")
    private String nationality_2;
    @Column(name = "nation")
    private String nation;
    @Column(name = "job")
    private String job;
    @Column(name = "career")
    private String career;
    @Column(name = "position")
    private String position;
    @Column(name = "occupation_group")
    private String occupation_group;
    @Column(name = "company_name")
    private String company_name;
    @Column(name = "main_business")
    private String main_business;
    @Column(name = "specific_work")
    private String specific_work;
    @Column(name = "monthly_income")
    private Long monthly_income;
    @Column(name = "id_current_address")
    private Integer id_current_address;
    @Column(name = "id_permanent_address")
    private Integer id_permanent_address;
    @Column(name = "id_contact_address")
    private Integer id_contact_address;
    @Column(name = "id_workplace_address")
    private Integer id_workplace_address;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_1")
    private String phone_1;
    @Column(name = "phone_2")
    private String phone_2;
    @Column(name = "id_account")
    private Long id_account;
    @Column(name = "full_name")
    private String full_name;
    @Column(name = "code_em_support")
    private String code_em_support;
    @Column(name = "gender")
    private Long gender;
    @Column(name = "updated_time")
    private Date updated_time;
    @Column(name = "marital_status")
    private Long marital_status;
    @Column(name = "created_time")
    private Date created_time;
    @Column(name = "source")
    private String source;

}
