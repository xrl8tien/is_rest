package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "request_attachment")
public class RequestAttachment {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "name_document")
    String name_document;
    @Column(name = "url")
    String url;
    @Column(name = "id_request")
    Integer id_request;
}
