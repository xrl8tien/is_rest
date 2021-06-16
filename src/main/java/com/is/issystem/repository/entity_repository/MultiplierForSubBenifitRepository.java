package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.MultiplierForSubBenifit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultiplierForSubBenifitRepository extends JpaRepository<MultiplierForSubBenifit,Integer> {
}
