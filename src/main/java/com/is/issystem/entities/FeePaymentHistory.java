package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class FeePaymentHistory {
    @Column
    @Id
    private int id;
    @Column
    private int id_contract;
    @Column
    private int id_invoice;
    @Column
    private String payment_amount;
    @Column
    private String payment_method;
    @Column
    private int id_collecter;
    @Column
    private Date created_time;
}
