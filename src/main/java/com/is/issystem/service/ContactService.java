package com.is.issystem.service;

import com.is.issystem.dto.ContactInfoDTO;
import com.is.issystem.dto.DistrictDTO;
import com.is.issystem.entities.Contact;
import com.is.issystem.entities.District;
import com.is.issystem.entities.Province;
import com.is.issystem.entities.SaleDistrict;
import com.is.issystem.repository.entity_dto_repository.ContactInfoDTORepository;
import com.is.issystem.repository.entity_repository.ContactRepository;
import com.is.issystem.repository.entity_repository.DistrictRepository;
import com.is.issystem.repository.entity_repository.ProvinceRepository;
import com.is.issystem.repository.entity_repository.SaleDistrictRepository;
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
    @Autowired
    SaleDistrictRepository saleDistrictRepository;

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

    public String deleteAllSaleDistrict(String code_sale){
        saleDistrictRepository.deleteAll();
        return code_sale;
    }


    public DistrictDTO updateSaleDistrict(DistrictDTO districtDTO) {
        districtDTO.getCodes_sale().forEach(s -> {
            SaleDistrict saleDistrict = new SaleDistrict();
            saleDistrict.setId_district(districtDTO.getId());
            saleDistrict.setCode_sale(s);
            saleDistrictRepository.save(saleDistrict);
        });
        return districtDTO;
    }

    public String findDistrictById(Integer id) {
        return districtRepository.getDistrictNameByIdDistrict(id);
    }

}
