package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.RequestClaimApprove;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestClaimRepository extends JpaRepository<RequestClaimApprove, Integer> {

    @Query(value = "select * from is_agency_db.request_claim_approve where status = 'DX' order by id desc  ", nativeQuery = true)
    public List<RequestClaimApprove> getAllUncheckManagerReq();

    @Query(value = "select * \n" +
            " from is_agency_db.request_claim_approve \n" +
            " where (status = 'DX' and date between ?1 and ?2)\n" +
            " and (id_contract LIKE ?3 or code_sender LIKE ?3 or name LIKE ?3 or main_benefit LIKE ?3 or sub_benefit LIKE ?3)\n" +
            " order by id desc ", nativeQuery = true)
    public List<RequestClaimApprove> searchAllUncheckManagerReq(String dateFrom, String dateTo, String searchValue);

    //
    @Query(value = "select * from is_agency_db.request_claim_approve where not status = 'DX' order by id desc ", nativeQuery = true)
    public List<RequestClaimApprove> getAllCheckManagerReq();

    @Query(value = "select * \n" +
            " from is_agency_db.request_claim_approve \n" +
            " where (not status = 'DX' and date between ?1 and ?2)\n" +
            " and (id_contract LIKE ?3 or code_sender LIKE ?3 or name LIKE ?3 or main_benefit LIKE ?3 or sub_benefit LIKE ?3)\n" +
            " order by id desc ", nativeQuery = true)
    public List<RequestClaimApprove> searchAllCheckManagerReq(String dateFrom, String dateTo, String searchValue);

}
