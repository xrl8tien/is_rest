package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.RequestClaimDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RequestClaimDetailRepository extends JpaRepository<RequestClaimDetail, Integer> {
    @Query(value = "select * from is_agency_db.request_claim_detail where id_request = ?1", nativeQuery = true)
    public RequestClaimDetail getRequestClaimDetailById_request(Integer id_request);
}
