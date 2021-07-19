package com.is.issystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "group_member")
public class GroupMember {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_group")
    private String id_group;
    @Column(name = "code_sale")
    private String code_sale;
}
