package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "employee_info")
public class EmployeeInfo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "date_of_birth")
    private Date date_of_birth;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "ID_card")
    private String id_card;
    @Column(name = "id_certificate")
    private Integer id_certificate;
    @Column(name = "start_time")
    private Date start_time;
    @Column(name = "end_time")
    private Date end_time;
    @Column(name = "dept_id")
    private Integer dept_id;
    @Column(name = "id_acc")
    private Integer id_acc;
    @Column(name = "id_labour_contract")
    private Integer id_labour_contract;
    @Column
    private boolean gender;
    @Column
    private boolean marital_status;
    @Column
    private String national;
    @Column
    private int age;
    @Column(name = "id_contact_address")
    private Integer id_contact_address;
    @Column(name = "id_current_address")
    private Integer id_current_address;
    @Column(name = "id_permanent_address")
    private Integer id_permanent_address;
    @Column(name = "code_ap_support")
    private String code_ap_support;


}
