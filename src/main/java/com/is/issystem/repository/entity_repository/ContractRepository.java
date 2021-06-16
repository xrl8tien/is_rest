package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract,Integer> {

    @Query(value = "SELECT * from is_agency_db.contract as ct where ct.id = ?1",nativeQuery = true)
    Contract getDetailContract(int id);

    @Modifying
    @Query(value = "UPDATE is_agency_db.contract\n" +
            "SET\n" +
            "code_em_support = ?1\n" +
            "WHERE code_em_support = ?2",nativeQuery = true)
    void updateEmployeeSupportContract(String codeEmployeeNew,String codeEmployeeOld);

    @Query(value = "SELECT count(*) FROM is_agency_db.contract where code_em_support = ?1 and month(create_time)=?2-1",nativeQuery = true)
    public Integer getAllContractCount(String code_em_support, Integer MonthDate);


}
