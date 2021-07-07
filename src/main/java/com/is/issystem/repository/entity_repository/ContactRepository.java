package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    @Query(value = "select * from is_agency_db.contact " +
            "where province = ?1 order by id desc", nativeQuery = true)
    List<Contact> getAllContactByProvince(String province);
}
