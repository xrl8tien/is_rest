package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Integer> {
    @Query(value = "select * from is_agency_db.province " +
            "where code_sale_executive = ?1", nativeQuery = true)
    Province getProvinceByCodeEx(String code_sale_executive);
}
