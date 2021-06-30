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
    private BigInteger amount;
    @Column
    private Integer id_contract;
    @Column
    private String status;
    @Column
    private String priority;
}
