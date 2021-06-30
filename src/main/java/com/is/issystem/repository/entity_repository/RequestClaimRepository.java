package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.RequestClaimApprove;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestClaimRepository extends JpaRepository<RequestClaimApprove, Integer> {
}
