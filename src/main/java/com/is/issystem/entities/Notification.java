package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private Integer id_customer;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String url;
    @Column
    private Integer type;
    @Column
    private Date date;
}
