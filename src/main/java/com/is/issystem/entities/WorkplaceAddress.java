package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="workplace_address")
public class WorkplaceAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workadd_id")
    private Integer workadd_id;
    @Column(name = "workadd_no_street")
    private String workadd_no_street;
    @Column(name = "workadd_city")
    private String workadd_city;
    @Column(name = "workadd_district")
    private String workadd_district;
    @Column(name = "workadd_wards")
    private String workadd_wards;
}
