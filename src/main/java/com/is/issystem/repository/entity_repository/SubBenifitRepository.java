package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.SubBenifit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubBenifitRepository extends JpaRepository<SubBenifit,Integer> {
}
