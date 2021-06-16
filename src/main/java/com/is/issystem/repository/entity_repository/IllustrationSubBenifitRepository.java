package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.IllustrationSubBenifit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IllustrationSubBenifitRepository extends JpaRepository<IllustrationSubBenifit,Integer>
{
    @Query(value = "SELECT * FROM is_agency_db.illustration_sub_benifit where illustration_sub_benifit.id_illustration = ?1",nativeQuery = true)
    public List<IllustrationSubBenifit> getAllIllustrationSubByIllustID(Integer id_illust);
}
