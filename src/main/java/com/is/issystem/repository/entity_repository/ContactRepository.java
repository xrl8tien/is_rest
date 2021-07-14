package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    @Query(value = "select * from is_agency_db.contact " +
            "where province = ?1 order by id desc", nativeQuery = true)
    List<Contact> getAllContactByProvince(String province);

    @Query(value = "select * from is_agency_db.contact " +
            " where status = 'kcj' and id_district in ?1 order by id desc", nativeQuery = true)
    List<Contact> getAllNewContactByDistrictIds(List<Integer> ids);

    @Query(value = "select * from is_agency_db.contact" +
            " where (status = 'kcj' and id_district in ?1 and create_time between ?2 and ?3)\n" +
            " and (customer_name LIKE ?4 or phone LIKE ?4)\n" +
            " order by id desc ", nativeQuery = true)
    public List<Contact> searchAllNewContact(List<Integer> ids, String dateFrom, String dateTo, String searchValue);

    @Modifying
    @Query(value = "UPDATE is_agency_db.contact SET status = ?1 WHERE id = ?2", nativeQuery = true)
    Void updateContact(String status, Integer id);

    @Query(value = "select * from is_agency_db.contact " +
            " where not status = 'kcj' and id_district in ?1 order by id desc", nativeQuery = true)
    List<Contact> getAllOldContactByDistrictIds(List<Integer> ids);

    @Query(value = "select * from is_agency_db.contact" +
            " where (not status = 'kcj' and id_district in ?1 and create_time between ?2 and ?3)\n" +
            " and (customer_name LIKE ?4 or phone LIKE ?4)\n" +
            " order by id desc ", nativeQuery = true)
    public List<Contact> searchAllOldContact(List<Integer> ids, String dateFrom, String dateTo, String searchValue);

}
