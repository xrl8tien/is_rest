package com.is.issystem.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "multiplier_for_age")
public class MultiplierForAge {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "age")
    private Integer age;
    @Column(name = "multiplier")
    private Float multiplier;
}
