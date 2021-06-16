package com.is.issystem.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "contract_change_history")
public class ContractChangeHistory {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "id_contract")
    private Integer id_contract;
    @Column(name = "id_customer")
    private Integer id_customer;
    @Column(name = "create_time")
    private Date create_time;
    @Column(name = "id_request")
    private Integer id_request;
    @Column(name = "name_contract_owner")
    private String name_contract_owner;
    @Column(name = "payment_period_id")
    private Integer payment_period_id;
    @Column(name = "insurance_type")
    private String insurance_type;
    @Column(name = "id_main_benifitt")
    private Integer id_main_benifitt;
    @Column(name = "id_illustration")
    private Integer id_illustration;
    @Column(name = "start_time")
    private Date start_time;
    @Column(name = "end_time")
    private Date end_time;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "approval_status")
    private String approval_status;
    @Column(name = "contract_total_value")
    private BigInteger contract_total_value;
    @Column(name = "code_em_support")
    private String code_em_support;
}
