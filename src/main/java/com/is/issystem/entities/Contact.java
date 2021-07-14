package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "contact")
public class Contact {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "customer_name")
    private String customer_name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "id_province")
    private Integer id_province;
    @Column(name = "id_district")
    private Integer id_district;
    @Column(name = "question")
    private String question;
    @Column(name = "status")
    private String status;
    @Column(name = "create_time")
    private Date create_time;
}
