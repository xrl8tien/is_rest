package com.is.issystem.repository.entity_repository;

import org.springframework.stereotype.Repository;


import com.is.issystem.entities.MultiplierForMainBenifit;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MultiplierForMainBenifitRepository extends JpaRepository<MultiplierForMainBenifit,Integer> {
}
