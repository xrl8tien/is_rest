package com.is.issystem.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class GroupDTO {
    @Id
    @Column
    private Integer id;
    @Column
    private String code_sale_executive;
    @Column
    private String type;
    @Column
    private String name;
}
