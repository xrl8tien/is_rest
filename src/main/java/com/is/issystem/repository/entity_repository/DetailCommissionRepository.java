package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.DetailCommission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface DetailCommissionRepository extends JpaRepository<DetailCommission,Integer> {
    @Query(value = "SELECT * FROM is_agency_db.detail_commission where id_detail_payment_period = ?1 \n" +
            "and ?2 between price_insurance_lowerbound and price_insurance_upperbound ;",nativeQuery = true)
    public DetailCommission getOneDetaiCommisson(Integer payment_period_id,BigInteger denomination);
}
