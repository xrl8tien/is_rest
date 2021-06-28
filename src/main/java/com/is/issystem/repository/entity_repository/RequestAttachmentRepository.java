package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.CustomerAttachment;
import com.is.issystem.entities.RequestAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RequestAttachmentRepository extends JpaRepository<RequestAttachment, Integer> {
    @Query(nativeQuery = true,value = "SELECT * FROM is_agency_db.request_attachment where id_request = ?1 ;")
    public List<RequestAttachment> getRequestAttachment(Integer id_request);
}
