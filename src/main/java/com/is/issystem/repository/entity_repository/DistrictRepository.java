package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {

    @Query(value = "select * from is_agency_db.district " +
            "where id_province = ?1", nativeQuery = true)
    List<District> getAllDistrictByIdProvince(Integer id_province);

    @Query(value = "select id from is_agency_db.district\n" +
            "where id_province = (select p.id from is_agency_db.group as g \n" +
                                "inner join is_agency_db.province as p on p.code_sale_executive = g.code_sale_executive\n" +
                                "inner join is_agency_db.group_member as m on g.id = m.id_group\n" +
                                "where m.code_sale = ?1)\n" +
                                "and code_sale = ?1", nativeQuery = true)
    List<Integer> getAllDistrictByCodeSale(String code_sale);

}
