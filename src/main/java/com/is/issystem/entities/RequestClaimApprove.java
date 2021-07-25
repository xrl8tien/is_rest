package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "request_claim_approve")
public class RequestClaimApprove {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private Date date;
    @Column
    private String code_sender;
    @Column
    private String description;
    @Column
    private Integer id_contract;
    @Column
    private Integer id_request;
    @Column
    private String status;
    @Column
    private String main_benefit;
    @Column
    private BigInteger amount_main;
    @Column
    private String sub_benefit;
    @Column
    private BigInteger amount_sub;
}
