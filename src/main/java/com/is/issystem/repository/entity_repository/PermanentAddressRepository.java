package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.PermanentAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermanentAddressRepository extends JpaRepository<PermanentAddress,Integer> {
}
