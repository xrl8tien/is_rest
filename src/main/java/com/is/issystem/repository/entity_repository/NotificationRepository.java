package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    @Query(value = "select * from is_agency_db.notification where id_customer = ?1 order by id desc  ", nativeQuery = true)
    List<Notification> getAllNotificationByIdCustomer(Integer id_customer);
}
