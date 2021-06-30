package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.MainBenifit;
import com.is.issystem.entities.SubBenefitScale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MainBenifitRepository extends JpaRepository<MainBenifit,Integer> {

}
