package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "contract")
public class Contract {
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id()
    private Integer id;
    @Column(name = "id_customer")
    private Integer id_customer;
    @Column(name = "name_contract_owner")
    private String name_contract_owner;
    @Column(name = "payment_period_id")
    private Integer payment_period_id;
    @Column(name = "insurance_type")
    private String insurance_type;
    @Column(name = "id_main_benifit")
    private Integer id_main_benifit;
    @Column(name = "id_illustration")
    private Integer id_illustration;
    @Column(name = "start_time")
    private Date start_time;
    @Column(name = "end_time")
    private Date end_time;
    @Column(name = "create_time")
    private Date create_time;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "approval_status")
    private String approval_status;
    @Column(name = "contract_total_value")
    private BigInteger contract_total_value;
    @Column(name = "code_em_support")
    private String code_em_support;
}
