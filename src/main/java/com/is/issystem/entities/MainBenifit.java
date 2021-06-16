package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "main_benifit")
public class MainBenifit {
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
    @Column(name = "paying_period")
    Integer paying_period;
}
