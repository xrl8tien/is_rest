package com.is.issystem.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "multiplier_for_career_group")
public class MultiplierForCareerGroup {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "group_number")
    private Integer group_number;
    @Column(name = "multiplier")
    private Float multiplier;
}
