package com.is.issystem.service;

import com.is.issystem.entities.Contact;
import com.is.issystem.entities.District;
import com.is.issystem.entities.Province;
import com.is.issystem.repository.entity_repository.ContactRepository;
import com.is.issystem.repository.entity_repository.DistrictRepository;
import com.is.issystem.repository.entity_repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    DistrictRepository districtRepository;
    @Autowired
    ProvinceRepository provinceRepository;
    @Autowired
    ContactRepository contactRepository;

    public List<Province> getAllProvince() {
        return provinceRepository.findAll();
    }

    public List<District> getAllDistrictByIdProvince(Integer id_province) {
        return districtRepository.getAllDistrictByIdProvince(id_province);
    }

    public List<Integer> getAllDistrictByCodeSale(String code_sale) {
        return districtRepository.getAllDistrictByCodeSale(code_sale);
    }

    public List<Contact> getAllContactByProvince(String province) {
        return contactRepository.getAllContactByProvince(province);
    }

    public List<Contact> getAllNewContactByDistrictIds(List<Integer> ids) {
        return contactRepository.getAllNewContactByDistrictIds(ids);
    }

    public List<Contact> searchAllNewContact(List<Integer> ids, String dateFrom, String dateTo, String searchValue) {
        return contactRepository.searchAllNewContact(ids, dateFrom, dateTo, searchValue);
    }

    public List<Contact> getAllOldContactByDistrictIds(List<Integer> ids) {
        return contactRepository.getAllOldContactByDistrictIds(ids);
    }

    public List<Contact> searchAllOldContact(List<Integer> ids, String dateFrom, String dateTo, String searchValue) {
        return contactRepository.searchAllOldContact(ids, dateFrom, dateTo, searchValue);
    }

    public Contact addOneContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact updateContact(String status, Integer id) {
        Optional<Contact> contact = contactRepository.findById(id);
        contact.get().setStatus(status);
        return contactRepository.save(contact.get());
    }

}
