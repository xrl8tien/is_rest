package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.CurrentAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentAddressRepository extends JpaRepository<CurrentAddress,Integer> {
}
