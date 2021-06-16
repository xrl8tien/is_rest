package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.WorkplaceAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkplaceRepository extends JpaRepository<WorkplaceAddress,Integer> {
}
