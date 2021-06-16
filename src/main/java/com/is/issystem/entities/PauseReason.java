package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "pause_reason_history")
public class PauseReason {
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(name = "description")
    private String description;
    @Column(name = "id_admin_approve")
    private int id_admin_approve;
    @Column(name = "id_employee_pause")
    private int id_employee_pause;
    @Column(name = "created_time")
    private Date created_time;
    @Column(name = "id_attachment")
    private int id_attachment;

}
