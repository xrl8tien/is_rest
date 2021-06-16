package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "attachment")
public class Attachment {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(name = "url")
    private String url;

    @Column(name = "id_attachment")
    private String id_attachment;

    @Column(name = "name")
    private String name;
}
