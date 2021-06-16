package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "contact_address")
public class ContactAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conadd_id")
    private Integer  conadd_id ;
    @Column(name = "conadd_no_street")
    private String  conadd_no_street ;
    @Column(name = "conadd_city")
    private String  conadd_city ;
    @Column(name = "conadd_district")
    private String  conadd_district ;
    @Column(name = "conadd_wards")
    private String  conadd_wards;
}
