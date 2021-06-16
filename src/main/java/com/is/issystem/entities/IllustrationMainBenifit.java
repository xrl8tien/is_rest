package com.is.issystem.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "illustration_main_benifit")
public class IllustrationMainBenifit {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "id_illustration")
    Integer id_illustration;
    @Column(name = "id_main_benifit")
    Integer id_main_benifit;
    @Column(name = "full_name_insured_person")
    String full_name_insured_person;
    @Column(name = "birth_date_insured_person")
    Date birth_date_insured_person;
    @Column(name = "age_insured_person")
    Integer age_insured_person;
    @Column(name = "gender_insured_person")
    Boolean gender_insured_person;
    @Column(name = "carrier_group_insured_person")
    Integer carrier_group_insured_person;
    @Column(name = "full_name_insurance_buyer")
    String full_name_insurance_buyer;
    @Column(name = "insurance_buyer_relation_insured_person")
    String insurance_buyer_relation_insured_person;
    @Column(name = "fee_value")
    BigInteger fee_value;
    @Column(name = "denominations")
    BigInteger denominations;
}
