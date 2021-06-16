package com.is.issystem.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class IllustrationItemOfList {
    @Column
    @Id
    private int id;

    @Column
    private int id_customer_info;

    @Column
    private Date create_time;

    @Column
    private String benifit_name;
}
