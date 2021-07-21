package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IncomeRepository extends JpaRepository<Income,Integer> {
    @Query(nativeQuery = true,
            value = "SELECT ct.id,mfpp.description,rv.income,rv.revenue_val,ct.start_time,ct.end_time,rv.create_time,ct.code_em_support FROM is_agency_db.contract as ct \n" +
                    "INNER JOIN is_agency_db.revenue as rv ON rv.id_contract = ct.id \n" +
                    "INNER JOIN is_agency_db.multiplier_for_payment_period as mfpp ON mfpp.id = ct.payment_period_id where code_em_support = ?1 and approval_status = 'DD'")
    List<Income> listIncome(String code_em_support);

    @Query(nativeQuery = true,
            value = "SELECT ct.id,mfpp.description,rv.income,rv.revenue_val,ct.start_time,ct.end_time,rv.create_time,ct.code_em_support FROM is_agency_db.contract as ct \n" +
                    "INNER JOIN is_agency_db.revenue as rv ON rv.id_contract = ct.id \n" +
                    "INNER JOIN is_agency_db.multiplier_for_payment_period as mfpp ON mfpp.id = ct.payment_period_id where code_em_support in ?1 and approval_status = 'DD'")
    List<Income> listIncomeEx(List<String> codes_em_support);
}
