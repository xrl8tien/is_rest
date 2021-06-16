package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class BenifitPaymentHistory {
    @Column
    @Id
    private int id;
    @Column
    private int id_contract;
    @Column
    private int id_main_benifit;
    @Column
    private int id_bill_issuer;
    @Column
    private int id_attachment;
    @Column
    private String payment_amount;
    @Column
    private String approve_status;
    @Column
    private Date created_time;
}
