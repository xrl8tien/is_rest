package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Getter
@Setter
@Entity
@Table(name = "detail_commission")
public class DetailCommission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;
    @Column(name = "id_detail_payment_period")
    Integer id_detail_payment_period;
    @Column(name = "price_insurance_upperbound")
    BigInteger price_insurance_upperbound;
    @Column(name = "price_insurance_lowerbound")
    BigInteger price_insurance_lowerbound;
    @Column(name = "commission")
    Float commission;
}
