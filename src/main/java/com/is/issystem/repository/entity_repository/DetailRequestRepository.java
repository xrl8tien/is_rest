package com.is.issystem.repository.entity_repository;

import com.is.issystem.dto.CustomerDTO;
import com.is.issystem.dto.DetailRequestDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRequestRepository extends JpaRepository<DetailRequestDTO,Integer> {
    @Query(nativeQuery = true,value = "SELECT re.id as id_request,re.date as start_time,re.id_contract,ei.id as id_employee,re.status as request_status,\n" +
            "\tcont.id_illustration,\n" +
            "           customerinfo.*\n" +
            "\tFROM is_agency_db.request as re\n" +
            "\tINNER JOIN is_agency_db.contract as cont on cont.id = re.id_contract\n" +
            "\tINNER JOIN is_agency_db.employee_info as ei on ei.id = cont.id_employee \n" +
            "\tINNER JOIN \n" +
            "    (SELECT ci.*,code , status ,conadd_city , conadd_district \n" +
            "\t,conadd_no_street ,conadd_wards ,\n" +
            "\tcuradd_city ,curadd_district ,\n" +
            "\tcuradd_no_street , curadd_wards,  \n" +
            "\tperadd_city,peradd_district,peradd_no_street,peradd_wards,\n" +
            "\tworkadd_city,workadd_district,workadd_no_street,workadd_wards\n" +
            "\tFROM is_agency_db.customer_info as ci \n" +
            "\tINNER JOIN is_agency_db.customer_acc as ca on ci.id_account = ca.id \n" +
            "\tINNER JOIN contact_address as conadd ON conadd.conadd_id = ci.id_contact_address\n" +
            "\tINNER JOIN current_address as curadd ON curadd.curadd_id = ci.id_current_address \n" +
            "\tINNER JOIN permanent_address as peradd on peradd.peradd_id = ci.id_permanent_address \n" +
            "\tINNER JOIN workplace_address as workadd ON workadd.workadd_id = ci.id_workplace_address ) \n" +
            "AS customerinfo on cont.id_customer = customerinfo.id\n" +
            "WHERE re.id = ?1")
    DetailRequestDTO getRequestbyID(int id);

}
