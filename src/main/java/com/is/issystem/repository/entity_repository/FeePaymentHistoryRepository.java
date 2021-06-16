package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.ContractChangeHistory;
import com.is.issystem.entities.FeePaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeePaymentHistoryRepository extends JpaRepository<FeePaymentHistory,Integer> {
    @Query(nativeQuery = true,value = "SELECT * FROM is_agency_db.fee_payment_history WHERE id_contract = ?1")
    List<FeePaymentHistory> getAllFeePayment(int id);
}
