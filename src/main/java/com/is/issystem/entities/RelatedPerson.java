package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "related_person")
public class RelatedPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;
    @Column(name = "full_name")
    String name;
    @Column(name = "address")
    String address;
    @Column(name = "date_of_birth")
    Date date_of_birth;
    @Column(name = "gender")
    Boolean gender;
    @Column(name = "phone")
    String phone;
    @Column(name = "ID_card")
    String ID_card;
    @Column(name = "carreer_group")
    Integer carreer_group;
    @Column(name = "relation")
    String relation;
    @Column(name = "job")
    String job;
    @Column(name = "id_illustration")
    Integer id_illustration;
}
