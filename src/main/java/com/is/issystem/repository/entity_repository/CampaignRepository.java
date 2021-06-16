package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign,Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO `is_agency_db`.`campaign`\n" +
            "(`id_customer`,\n" +
            "`create_time`,\n" +
            "`end_time`)\n" +
            "VALUES\n" +
            "((select ci.id from customer_acc as ca INNER JOIN customer_info as ci ON ca.id = ci.id_account where ca.code = ?1 ),\n" +
            "NOW(), ?2 );",nativeQuery = true)
    void addOneCampaign(String code, String end_time);
}
