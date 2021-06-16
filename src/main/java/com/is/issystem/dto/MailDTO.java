package com.is.issystem.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class MailDTO {
    @Id
    @Column
    private Integer id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private Date time;

    @Column
    private String status;

    @Column
    private String priority;

    @Column
    private Integer sender_id;

    @Column
    private Integer receiver_id;

    @Column
    private String code;

    @Column
    private String name;
}
