package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.SubBenefitScale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubBenefitScaleRepository extends JpaRepository<SubBenefitScale,Integer> {
    @Query(value = "SELECT * FROM is_agency_db.sub_benefit_scale " +
            "where sub_benefit_scale.id_sub_benefit = ?1",nativeQuery = true)
    public List<SubBenefitScale> getSubBenefitScaleBySubBenefitId(Integer id_sub_benefit);
}