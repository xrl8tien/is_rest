package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer id_type;
    @Column
    private Date date;
    @Column
    private Integer requestcol;
    @Column
    private String code_sender;
    @Column
    private String code_reciever;
    @Column
    private String description;
    @Column
    private String priority;
    @Column
    private Integer id_contract;
    @Column
    private String status;

}
