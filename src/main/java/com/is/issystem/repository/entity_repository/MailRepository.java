package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MailRepository extends JpaRepository<Mail, Integer> {


    public static final String getDetailMail = "select mail.id, \n" +
            "mail.title, \n" +
            "mail.content, \n" +
            "mail.time,\n" +
            "mail.priority,\n" +
            "mail.status,\n" +
            "(select name from is_agency_db.employee_info where is_agency_db.employee_info.id = mail.receiver_id) as receiver_name,\n" +
            "(select name from is_agency_db.employee_info where is_agency_db.employee_info.id = mail.sender_id) as sender_name\n" +
            "from is_agency_db.mail as mail\n" +
            "where mail.receiver_id = (select em_if.id from is_agency_db.employee_acc as em_acc, is_agency_db.employee_info as em_if\n" +
            "where em_acc.id = em_if.id \n" +
            "and \n" +
            "em_acc.code = ?1)\n" +
            "and mail.id = ?2";

    @Query(value = getDetailMail, nativeQuery = true)
    public Mail getDetailMail(String userCode, Integer mailId);

    @Modifying
    @Query(value = "insert into is_agency_db.mail (`title`, `sender_id`, `receiver_id`, `content`, `time`, `status`, `priority`) values " +
            "            (:title, " +
            "            (select id from is_agency_db.employee_acc as em_acc where em_acc.code = :senderNameCode)," +
            "            (select id from is_agency_db.employee_acc as em_acc where em_acc.code = :receiverNameCode)," +
            "            :content," +
            "            now()," +
            "            :status," +
            "            :priority)", nativeQuery = true)
    public Integer addNewMail(@Param("title") String title,
                              @Param("senderNameCode") String senderNameCode,
                              @Param("receiverNameCode") String receiverNameCode,
                              @Param("content") String content,
                              @Param("status") Integer status,
                              @Param("priority") Integer priority);
}
