package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "claim_request")
public class ClaimRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private Date date;
    @Column
    private BigInteger payment_offer;
    @Column
    private Integer id_request;
    @Column
    private String description;
    @Column
    private String status;
    @Column
    private String code_sender;
}
