package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "permanent_address")
public class PermanentAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "peradd_id")
      private Integer  peradd_id ;
    @Column(name = "peradd_no_street")
      private String  peradd_no_street ;
    @Column(name = "peradd_city")
      private String  peradd_city ;
    @Column(name = "peradd_district")
      private String  peradd_district ;
    @Column(name = "peradd_wards")
      private String  peradd_wards;
}
