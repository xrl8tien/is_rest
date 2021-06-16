package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "current_address")
public class CurrentAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curadd_id")
    private Integer  curadd_id ;
    @Column(name = "curadd_no_street")
    private String  curadd_no_street ;
    @Column(name = "curadd_city")
    private String  curadd_city ;
    @Column(name = "curadd_district")
    private String  curadd_district ;
    @Column(name = "curadd_wards")
    private String  curadd_wards;
}
