package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "request_medical_information")
public class RequestMedicalInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private Integer id_request_claim_detail;
    @Column
    private Date date_in;
    @Column
    private Date date_out;
    @Column
    private String diagnosis_disease;
    @Column
    private String name_hospital;
}
