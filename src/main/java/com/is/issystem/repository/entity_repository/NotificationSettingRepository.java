package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.NotificationSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationSettingRepository extends JpaRepository<NotificationSetting, Integer> {
    @Query(value = "SELECT * FROM is_agency_db.notification_setting WHERE code_sale = ?1  ", nativeQuery = true)
    NotificationSetting getNotificationSettingByCode(String code_sale);
}
