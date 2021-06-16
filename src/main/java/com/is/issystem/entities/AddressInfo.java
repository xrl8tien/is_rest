package com.is.issystem.entities;
import lombok.*;

@Getter
@Setter
public class AddressInfo {
    private String typeAdd;
    private String district;
    private Integer id;
    private String no_street;
    private String city;
    private String wards;

    public AddressInfo(String district, Integer id, String no_street, String city, String wards,String typeAdd) {
        this.district = district;
        this.id = id;
        this.no_street = no_street;
        this.city = city;
        this.wards = wards;
        this.typeAdd = typeAdd;
    }
}
