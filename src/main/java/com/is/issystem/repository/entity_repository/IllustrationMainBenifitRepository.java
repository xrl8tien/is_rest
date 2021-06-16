package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.IllustrationMainBenifit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IllustrationMainBenifitRepository extends JpaRepository<IllustrationMainBenifit,Integer>
{
    @Query(value = "SELECT * FROM is_agency_db.illustration_main_benifit where illustration_main_benifit.id_illustration = ?1",nativeQuery = true)
    public IllustrationMainBenifit getIllustrationMainBenifitByillustID(Integer id_illust);
}
