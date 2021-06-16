package com.is.issystem.repository.entity_repository;
import com.is.issystem.entities.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeInfoRepository extends JpaRepository<EmployeeInfo,Integer> {
    @Query(value = "SELECT  * FROM employee_info where id_acc = ?1",nativeQuery = true)
    EmployeeInfo getOneEmployeeInfo(int id_acc);

    @Query(value = "SELECT  * FROM employee_info ",nativeQuery = true)
    List<EmployeeInfo> getAllEmployeeInfo();

    @Query(value = "SELECT * FROM is_agency_db.employee_info where id != ? and email = ? ",nativeQuery = true)
    List<EmployeeInfo> checkDupEmail(Integer id_em_info, String email);
}
