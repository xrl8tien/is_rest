package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.ContactAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactAddressRepository extends JpaRepository<ContactAddress,Integer> {
}
