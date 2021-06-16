package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.MainBenifit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainBenifitRepository extends JpaRepository<MainBenifit,Integer> {

}
