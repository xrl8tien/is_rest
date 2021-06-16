package com.is.issystem.repository.entity_repository;

import com.is.issystem.dto.CustomerDTO;
import com.is.issystem.entities.Contract;
import com.is.issystem.entities.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerInfoRepository extends JpaRepository<CustomerInfo,Integer>{
    @Modifying
    @Query(value = "UPDATE is_agency_db.customer_info\n" +
            "SET\n" +
            "code_em_support= ?1\n" +
            "WHERE code_em_support = ?2",nativeQuery = true)
    void updateEmployeeSupportCustomerInfo(String codeEmployeeNew, String codeEmployeeOld);

    @Query (nativeQuery = true, value = "select * from customer_info where id != ? and email = ? ")
    List<CustomerInfo> checkDuplicateEmail(Long id_infor, String email);
}
