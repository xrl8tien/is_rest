package com.is.issystem.dto;
import com.is.issystem.entities.IllustrationMainBenifit;
import com.is.issystem.entities.IllustrationSubBenifit;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;


@Getter
@Setter
public class IllustrationDTO {
    Integer id;
    Integer id_customer_info;
    Date create_time;
    String benifit_name;
    Integer payment_period_id;
    BigInteger total_fee;


    IllustrationMainBenifit illustrationMainBenifit;
    List<IllustrationSubBenifit> illustrationSubBenifitList;
}
