package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request,Integer>{
    @Modifying
    @Query(nativeQuery = true,value = "UPDATE is_agency_db.request SET status = 'Đã xét duyệt' WHERE id_contract = ?1")
    Void updateContractRequest(int id);

    @Query(value = "select * from is_agency_db.request where status = 'CXD' and code_reciever = ?1 order by id desc  ",nativeQuery = true)
    public List<Request> getAllUncheckReq(String code);
    @Query(value = "select * \n" +
            " from is_agency_db.request \n" +
            " where (status = 'CXD' and code_reciever = ?1 and date between ?2 and ?3)\n" +
            " and (id_contract LIKE ?4 or code_sender LIKE ?4)\n" +
            " order by id desc ",nativeQuery = true)
    public List<Request> searchAllUncheckReq(String code,String dateFrom,String dateTo,String searchValue);

    @Query(value = "select * from is_agency_db.request where not status = 'CXD' and code_reciever = ?1 order by id desc ",nativeQuery = true)
    public List<Request> getAllCheckReq(String code);
    @Query(value = "select * \n" +
            " from is_agency_db.request \n" +
            " where (not status = 'CXD' and code_reciever = ?1 and date between ?2 and ?3)\n" +
            " and (id_contract LIKE ?4 or code_sender LIKE ?4)\n" +
            " order by id desc ",nativeQuery = true)
    public List<Request> searchAllCheckReq(String code,String dateFrom,String dateTo,String searchValue);
}
