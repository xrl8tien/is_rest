package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "kpi")
public class Kpi {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "code_employee")
    String code_employee;
    @Column(name = "target")
    BigInteger target;
    @Column(name = "create_time")
    Date create_time;
}
