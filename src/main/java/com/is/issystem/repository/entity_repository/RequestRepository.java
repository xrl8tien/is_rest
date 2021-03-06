package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {
    //contract request
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE is_agency_db.request SET status = 'Đã xét duyệt' WHERE id_contract = ?1")
    Void updateContractRequest(int id);

    @Query(value = "select * from is_agency_db.request where status = 'CXD' and id_type = 1 and code_reciever = ?1 order by id desc  ", nativeQuery = true)
    public List<Request> getAllUncheckReq(String code);

    @Query(value = "select * \n" +
            " from is_agency_db.request \n" +
            " where (status = 'CXD' and id_type = 1 and code_reciever = ?1 and date between ?2 and ?3)\n" +
            " and (id_contract LIKE ?4 or code_sender LIKE ?4)\n" +
            " order by id desc ", nativeQuery = true)
    public List<Request> searchAllUncheckReq(String code, String dateFrom, String dateTo, String searchValue);

    @Query(value = "select * from is_agency_db.request where not status = 'CXD' and id_type = 1 and code_reciever = ?1 order by id desc ", nativeQuery = true)
    public List<Request> getAllCheckReq(String code);

    @Query(value = "select * \n" +
            " from is_agency_db.request \n" +
            " where (not status = 'CXD' and id_type = 1 and code_reciever = ?1 and date between ?2 and ?3)\n" +
            " and (id_contract LIKE ?4 or code_sender LIKE ?4)\n" +
            " order by id desc ", nativeQuery = true)
    public List<Request> searchAllCheckReq(String code, String dateFrom, String dateTo, String searchValue);

    //claim request
    @Query(value = "select * from is_agency_db.request where status = 'CXD' and id_type = 2 order by id desc  ", nativeQuery = true)
    public List<Request> getAllUncheckClaimReq();

    @Query(value = "select * \n" +
            " from is_agency_db.request \n" +
            " where (status = 'CXD' and id_type = 2 and date between ?1 and ?2)\n" +
            " and (id_contract LIKE ?3 or code_sender LIKE ?3)\n" +
            " order by id desc ", nativeQuery = true)
    public List<Request> searchAllUncheckClaimReq(String dateFrom, String dateTo, String searchValue);

    //
    @Query(value = "select * from is_agency_db.request where not status = 'CXD' and not status = 'DD' and id_type = 2 order by id desc ", nativeQuery = true)
    public List<Request> getAllCheckClaimReq();

    @Query(value = "select * \n" +
            " from is_agency_db.request \n" +
            " where (not status = 'CXD'and not status = 'DD' and id_type = 2 and date between ?1 and ?2)\n" +
            " and (id_contract LIKE ?3 or code_sender LIKE ?3)\n" +
            " order by id desc ", nativeQuery = true)
    public List<Request> searchAllCheckClaimReq(String dateFrom, String dateTo, String searchValue);

    //
    @Query(value = "select * from is_agency_db.request where status = 'DD' and id_type = 2 order by id desc  ", nativeQuery = true)
    public List<Request> getAllApprovedClaimReq();

    @Query(value = "select * \n" +
            " from is_agency_db.request \n" +
            " where (status = 'DD' and id_type = 2 and date between ?1 and ?2)\n" +
            " and (id_contract LIKE ?3 or code_sender LIKE ?3)\n" +
            " order by id desc ", nativeQuery = true)
    public List<Request> searchAllApprovedClaimReq(String dateFrom, String dateTo, String searchValue);

    //customer
    @Query(value = "select * from is_agency_db.request where code_sender = ?1 and id_type = 2 order by id desc  ", nativeQuery = true)
    public List<Request> getAllCustomerClaimReq(String code);

    @Query(value = "select * \n" +
            " from is_agency_db.request \n" +
            " where (id_type = 2 and code_sender = ?1 and date between ?2 and ?3)\n" +
            " and (id_contract LIKE ?4 or code_sender LIKE ?4)\n" +
            " order by id desc ", nativeQuery = true)
    public List<Request> searchAllCustomerClaimReq(String code, String dateFrom, String dateTo, String searchValue);

    //manager

}
