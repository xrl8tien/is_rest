package com.is.issystem.controller.CustomerController;

import com.google.cloud.storage.Storage;
import com.is.issystem.commons.Ultility;
import com.is.issystem.dto.ContractDTO;
import com.is.issystem.dto.IllustrationDTO;
import com.is.issystem.entities.*;
import com.is.issystem.service.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = {"/api/customer-api"})
public class CustomerController {
    @Autowired
    ReferenceTableService referenceTableService;

    @Autowired
    SubBenifitService subBenifitService;

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    ContractService contractService;

    @Autowired
    CustomerInfoService customerInfoService;

    @Autowired
    private CustomerAccService customerAccService;

    @Autowired
    private IllustrationService illustrationService;

    @Autowired
    private RequestService requestService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private Storage storage;

    @PostMapping(value = "/login")
    public ResponseEntity<?> loginCustomer(@RequestBody CustomerAcc data){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("token_customer",customerAccService.getAccountbyCodePass(data));
        return ResponseEntity.status(HttpStatus.OK).body(jsonObject.toString());
    }

    @PostMapping(value = "/contract-list")
    public ResponseEntity<?> getAllContractForCust(@RequestBody Integer id_Cust_Info){
        return ResponseEntity.status(HttpStatus.OK).body(contractService.getAllContractForCustomer(id_Cust_Info));
    }

    @PostMapping(value = "/search-contract-list")
    public ResponseEntity<?> searchAllContractForCust(@RequestBody String data){
        JSONObject contractObject = new JSONObject(data);
        return ResponseEntity.status(HttpStatus.OK).body(contractService.searchAllContractForCustomer(Integer.parseInt(contractObject.getString("id_customer")),contractObject.getString("dateFrom"),contractObject.getString("dateTo"),contractObject.getString("searchValue")));
    }

    @PostMapping(value = "/get_one_customer_info")
    public ResponseEntity<?> getOneCustomerInfoByIdCustomer(@RequestBody Integer id_cust_info){
        return ResponseEntity.status(HttpStatus.OK).body(customerInfoService.getOneInfo(id_cust_info));
    }

    @PostMapping(value = "/get_all_illustration_customer")
    public ResponseEntity<?> getAllIllustrationByIdCustomer(@RequestBody Integer id_cust_info){
        return ResponseEntity.status(HttpStatus.OK).body(illustrationService.getAllIllustration(id_cust_info));
    }

    @PostMapping(value = "/search_all_illustration_customer")
    public ResponseEntity<?> searchAllIllustrationByIdCustomer(@RequestBody String data){
        JSONObject customerObject = new JSONObject(data);
        return ResponseEntity.status(HttpStatus.OK).body(illustrationService.searchAllIllustration(Integer.parseInt(customerObject.getString("id_customer")),customerObject.getString("dateFrom"),customerObject.getString("dateTo"),customerObject.getString("searchValue")));
    }


    @PostMapping(value = "/get_detail_illustration/")
    IllustrationDTO getDetailIllustration(@RequestBody Integer id){
        return illustrationService.getDetailIllustration(id);
    }

    // lấy chi tiết hợp đồng của khách hàng ở trang của khách hàng
    @PostMapping(value = "/get_detail_contract_for_customer")
    ContractDTO getDetailContract(@RequestBody Integer data){
        return contractService.getDetailContractForCustomer(data);
    }

    @GetMapping(value = "/get_all_sub_benefit/{id}")
    List<IllustrationSubBenifit> getAllSubBenefitById(@PathVariable("id") int id) {
        return illustrationService.getAllSubBenefitById(id);
    }

    @GetMapping(value = "/get_all_main_benefit_scale/{id}")
    List<MainBenefitScale> getAllMainBenefitScaleByMainBenefitId(@PathVariable("id") int id) {
        return illustrationService.getAllMainBenefitScale(id);
    }

    @GetMapping(value = "/get_all_sub_benefit_scale/{id}")
    List<SubBenefitScale> getAllSubBenefitScaleBySubBenefitId(@PathVariable("id") int id) {
        return illustrationService.getAllSubBenefitScale(id);
    }

