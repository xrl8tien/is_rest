package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.ContractChangeHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractChangeHistoryRepository extends JpaRepository<ContractChangeHistory, Integer> {
    @Query(nativeQuery = true,value = "SELECT * FROM is_agency_db.contract_change_history where id_contract = ?1")
    List<ContractChangeHistory> getAllContractChange(Integer id);
}


