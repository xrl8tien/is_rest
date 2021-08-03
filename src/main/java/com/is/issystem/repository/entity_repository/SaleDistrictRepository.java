package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.SaleDistrict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleDistrictRepository extends JpaRepository<SaleDistrict,Integer> {

    @Query(nativeQuery = true,value = "SELECT code_sale FROM is_agency_db.sale_district where id_district = ?1")
    public List<String> getAllCodeSaleByDistrictId(Integer id_district);
}
