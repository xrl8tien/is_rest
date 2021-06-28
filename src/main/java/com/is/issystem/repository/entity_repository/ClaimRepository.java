package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClaimRepository extends JpaRepository<Request, Integer> {

    //claim request
    @Query(value = "select * from is_agency_db.claim_request where status = 'CXD' order by id desc  ", nativeQuery = true)
    public List<Request> getAllUncheckClaim();

    @Query(value = "select * \n" +
            " from is_agency_db.claim_request \n" +
            " where (status = 'CXD' and date between ?1 and ?2)\n" +
            " and (name LIKE ?3 or code_sender LIKE ?3)\n" +
            " order by id desc ", nativeQuery = true)
    public List<Request> searchAllUncheckClaim(String dateFrom, String dateTo, String searchValue);

    @Query(value = "select * from is_agency_db.claim_request where not status = 'CXD' order by id desc ", nativeQuery = true)
    public List<Request> getAllCheckClaim();

    @Query(value = "select * \n" +
            " from is_agency_db.claim_request \n" +
            " where (not status = 'CXD' and date between ?1 and ?2)\n" +
            " and (name LIKE ?3 or code_sender LIKE ?3)\n" +
            " order by id desc ", nativeQuery = true)
    public List<Request> searchAllCheckClaim(String dateFrom, String dateTo, String searchValue);

}
