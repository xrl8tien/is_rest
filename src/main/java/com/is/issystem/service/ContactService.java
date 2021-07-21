package com.is.issystem.service;

import com.is.issystem.dto.ContactInfoDTO;
import com.is.issystem.entities.Contact;
import com.is.issystem.entities.District;
import com.is.issystem.entities.Province;
import com.is.issystem.repository.entity_dto_repository.ContactInfoDTORepository;
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
    @Autowired
    ContactInfoDTORepository contactInfoDTORepository;

    public List<Province> getAllProvince() {
        return provinceRepository.findAll();
    }

    public List<District> getAllDistrictByIdProvince(Integer id_province) {
        return districtRepository.getAllDistrictByIdProvince(id_province);
    }

    public Province getProvinceByCodeEx(String code_sale_executive) {
        return provinceRepository.getProvinceByCodeEx(code_sale_executive);
    }

    public List<Integer> getAllDistrictByCodeSale(String code_sale) {
        return districtRepository.getAllDistrictByCodeSale(code_sale);
    }

    public List<District> getDistrictNameById(List<Integer> ids) {
        return districtRepository.getDistrictNameById(ids);
    }

    public List<ContactInfoDTO> getAllNewContactByProvince(Integer id_province) {
        return contactInfoDTORepository.getAllNewContactByIdProvince(id_province);
    }

    public List<ContactInfoDTO> searchAllNewContactByIdProvince(Integer id_province, String dateFrom, String dateTo, String searchValue) {
        return contactInfoDTORepository.searchAllNewContactByIdProvince(id_province, dateFrom, dateTo, searchValue);
    }

    public List<ContactInfoDTO> getAllOldContactByProvince(Integer id_province) {
        return contactInfoDTORepository.getAllOldContactByIdProvince(id_province);
    }

    public List<ContactInfoDTO> searchAllOldContactByIdProvince(Integer id_province, String dateFrom, String dateTo, String searchValue) {
        return contactInfoDTORepository.searchAllOldContactByIdProvince(id_province, dateFrom, dateTo, searchValue);
    }

    public List<ContactInfoDTO> getAllNewContactByDistrictIds(List<Integer> ids) {
        return contactInfoDTORepository.getAllNewContactByDistrictIds(ids);
    }

    public List<ContactInfoDTO> searchAllNewContact(List<Integer> ids, String dateFrom, String dateTo, String searchValue) {
        return contactInfoDTORepository.searchAllNewContact(ids, dateFrom, dateTo, searchValue);
    }

    public List<ContactInfoDTO> getAllOldContactByDistrictIds(List<Integer> ids) {
        return contactInfoDTORepository.getAllOldContactByDistrictIds(ids);
    }

    public List<ContactInfoDTO> searchAllOldContact(List<Integer> ids, String dateFrom, String dateTo, String searchValue) {
        return contactInfoDTORepository.searchAllOldContact(ids, dateFrom, dateTo, searchValue);
    }

    public Contact addOneContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact updateContact(String code_sale, String status, Integer id) {
        Optional<Contact> contact = contactRepository.findById(id);
        contact.get().setCode_sale(code_sale);
        contact.get().setStatus(status);
        return contactRepository.save(contact.get());
    }

    public District updateDistrict(District district) {
        Optional<District> district1 = districtRepository.findById(district.getId());
        district1.get().setCode_sale(district.getCode_sale());
        return districtRepository.save(district1.get());
    }

    public String findDistrictById(Integer id) {
        return districtRepository.getDistrictNameByIdDistrict(id);
    }

}
