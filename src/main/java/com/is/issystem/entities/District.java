package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "district")
public class District {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "id_province")
    private Integer id_province;
    @Column(name = "code_sale")
    private String code_sale;
}