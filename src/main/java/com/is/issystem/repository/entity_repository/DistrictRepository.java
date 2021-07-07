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
}
