package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "sub_benefit_scale")
public class SubBenefitScale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;
    @Column(name = "name")
    String name;
    @Column(name = "scale")
    Float scale;
    @Column(name = "id_sub_benefit")
    Integer id_sub_benefit;
}

