package com.is.issystem.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "illustration_sub_benifit")
public class IllustrationSubBenifit {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "id_illustration")
    Integer id_illustration;
    @Column(name = "id_sub_benifit")
    Integer id_sub_benifit;
    @Column(name = "full_name_insured_persion_extra")
    String full_name_insured_persion_extra;
    @Column(name = "insurance_buyer_relation_extra_insured_person")
    String insurance_buyer_relation_extra_insured_person;
    @Column(name = "dob_extra_insured_person")
    Date dob_extra_insured_person;
    @Column(name = "age_extra_insured_person")
    Integer age_extra_insured_person;
    @Column(name = "gender_extra_insured_person")
    Boolean gender_extra_insured_person;
    @Column(name = "carrier_group_extra_insured_person")
    Integer carrier_group_extra_insured_person;
    @Column(name = "denominations")
    BigInteger denominations;
    @Column(name = "fee_value")
    BigInteger fee_value;
    @Column(name = "is_extra_insured_person")
    Boolean is_extra_insured_person;
    @Column(name = "id_related_person")
    Integer id_related_person;
}
