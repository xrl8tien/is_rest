package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "request_claim_detail")
public class RequestClaimDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private Integer id_request;
    @Column
    private Date time_death;
    @Column
    private String cause_death;
    @Column
    private String place_death;
    @Column
    private Date time_accident;
    @Column
    private String cause_accident;
    @Column
    private String place_accident;
    @Column
    private String injury_status;
    @Column
    private String name_writer;
    @Column
    private Date dob_writer;
    @Column
    private String card_id_writer;
    @Column
    private String address_writer;
    @Column
    private String phone_writer;
    @Column
    private String email_writer;
    @Column
    private String main_benefit;
    @Column
    private String sub_benefit;
}
