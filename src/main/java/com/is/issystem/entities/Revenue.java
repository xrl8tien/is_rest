package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "revenue")
public class Revenue {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "code_employee")
    String code_employee;
    @Column(name = "id_contract")
    Integer id_contract;
    @Column(name = "income")
    BigInteger income;
    @Column(name = "revenue_val")
    BigInteger revenue_val;
    @Column(name = "create_time")
    Date create_time;
}
