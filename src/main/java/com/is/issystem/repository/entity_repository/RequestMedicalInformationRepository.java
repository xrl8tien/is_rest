package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.RequestMedicalInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RequestMedicalInformationRepository extends JpaRepository<RequestMedicalInformation, Integer> {
    @Query(value = "select * from is_agency_db.request_medical_information where id_request_claim_detail = ?1", nativeQuery = true)
    public List<RequestMedicalInformation> getListReqMedInfoById_req_claim_detail(Integer id_request_claim_detail);
}
