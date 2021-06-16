package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.EmployeeAcc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeAccRepository extends JpaRepository<EmployeeAcc,Integer> {
    @Query(value = "SELECT  * FROM employee_acc where code = ?1",nativeQuery = true)
    EmployeeAcc getOneAcc(String code);

    @Modifying
    @Query(value = "UPDATE is_agency_db.employee_acc\n" +
            "SET\n" +
            "status = false\n" +
            "WHERE code = ?1",nativeQuery = true)
    void updateStatusEmployeeAcc(String code);

    @Query(value = "SELECT ea.* \n" +
            "FROM is_agency_db.employee_acc as ea \n" +
            "INNER JOIN employee_info as ei ON ei.id_acc = ea.id\n" +
            "WHERE ea.id_role = ?1 AND ei.code_ap_support = ?2 ",nativeQuery = true)
    public List<EmployeeAcc> getAllEmaccByIdRoleCodeApSpp(Integer id_role, String code_app_support);

    @Query(value = "SELECT * \n" +
            "FROM is_agency_db.employee_acc \n" +
            "WHERE id_role = ?1 ;",nativeQuery = true)
    public List<EmployeeAcc> getAllEmaccByIdRole(Integer id_role);


}
