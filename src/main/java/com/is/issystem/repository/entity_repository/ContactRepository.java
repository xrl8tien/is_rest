package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    //province
    @Query(value = "select c.id,c.customer_name,c.phone,c.id_province,c.id_district,c.question,c.status,c.create_time,d.code_sale \n" +
            "from is_agency_db.contact as c inner join is_agency_db.district as d on d.id = c.id_district\n" +
            "where c.status = 'kcj' and c.id_province = ?1 order by c.create_time desc", nativeQuery = true)
    List<Contact> getAllNewContactByIdProvince(Integer id_province);

    @Query(value = "select c.id,c.customer_name,c.phone,c.id_province,c.id_district,c.question,c.status,c.create_time,d.code_sale \n" +
            "from is_agency_db.contact as c inner join is_agency_db.district as d on d.id = c.id_district\n" +
            " where (c.status = 'kcj' and c.id_province = ?1 and c.create_time between ?2 and ?3)\n" +
            " and (c.customer_name LIKE ?4 or c.phone LIKE ?4 or c.question LIKE ?4)\n" +
            " order by c.create_time desc ", nativeQuery = true)
    List<Contact> searchAllNewContactByIdProvince(Integer id_province, String dateFrom, String dateTo, String searchValue);

    @Query(value = "select c.id,c.customer_name,c.phone,c.id_province,c.id_district,c.question,c.status,c.create_time,c.code_sale \n" +
            "from is_agency_db.contact as c inner join is_agency_db.district as d on d.id = c.id_district\n" +
            "where not c.status = 'kcj' and c.id_province = ?1 order by c.create_time desc", nativeQuery = true)
    List<Contact> getAllOldContactByIdProvince(Integer id_province);

    @Query(value = "select c.id,c.customer_name,c.phone,c.id_province,c.id_district,c.question,c.status,c.create_time,c.code_sale \n" +
            "from is_agency_db.contact as c inner join is_agency_db.district as d on d.id = c.id_district\n" +
            " where (not c.status = 'kcj' and c.id_province = ?1 and c.create_time between ?2 and ?3)\n" +
            " and (c.customer_name LIKE ?4 or c.phone LIKE ?4 or c.question LIKE ?4)\n" +
            " order by c.create_time desc ", nativeQuery = true)
    List<Contact> searchAllOldContactByIdProvince(Integer id_province, String dateFrom, String dateTo, String searchValue);


    //district
    @Query(value = "select c.id,c.customer_name,c.phone,c.id_province,c.id_district,c.question,c.status,c.create_time,d.code_sale \n" +
            "from is_agency_db.contact as c inner join is_agency_db.district as d on d.id = c.id_district\n" +
            "where c.status = 'kcj' and c.id_district in ?1 order by c.create_time desc", nativeQuery = true)
    List<Contact> getAllNewContactByDistrictIds(List<Integer> ids);

    @Query(value = "select c.id,c.customer_name,c.phone,c.id_province,c.id_district,c.question,c.status,c.create_time,d.code_sale \n" +
            "from is_agency_db.contact as c inner join is_agency_db.district as d on d.id = c.id_district\n" +
            " where (c.status = 'kcj' and c.id_district in ?1 and c.create_time between ?2 and ?3)\n" +
            " and (c.customer_name LIKE ?4 or c.phone LIKE ?4 or c.question LIKE ?4)\n" +
            " order by c.create_time desc ", nativeQuery = true)
    List<Contact> searchAllNewContact(List<Integer> ids, String dateFrom, String dateTo, String searchValue);

    @Query(value = "select c.id,c.customer_name,c.phone,c.id_province,c.id_district,c.question,c.status,c.create_time,d.code_sale \n" +
            "from is_agency_db.contact as c inner join is_agency_db.district as d on d.id = c.id_district\n" +
            "where not c.status = 'kcj' and c.id_district in ?1 order by c.create_time desc", nativeQuery = true)
    List<Contact> getAllOldContactByDistrictIds(List<Integer> ids);

    @Query(value = "select c.id,c.customer_name,c.phone,c.id_province,c.id_district,c.question,c.status,c.create_time,d.code_sale \n" +
            "from is_agency_db.contact as c inner join is_agency_db.district as d on d.id = c.id_district\n" +
            " where (not c.status = 'kcj' and c.id_district in ?1 and c.create_time between ?2 and ?3)\n" +
            " and (c.customer_name LIKE ?4 or c.phone LIKE ?4 or c.question LIKE ?4)\n" +
            " order by c.create_time desc ", nativeQuery = true)
    List<Contact> searchAllOldContact(List<Integer> ids, String dateFrom, String dateTo, String searchValue);

}
