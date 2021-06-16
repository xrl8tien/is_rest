package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "sub_benifit")
public class SubBenifit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;
    @Column(name = "benifit_name")
    String benifit_name;
    @Column(name = "description")
    String description;
    @Column(name = "fee_period")
    Integer fee_period;
    @Column(name = "maturity_time")
    Integer maturity_time;
    @Column(name = "minimum_value")
    Integer minimum_value;
}
