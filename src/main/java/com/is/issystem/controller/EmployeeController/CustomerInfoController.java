package com.is.issystem.controller.EmployeeController;

import com.is.issystem.commons.Ultility;
import com.is.issystem.dto.ContactDTO;
import com.is.issystem.dto.CustomerDTO;
import com.is.issystem.dto.CustomerInfoDTO;
import com.is.issystem.entities.Contact;
import com.is.issystem.entities.Contract;
import com.is.issystem.service.ContactService;
import com.is.issystem.service.CustomerInfoService;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = {"/api/customer"})
public class CustomerInfoController {
    @Autowired
    private CustomerInfoService customerInfoService;
    @Autowired
    private ContactService contactService;


    @PostMapping(value = "/get_all_customer")
    List<CustomerDTO> findAllCust(@RequestBody String code_em_support) {
        return customerInfoService.findAllCust(code_em_support);
    }


    @PostMapping(value = "/get_all_customer_info")
    List<CustomerDTO> findAll(@RequestBody String code_em_support) {
        return customerInfoService.findAll(code_em_support);
    }

    @PostMapping(value = "/get_all_customer_ex")
    List<CustomerDTO> findAllCustEx(@RequestBody List<String> codes_em_support) {
        return customerInfoService.findAllCustEx(codes_em_support);
    }


    @PostMapping(value = "/get_all_customer_info_ex")
    List<CustomerDTO> findAllEx(@RequestBody List<String> codes_em_support) {
        return customerInfoService.findAllEx(codes_em_support);
    }

    @PostMapping(value = "/search_all_customer_info_ex")
    List<CustomerDTO> searchAllCustomerEx(@RequestBody CustomerInfoDTO data) throws ParseException {
        return customerInfoService.findAllSearchEx(data.getCodes_saler(), data.getDateFrom(), data.getDateTo(), data.getSearchValue());
    }

    @PostMapping(value = "/search_all_customer_info")
    List<CustomerDTO> searchAllCustomer(@RequestBody String data) throws ParseException {
        JSONObject data1 = new JSONObject(data);
        return customerInfoService.findAllSearch(data1.get("code_em_support").toString(), data1.get("dateFrom").toString(), data1.get("dateTo").toString(), data1.get("searchValue").toString());
    }

    @GetMapping(value = "/get_all_customer_info_admin")
    List<CustomerDTO> getAllCustomerInfoAdmin() {
        return customerInfoService.getAllCustomerInfoAdmin();
    }

    @PostMapping(value = "/search_all_customer_info_admin")
    List<CustomerDTO> searchAllCustomerInfoAdmin(@RequestBody String data) {
        JSONObject infoObject = new JSONObject(data);
        return customerInfoService.searchAllCustomerInfoAdmin(infoObject.getString("dateFrom"), infoObject.getString("dateTo"), infoObject.getString("searchValue"));
    }


    @GetMapping(value = "/get_detail_customer_info_admin/{id}")
    public List<CustomerDTO> getAllContractHistory(@PathVariable("id") int id) {
        return customerInfoService.getOneInfo(id);
    }


    @PostMapping(value = "/update_one_customer_info")
    public ResponseEntity<?> updateOneCustomerInfo(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(customerInfoService.updateCustomerInfo(customerDTO));

    }

    @PostMapping(value = "/add_customer_info")
    public ResponseEntity<?> addOneCustomerInfo(@RequestBody CustomerDTO customerDTO) {
        boolean checkAdd = customerInfoService.addCustomerInfo(customerDTO);
        return ResponseEntity.status(HttpStatus.OK).body(checkAdd);
    }

    @PostMapping(value = "/get_one_customer_info")
    public ResponseEntity<?> getOneCustomerInfoForSaler(@RequestBody String data1) {
        JSONObject data = new JSONObject(data1);
        return ResponseEntity.status(HttpStatus.OK).body(customerInfoService.getOneInfo(Integer.parseInt(data.get("id").toString()), Ultility.getCodeInTokenKey(data.get("token_key").toString())));
    }

    @PostMapping(value = "/get_all_new_contact_by_district_ids")
    public List<Contact> getAllNewContactByDistrictIds(@RequestBody List<Integer> ids) {
        return contactService.getAllNewContactByDistrictIds(ids);
    }

    @PostMapping(value = "/search_all_new_contact")
    public List<Contact> searchAllNewContact(@RequestBody ContactDTO data) {
        return contactService.searchAllNewContact(data.getIds(), data.getDateFrom(), data.getDateTo(), data.getSearchValue());
    }

    @PostMapping(value = "/get_all_old_contact_by_district_ids")
    public List<Contact> getAllOldContactByDistrictIds(@RequestBody List<Integer> ids) {
        return contactService.getAllOldContactByDistrictIds(ids);
    }

    @PostMapping(value = "/search_all_old_contact")
    public List<Contact> searchAllOldContact(@RequestBody ContactDTO data) {
        return contactService.searchAllOldContact(data.getIds(), data.getDateFrom(), data.getDateTo(), data.getSearchValue());
    }

    @PostMapping(value = "/get_all_district_by_code_sale")
    public ResponseEntity<?> getAllDistrictByCodeSale(@RequestBody String code_sale) {
        return ResponseEntity.status(HttpStatus.OK).body(contactService.getAllDistrictByCodeSale(code_sale));
    }

    @PostMapping(value = "/get_district_name_by_id")
    public ResponseEntity<?> getDistrictNameById(@RequestBody List<Integer> ids) {
        return ResponseEntity.status(HttpStatus.OK).body(contactService.getDistrictNameById(ids));
    }

    @PostMapping(value = "/update_contact")
    public ResponseEntity<?> updateContact(@RequestBody String data) {
        JSONObject infoObject = new JSONObject(data);
        return ResponseEntity.status(HttpStatus.OK).body(contactService.updateContact(infoObject.getString("status"), Integer.parseInt(infoObject.get("id").toString())));
    }

    @PostMapping(value = "/get_all_code_sale_by_code_ex")
    public ResponseEntity<?> getAllCodeSaleByCodeEx(@RequestBody String code_ex) {
        return ResponseEntity.status(HttpStatus.OK).body(customerInfoService.getAllCodeSaleByCodeEx(code_ex));
    }

}
