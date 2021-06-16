package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository  extends JpaRepository<Attachment,Integer> {

}
