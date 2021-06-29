package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.MainBenefitScale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MainBenefitScaleRepository extends JpaRepository<MainBenefitScale,Integer> {
    @Query(value = "SELECT * FROM is_agency_db.main_benefit_scale " +
            "where main_benefit_scale.id_main_benefit = ?1",nativeQuery = true)
    public List<MainBenefitScale> getMainBenefitScaleByMainBenefitId(Integer id_main_benefit);
}
