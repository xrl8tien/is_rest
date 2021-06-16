package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "customer_attachment")
public class CustomerAttachment {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "name_document")
    String name_document;
    @Column(name = "url")
    String url;
    @Column(name = "id_customer")
    Integer id_customer;
    @Column(name = "id_contract")
    Integer id_contract;
}
