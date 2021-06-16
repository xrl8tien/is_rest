package com.is.issystem.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;

@Entity
@Getter
@Setter
public class ContractDTO {
    @Id
    @Column
    private Integer id;
    @Column
    private Integer id_customer;
    @Column
    private String name_contract_owner;
    @Column
    private Integer payment_period_id;
    @Column
    private String insurance_type;
    @Column
    private Integer id_main_benifit;
    @Column
    private Integer id_illustration;
    @Column
    private Date start_time;
    @Column
    private Date end_time;
    @Column
    private Date create_time;
    @Column
    private Boolean status;
    @Column
    private String approval_status;
    @Column
    private BigInteger contract_total_value;
    @Column
    private String code_em_support;
    @Column
    private String code;
}
