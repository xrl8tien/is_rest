package com.is.issystem.service;

import com.is.issystem.commons.Ultility;
import com.is.issystem.dto.CustomerDTO;
import com.is.issystem.entities.*;
import com.is.issystem.repository.entity_dto_repository.CustomerDTORepository;
import com.is.issystem.repository.entity_repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerInfoService {
    @Autowired
    CustomerDTORepository customerDTORepository;

    @Autowired
    CustomerInfoRepository customerInfoRepository;

    @Autowired
    ContractRepository contractRepository;

    @Autowired
    PermanentAddressRepository permanentAddressRepository;

    @Autowired
    ContactAddressRepository contactAddressRepository;

    @Autowired
    CurrentAddressRepository currentAddressRepository;

    @Autowired
    WorkplaceRepository workplaceRepository;

    @Autowired
    CustomerAccRepository customerAccRepository;


    public Boolean updateCustomerInfo(CustomerDTO customerDTO){

        if(customerInfoRepository.checkDuplicateEmail(customerDTO.getId(),customerDTO.getEmail()).size() != 0){
            return false;
        }

        Optional<CustomerInfo> customerInfo = customerInfoRepository.findById(Math.toIntExact(customerDTO.getId()));
        customerInfo.get().setBirth_date(customerDTO.getBirth_date());
        customerInfo.get().setAge(customerDTO.getAge());
        customerInfo.get().setBirth_address(customerDTO.getBirth_address());
        customerInfo.get().setTypes_identification(customerDTO.getTypes_identification());
        customerInfo.get().setId_card(customerDTO.getId_card());
        customerInfo.get().setNationality_1(customerDTO.getNationality_1());
        customerInfo.get().setNationality_2(customerDTO.getNationality_2());
        customerInfo.get().setNation(customerDTO.getNation());
        customerInfo.get().setJob(customerDTO.getJob());
        customerInfo.get().setCareer(customerDTO.getCareer());
        customerInfo.get().setPosition(customerDTO.getPosition());
        customerInfo.get().setOccupation_group(customerDTO.getOccupation_group());
        customerInfo.get().setCompany_name(customerDTO.getCompany_name());
        customerInfo.get().setMain_business(customerDTO.getMain_business());
        customerInfo.get().setSpecific_work(customerDTO.getSpecific_work());
        customerInfo.get().setMonthly_income(customerDTO.getMonthly_income());
        customerInfo.get().setEmail(customerDTO.getEmail());
        customerInfo.get().setPhone_1(customerDTO.getPhone_1());
        customerInfo.get().setPhone_2(customerDTO.getPhone_2());
        customerInfo.get().setId_account(customerDTO.getId_account());
        customerInfo.get().setFull_name(customerDTO.getFull_name());
        customerInfo.get().setGender(customerDTO.getGender());
        customerInfo.get().setCode_em_support(customerDTO.getCode_em_support());
        customerInfo.get().setUpdated_time(new Date());
        customerInfo.get().setMarital_status(customerDTO.getMarital_status());
        customerInfo.get().setSource(customerDTO.getSource());




        Optional<ContactAddress> contactAddress = contactAddressRepository.findById(Math.toIntExact(customerDTO.getId_contact_address()));
        contactAddress.get().setConadd_city(customerDTO.getConadd_city());
        contactAddress.get().setConadd_district(customerDTO.getConadd_district());
        contactAddress.get().setConadd_no_street(customerDTO.getConadd_no_street());
        contactAddress.get().setConadd_wards(customerDTO.getConadd_wards());



        Optional<CurrentAddress> currentAddress = currentAddressRepository.findById(Math.toIntExact(customerDTO.getId_current_address()));
        currentAddress.get().setCuradd_city(customerDTO.getCuradd_city());
        currentAddress.get().setCuradd_district(customerDTO.getCuradd_district());
        currentAddress.get().setCuradd_no_street(customerDTO.getCuradd_no_street());
        currentAddress.get().setCuradd_wards(customerDTO.getCuradd_wards());



        Optional<PermanentAddress> permanentAddress = permanentAddressRepository.findById(Math.toIntExact(customerDTO.getId_permanent_address()));
        permanentAddress.get().setPeradd_city(customerDTO.getPeradd_city());
        permanentAddress.get().setPeradd_district(customerDTO.getPeradd_district());
        permanentAddress.get().setPeradd_no_street(customerDTO.getPeradd_no_street());
        permanentAddress.get().setPeradd_wards(customerDTO.getPeradd_wards());



        Optional<WorkplaceAddress> workplaceAddress = workplaceRepository.findById(Math.toIntExact(customerDTO.getId_workplace_address()));
        workplaceAddress.get().setWorkadd_city(customerDTO.getWorkadd_city());
        workplaceAddress.get().setWorkadd_district(customerDTO.getWorkadd_district());
        workplaceAddress.get().setWorkadd_no_street(customerDTO.getWorkadd_no_street());
        workplaceAddress.get().setWorkadd_wards(customerDTO.getWorkadd_wards());



        if(customerInfo != null && contactAddress != null && currentAddress != null && permanentAddress != null && workplaceAddress != null){
            customerInfoRepository.save(customerInfo.get());
            contactAddressRepository.save(contactAddress.get());
            currentAddressRepository.save(currentAddress.get());
            permanentAddressRepository.save(permanentAddress.get());
            workplaceRepository.save(workplaceAddress.get());
            return true;
        }
        return false;
    }

    public boolean addCustomerInfo(CustomerDTO customerDTO){
        List<CustomerInfo> customerInfos = customerInfoRepository.findAll();
        for (CustomerInfo customerInfo : customerInfos){
              if(customerInfo.getEmail().equals(customerDTO.getEmail()) || customerInfo.getId_card().equals(customerDTO.getId_card())) {
                  return false;
              }
        }

        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setBirth_date(customerDTO.getBirth_date());
        customerInfo.setAge(customerDTO.getAge());
        customerInfo.setBirth_address(customerDTO.getBirth_address());
        customerInfo.setTypes_identification(customerDTO.getTypes_identification());
        customerInfo.setId_card(customerDTO.getId_card());
        customerInfo.setNationality_1(customerDTO.getNationality_1());
        customerInfo.setNationality_2(customerDTO.getNationality_2());
        customerInfo.setNation(customerDTO.getNation());
        customerInfo.setJob(customerDTO.getJob());
        customerInfo.setCareer(customerDTO.getCareer());
        customerInfo.setPosition(customerDTO.getPosition());
        customerInfo.setOccupation_group(customerDTO.getOccupation_group());
        customerInfo.setCompany_name(customerDTO.getCompany_name());
        customerInfo.setMain_business(customerDTO.getMain_business());
        customerInfo.setSpecific_work(customerDTO.getSpecific_work());
        customerInfo.setMonthly_income(customerDTO.getMonthly_income());
        customerInfo.setEmail(customerDTO.getEmail());
        customerInfo.setPhone_1(customerDTO.getPhone_1());
        customerInfo.setPhone_2(customerDTO.getPhone_2());
        customerInfo.setCode_em_support(customerDTO.getCode_em_support());
        customerInfo.setFull_name(customerDTO.getFull_name());
        customerInfo.setGender(customerDTO.getGender());
        customerInfo.setCreated_time(new Date());
        customerInfo.setMarital_status(customerDTO.getMarital_status());
        customerInfo.setSource(customerDTO.getSource());

        // thêm acc tạm thời cho customer
        CustomerAcc customerAcc = new CustomerAcc();
        customerAcc.setStatus(false);
        customerAcc.setPass(Ultility.generatePassword(8));
        customerAccRepository.save(customerAcc);
        // lưu xong acc và lấy ID acc đó để dùng generate code cho khách
        Optional<CustomerAcc> customerAcc1 = customerAccRepository.findById(customerAcc.getId());
        customerAcc1.get().setCode(Ultility.generateAccCust(String.valueOf(customerAcc.getId())));
        customerAccRepository.save(customerAcc1.get());

        // lưu Id acc vào bảng customer_info cột Id_account
        customerInfo.setId_account(Long.valueOf(customerAcc.getId()));



        // thêm các địa chỉ cho khách hàng
        ContactAddress contactAddress = new ContactAddress();
        contactAddress.setConadd_city(customerDTO.getConadd_city());
        contactAddress.setConadd_district(customerDTO.getConadd_district());
        contactAddress.setConadd_no_street(customerDTO.getConadd_no_street());
        contactAddress.setConadd_wards(customerDTO.getConadd_wards());



        CurrentAddress currentAddress = new CurrentAddress();
        currentAddress.setCuradd_city(customerDTO.getCuradd_city());
        currentAddress.setCuradd_district(customerDTO.getCuradd_district());
        currentAddress.setCuradd_no_street(customerDTO.getCuradd_no_street());
        currentAddress.setCuradd_wards(customerDTO.getCuradd_wards());



        PermanentAddress permanentAddress = new PermanentAddress();
        permanentAddress.setPeradd_city(customerDTO.getPeradd_city());
        permanentAddress.setPeradd_district(customerDTO.getPeradd_district());
        permanentAddress.setPeradd_no_street(customerDTO.getPeradd_no_street());
        permanentAddress.setPeradd_wards(customerDTO.getPeradd_wards());



        WorkplaceAddress workplaceAddress = new WorkplaceAddress();
        workplaceAddress.setWorkadd_city(customerDTO.getWorkadd_city());
        workplaceAddress.setWorkadd_district(customerDTO.getWorkadd_district());
        workplaceAddress.setWorkadd_no_street(customerDTO.getWorkadd_no_street());
        workplaceAddress.setWorkadd_wards(customerDTO.getWorkadd_wards());



        if(customerInfo != null && contactAddress != null && currentAddress != null && permanentAddress != null && workplaceAddress != null){

            contactAddressRepository.save(contactAddress);
            customerInfo.setId_contact_address(contactAddress.getConadd_id());
            currentAddressRepository.save(currentAddress);
            customerInfo.setId_current_address(currentAddress.getCuradd_id());
            permanentAddressRepository.save(permanentAddress);
            customerInfo.setId_permanent_address(permanentAddress.getPeradd_id());
            workplaceRepository.save(workplaceAddress);
            customerInfo.setId_workplace_address(workplaceAddress.getWorkadd_id());

            customerInfoRepository.save(customerInfo);


        }
        return true;
    }

    public List<CustomerDTO> getOneInfo(Integer id,String code_em_suport){
        return customerDTORepository.getCustomerInfobyIDAndCodeEmSupport(id,code_em_suport);
    }

    public List<CustomerDTO> getOneInfo(Integer id){
        return customerDTORepository.getCustomerInfobyIdCustomer(id);
    }

    // query tất cả khách hàng và illustration, contract các khách hàng đó
    public List<CustomerDTO> findAll(String code_em_support) {
        return customerDTORepository.getAllCustomerInfo(code_em_support);
    }

    public List<CustomerDTO> findAllSearch(String code_em_support,String dateFrom,String dateTo,String searchValue) throws ParseException {

//        searchValue = "%"+searchValue+"%";
//        String dateFr = "1900/01/01";
//        String dateT = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
//        if(dateFrom=="null" && dateTo=="null"){
//            return customerDTORepository.getAllCustomerInfoSearch(code_em_support,dateFr,dateT,searchValue);
//        }
//         else if(dateTo=="null" || dateFrom=="null"){
//            return customerDTORepository.getAllCustomerInfoSearch(code_em_support,dateFrom=="null"?dateFr:dateFrom,dateTo=="null"?dateT:dateTo,searchValue);
//        } else {
//            return customerDTORepository.getAllCustomerInfoSearch(code_em_support,dateFrom,dateTo,searchValue);
//        }

        return customerDTORepository.getAllCustomerInfoSearch(code_em_support,dateFrom,dateTo,searchValue);

    }

    // query tất cả khách hàng nhưng không có illustration, contract các khách hàng đó
    public List<CustomerDTO> findAllCust(String code_em_support) {
        return customerDTORepository.getCustomerInfobySaler(code_em_support);
    }

    public List<CustomerDTO> getAllCustomerInfoAdmin() {
        return customerDTORepository.getAllCustomerInfoAdmin();
    }

    public List<CustomerDTO> searchAllCustomerInfoAdmin(String dateFrom,String dateTo,String searchValue) {
        return customerDTORepository.searchAllCustomerInfoAdmin(dateFrom,dateTo,searchValue);
    }


}
