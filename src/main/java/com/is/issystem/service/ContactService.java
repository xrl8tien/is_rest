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

    public List<Contact> getAllContactByProvince(String province) {
        return contactRepository.getAllContactByProvince(province);
    }

    public Contact addOneContact(Contact contact) {
        return contactRepository.save(contact);
    }

}
