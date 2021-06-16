package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "multiplier_for_payment_period")
public class MultiplierForPaymentPeriod {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "priod_id")
    private Integer priod_id;
    @Column(name = "description")
    private String description;
    @Column(name = "multiplier")
    private Float multiplier;
}
