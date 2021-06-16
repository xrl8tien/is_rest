package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "campaign")
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "id_customer")
    private Integer id_customer;
    @Column(name = "create_time")
    private Date create_time;
    @Column(name = "end_time")
    private Date end_time;
}
