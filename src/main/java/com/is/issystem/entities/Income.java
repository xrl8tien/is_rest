package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Getter
@Setter
public class Income {
    @Id
    @Column
    Integer id;
    @Column
    String description;
    @Column
    BigInteger income;
    @Column
    BigInteger revenue_val;
    @Column
    Date start_time;
    @Column
    Date end_time;
    @Column
    Date create_time;

}
