package com.is.issystem.repository.entity_dto_repository;

import com.is.issystem.dto.MailDTO;
import com.is.issystem.entities.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MailDTORepository extends JpaRepository<MailDTO,Integer> {
    @Query(value = "select mail.id, mail.title, \n" +
            "mail.priority,\n" +
            "mail.status,\n" +
            "em_info.name ,\n" +
            "mail.content,\n" +
            "mail.time,\n" +
            "mail.receiver_id,\n" +
            "mail.sender_id,\n" +
            "em_acc.code\n" +
            "from is_agency_db.mail as mail, is_agency_db.employee_info as em_info,is_agency_db.employee_acc as em_acc\n" +
            "where \n" +
            "mail.receiver_id = \n" +
            "(select id from is_agency_db.employee_acc as em_acc where em_acc.code = ?1 )\n" +
            "and mail.sender_id = em_info.id_acc\n" +
            "and em_acc.id = em_info.id_acc order by id desc ", nativeQuery = true)
    public List<MailDTO> getAllMailReceived(String code);

    @Query(value = "select mail.id, mail.title, \n" +
            "            mail.priority,\n" +
            "            mail.status,\n" +
            "            em_info.name ,\n" +
            "            mail.content,\n" +
            "            mail.time,\n" +
            "            mail.receiver_id,\n" +
            "            mail.sender_id,\n" +
            "            em_acc.code\n" +
            "            from is_agency_db.mail as mail, is_agency_db.employee_info as em_info,is_agency_db.employee_acc as em_acc\n" +
            "            where \n" +
            "            mail.sender_id = em_info.id_acc\n" +
            "            and em_acc.id = em_info.id_acc \n" +
            "            and mail.id = ?1\n" +
            "            order by id desc ", nativeQuery = true)
    public MailDTO getDetailMail(int id);


    @Query(value = "select mail.id, mail.title, \n" +
            "mail.priority,\n" +
            "mail.status,\n" +
            "em_info.name ,\n" +
            "mail.content,\n" +
            "mail.time,\n" +
            "mail.receiver_id,\n" +
            "mail.sender_id,\n" +
            "em_acc.code\n" +
            "from is_agency_db.mail as mail, is_agency_db.employee_info as em_info,is_agency_db.employee_acc as em_acc\n" +
            "where (mail.receiver_id = (select id from is_agency_db.employee_acc as em_acc where em_acc.code = ?1 ) and mail.time between ?2 and ?3)\n" +
            "and mail.sender_id = em_info.id_acc\n" +
            "and em_acc.id = em_info.id_acc\n" +
            "and (mail.id LIKE ?4 or  mail.title LIKE ?4 or em_acc.code LIKE ?4 or em_info.name  LIKE ?4 )\n" +
            "order by id desc  ", nativeQuery = true)
    public List<MailDTO> searchAllMailReceived(String code,String dateFrom,String dateTo,String searchValue);



    @Query(value = "select mail.id, mail.title, \n" +
            "mail.priority,\n" +
            "mail.status,\n" +
            "em_info.name,\n" +
            "mail.content,\n" +
            "mail.time,\n" +
            "mail.receiver_id,\n" +
            "mail.sender_id,\n" +
            "em_acc.code\n" +
            "from is_agency_db.mail as mail, is_agency_db.employee_info as em_info,is_agency_db.employee_acc as em_acc\n" +
            "where \n" +
            "mail.sender_id = \n" +
            "(select id from is_agency_db.employee_acc as em_acc where em_acc.code = ?1 )\n" +
            "and mail.receiver_id = em_info.id_acc\n" +
            "and em_acc.id = em_info.id_acc order by id desc", nativeQuery = true)
    public List<MailDTO> getAllMailSent(String code);



    @Query(value = "select mail.id, mail.title, \n" +
            "mail.priority,\n" +
            "mail.status,\n" +
            "em_info.name,\n" +
            "mail.content,\n" +
            "mail.time,\n" +
            "mail.receiver_id,\n" +
            "mail.sender_id,\n" +
            "em_acc.code\n" +
            "from is_agency_db.mail as mail, is_agency_db.employee_info as em_info,is_agency_db.employee_acc as em_acc\n" +
            "where (mail.sender_id = (select id from is_agency_db.employee_acc as em_acc where em_acc.code = ?1) and mail.time between ?2 and ?3 )\n" +
            "and mail.receiver_id = em_info.id_acc\n" +
            "and em_acc.id = em_info.id_acc \n" +
            "and (mail.id LIKE ?4 or  mail.title LIKE ?4 or em_acc.code LIKE ?4 or em_info.name  LIKE ?4 )\n" +
            "order by id desc", nativeQuery = true)
    public List<MailDTO> searchAllMailSent(String code,String dateFrom,String dateTo,String searchValue);
}
