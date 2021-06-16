package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.CustomerAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerAttachmentRepository extends JpaRepository<CustomerAttachment,Integer> {
    @Query(nativeQuery = true,value = "SELECT * FROM is_agency_db.customer_attachment where id_contract = ?1 ;")
    public List<CustomerAttachment> getCustomerAttachemnt(Integer id_contract);
}
