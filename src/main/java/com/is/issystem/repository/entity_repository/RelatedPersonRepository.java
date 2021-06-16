package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.RelatedPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelatedPersonRepository extends JpaRepository<RelatedPerson,Integer> {

}