    @PostMapping(value = "/get_all_reference_table")
    public ResponseEntity<?> getAllReference(@RequestBody String token){
        if(Ultility.getCodeInTokenKey(token)!=null){
            return ResponseEntity.status(HttpStatus.OK).body(new Referencetable(referenceTableService.findAllMultiplierForAge(),
                    referenceTableService.findAllMultiplierForCareerGroup(),referenceTableService.findAllMultiplierForGenders()
                    , referenceTableService.findAllMultiplierForMainBenifit(),referenceTableService.findAllMultiplierForPaymentPeriod()
                    ,referenceTableService.findAllMultiplierForSubBenifit()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PostMapping(value = "/change_pass")
    public ResponseEntity<?> changePass(@RequestBody String data){
        JSONObject jsonObject =  new JSONObject(data);
        String[] data1 = {jsonObject.getString("id_customer_info"),jsonObject.getString("old_pass")};
        CustomerAcc customerAcc = customerAccService.checkExistCustomerAccountByIdPass(data1);
        if(customerAcc!=null){
            customerAcc.setPass(jsonObject.getString("new_pass"));
            return ResponseEntity.status(HttpStatus.OK).body(customerAccService.updateCustomerAccount(customerAcc));
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PostMapping(value = "/get_customer_attachment")
    public ResponseEntity<?> getCustomerAttachment(@RequestBody Integer id_contract){
        return ResponseEntity.status(HttpStatus.OK).body(attachmentService.getCustomerAttachment(id_contract));
    }

    @GetMapping(value = "/get_all_sub_benifit")
    public ResponseEntity<?> getAllSubBenifit(){
        return ResponseEntity.status(HttpStatus.OK).body(subBenifitService.getAllSubBenifit());
    }

    @PostMapping(value = "/add_one_customer_request")
    public ResponseEntity<?> addOneCustomerRequest(@RequestBody Request request){
        return ResponseEntity.status(HttpStatus.OK).body(requestService.addOneReq(request));
    }

    @PostMapping(value = "/upload_customer_file_request")
    public ResponseEntity uploadFileRequest(@RequestParam("fileData") MultipartFile[] fileData) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(attachmentService.uploadRequestAttachmentToGCP(fileData,storage));
    }

    @PostMapping(value = "/save_customer_request_attachment")
    public ResponseEntity<?> saveRequestAttachment(@RequestBody List<RequestAttachment> requestAttachments){
        return ResponseEntity.status(HttpStatus.OK).body(attachmentService.updateRequestAttachment(requestAttachments));
    }

    //contact
    @GetMapping(value = "/get_all_province")
    public ResponseEntity<?> getAllProvince(){
        return ResponseEntity.status(HttpStatus.OK).body(contactService.getAllProvince());
    }

    @PostMapping(value = "/get_all_district_by_id_province")
        public ResponseEntity<?> getAllDistrictByIdProvince(@RequestBody Integer id_province){
        return ResponseEntity.status(HttpStatus.OK).body(contactService.getAllDistrictByIdProvince(id_province));
    }


    @PostMapping(value = "/add_one_contact")
    public ResponseEntity<?> addOneContact(@RequestBody Contact contact){
        return ResponseEntity.status(HttpStatus.OK).body(contactService.addOneContact(contact));
    }


    // customer claim request
    @PostMapping(value = "/get_all_customer_request")
    List<Request> getAllCustomerRequest(@RequestBody String code_sender){
        return requestService.getAllCustomerRequest(code_sender);
    }
    @PostMapping(value = "/search_all_customer_request")
    List<Request> searchAllCustomerRequest(@RequestBody String data){
        JSONObject requestObject = new JSONObject(data);
        return requestService.searchAllCustomerRequest(
                requestObject.getString("code_sender"),requestObject.getString("dateFrom"),
                requestObject.getString("dateTo"),requestObject.getString("searchValue"));
    }

    //notification
    @PostMapping(value = "/get_all_notification_by_id_customer")
    List<Notification> getAllNotificationByIdCustomer(@RequestBody Integer id_customer){
        return requestService.getAllNotificationByIdCustomer(id_customer);
    }

}
