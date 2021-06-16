package com.is.issystem.repository.entity_dto_repository;
import com.is.issystem.dto.EmployeeInfoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeInfoDTORepository extends JpaRepository<EmployeeInfoDTO,Integer>
{
    @Query(nativeQuery = true,value = "select ei.*,ea.code,ea.status,de.in_dept,\n" +
            "conadd_city , conadd_district,\n" +
            "conadd_no_street ,conadd_wards, \n" +
            "curadd_city ,curadd_district ,\n" +
            "curadd_no_street , curadd_wards,  \n" +
            "peradd_city,peradd_district,peradd_no_street,peradd_wards\n" +
            "from is_agency_db.employee_acc as ea\n" +
            "right join is_agency_db.employee_info as ei on ea.id = ei.id_acc\n" +
            "LEFT JOIN is_agency_db.current_address as ca on ei.id_current_address = ca.curadd_id\n" +
            "LEFT JOIN is_agency_db.contact_address as cad on ei.id_contact_address = cad.conadd_id\n" +
            "LEFT JOIN is_agency_db.permanent_address as pa on pa.peradd_id = ei.id_permanent_address\n" +
            "left join is_agency_db.department as de on de.id = ei.dept_id where ei.id = ?1 ")
    EmployeeInfoDTO getDetailEmployeeInfobyID(int id);

    @Query(nativeQuery = true,value = "select ei.*,ea.code,ea.status,de.in_dept,\n" +
            "conadd_city , conadd_district,\n" +
            "conadd_no_street ,conadd_wards, \n" +
            "curadd_city ,curadd_district ,\n" +
            "curadd_no_street , curadd_wards,  \n" +
            "peradd_city,peradd_district,peradd_no_street,peradd_wards\n" +
            "from is_agency_db.employee_acc as ea\n" +
            "right join is_agency_db.employee_info as ei on ea.id = ei.id_acc\n" +
            "\t\t\tLEFT JOIN is_agency_db.current_address as ca on ei.id_current_address = ca.curadd_id\n" +
            "            LEFT JOIN is_agency_db.contact_address as cad on ei.id_contact_address = cad.conadd_id\n" +
            "            LEFT JOIN is_agency_db.permanent_address as pa on pa.peradd_id = ei.id_permanent_address\n" +
            "left join is_agency_db.department as de on de.id = ei.dept_id where ea.code = ?1 ")
    EmployeeInfoDTO getDetailEmployeeInfobyCode(String code);

    @Query(value = "select ei.*,ea.code,ea.status,de.in_dept,\n" +
            "conadd_city , conadd_district,\n" +
            "conadd_no_street ,conadd_wards, \n" +
            "curadd_city ,curadd_district ,\n" +
            "curadd_no_street , curadd_wards,  \n" +
            "peradd_city,peradd_district,peradd_no_street,peradd_wards\n" +
            "from is_agency_db.employee_acc as ea\n" +
            "right join is_agency_db.employee_info as ei on ea.id = ei.id_acc\n" +
            "LEFT JOIN is_agency_db.current_address as ca on ei.id_current_address = ca.curadd_id\n" +
            "            LEFT JOIN is_agency_db.contact_address as cad on ei.id_contact_address = cad.conadd_id\n" +
            "            LEFT JOIN is_agency_db.permanent_address as pa on pa.peradd_id = ei.id_permanent_address\n" +
            "left join is_agency_db.department as de on de.id = ei.dept_id order by id desc",nativeQuery = true)
    List<EmployeeInfoDTO> getEmployeeInfo();

    @Query(value = "select ei.*,ea.code,ea.status,de.in_dept,\n" +
            "conadd_city , conadd_district,\n" +
            "conadd_no_street ,conadd_wards, \n" +
            "curadd_city ,curadd_district ,\n" +
            "curadd_no_street , curadd_wards,  \n" +
            "peradd_city,peradd_district,peradd_no_street,peradd_wards\n" +
            "from is_agency_db.employee_acc as ea\n" +
            "right join is_agency_db.employee_info as ei on ea.id = ei.id_acc\n" +
            "LEFT JOIN is_agency_db.current_address as ca on ei.id_current_address = ca.curadd_id\n" +
            "LEFT JOIN is_agency_db.contact_address as cad on ei.id_contact_address = cad.conadd_id\n" +
            "LEFT JOIN is_agency_db.permanent_address as pa on pa.peradd_id = ei.id_permanent_address\n" +
            "left join is_agency_db.department as de on de.id = ei.dept_id\n" +
            "where (ei.date_of_birth between ?1 and ?2)\n" +
            "and (ei.id LIKE ?3 or ei.name LIKE ?3 or ei.phone LIKE ?3 or ei.email LIKE ?3 or de.in_dept LIKE ?3 )\n" +
            "order by id desc",nativeQuery = true)
    List<EmployeeInfoDTO> searchEmployeeInfo(String dateFrom,String dateTo,String searchValue);
}
