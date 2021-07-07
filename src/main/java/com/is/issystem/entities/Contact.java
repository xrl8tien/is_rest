package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "contact")
public class Contact {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "phone")
    private String phone;
    @Column(name = "province")
    private String name;
    @Column(name = "district")
    private String type;
}
