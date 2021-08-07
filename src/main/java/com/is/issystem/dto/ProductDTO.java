package com.is.issystem.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Getter
@Setter
public class ProductDTO {
    @Id
    @Column
    private Integer id;
    @Column
    private String benifit_name;
    @Column
    private Integer number_products;
}
