package com.is.issystem.entities;
import com.sun.istack.Nullable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "illustration")
public class Illustration {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_customer_info")
    private int id_customer_info;

    @Column(name = "create_time")
    private Date create_time;

    @Column(name = "total_fee")
    private BigInteger total_fee;

    @Column(name = "payment_period_id")
    private Integer payment_period_id;
}
