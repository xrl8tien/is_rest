package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.BenifitPaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BenifitPaymentHistoryRepository extends JpaRepository<BenifitPaymentHistory,Integer> {
    @Query(nativeQuery = true,value = "SELECT * FROM is_agency_db.interset_payment_history WHERE id_contract = ?1")
    List<BenifitPaymentHistory> getAllIntersetPayment(int id);
}
