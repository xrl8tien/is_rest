package com.is.issystem.repository.entity_dto_repository;

import com.is.issystem.dto.ContractDTO;
import com.is.issystem.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractDTORepository extends JpaRepository<ContractDTO,Integer> {
    @Query(nativeQuery = true,value = "SELECT c.*,ca.code FROM is_agency_db.contract as c inner join customer_info as ci \n" +
            "on ci.id = c.id_customer inner join customer_acc as ca on ca.id = ci.id_account where c.code_em_support = ?1 order by id desc")
    public List<ContractDTO> getAllContractDTO(String code_em_support);

    @Query(nativeQuery = true,value = "SELECT c.*,ca.code \n" +
            "            FROM is_agency_db.contract as c inner join customer_info as ci \n" +
            "            on ci.id = c.id_customer inner join customer_acc as ca on ca.id = ci.id_account\n" +
            "            where (ci.code_em_support=?1 and (start_time >= ?2 and end_time <= ?3))\n" +
            "            and (c.id LIKE ?4 or id_customer LIKE ?4 or name_contract_owner LIKE ?4 or insurance_type LIKE ?4 or id_main_benifit LIKE ?4 or id_illustration LIKE ?4  )\n" +
            "            order by id desc")
    public List<ContractDTO> searchAllContractDTO(String code_em_support,String dateFrom,String dateTo,String searchValue);

    @Query(nativeQuery = true,value = "SELECT c.*,ca.code FROM is_agency_db.contract as c inner join customer_info as ci \n" +
            "on ci.id = c.id_customer inner join customer_acc as ca on ca.id = ci.id_account where c.code_em_support = ?1 and c.id = ?2 order by id desc")
    public ContractDTO getDetailContractForSaler(String code, Integer id);

    @Query(nativeQuery = true,value = "SELECT c.*,ca.code FROM is_agency_db.contract as c inner join customer_info as ci \n" +
            "on ci.id = c.id_customer inner join customer_acc as ca on ca.id = ci.id_account where c.id = ?1 order by id desc")
    public ContractDTO getDetailContractForCustomer(Integer id);

    @Query(nativeQuery = true,value = "SELECT c.*,ca.code FROM is_agency_db.contract as c inner join customer_info as ci \n" +
            "on ci.id = c.id_customer inner join customer_acc as ca on ca.id = ci.id_account where c.id_customer = ?1 order by id desc")
    public List<ContractDTO> getAllContractDTOForCustomer(Integer id_customer);

    @Query(nativeQuery = true,value = "SELECT c.*,ca.code \n" +
            "FROM is_agency_db.contract as c \n" +
            "inner join customer_info as ci on ci.id = c.id_customer \n" +
            "inner join customer_acc as ca on ca.id = ci.id_account \n" +
            "where (c.id_customer = ?1 and c.start_time >= ?2 and c.start_time <= ?3 )\n" +
            "and (c.id LIKE ?4 or c.id_customer LIKE ?4 or c.name_contract_owner LIKE ?4 or c.insurance_type LIKE ?4 or c.id_illustration LIKE ?4)\n" +
            "order by id desc")
    public List<ContractDTO> searchAllContractDTOForCustomer(int id,String dateFrom,String dateTo,String searchValue);
}
