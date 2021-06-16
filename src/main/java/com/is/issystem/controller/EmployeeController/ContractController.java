package com.is.issystem.controller.EmployeeController;

import com.is.issystem.dto.ContractDTO;
import com.is.issystem.entities.Contract;
import com.is.issystem.entities.ContractChangeHistory;
import com.is.issystem.entities.FeePaymentHistory;
import com.is.issystem.entities.BenifitPaymentHistory;
import com.is.issystem.repository.entity_repository.ContractRepository;
import com.is.issystem.service.ContractService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = {"/api/contract"})
public class ContractController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private ContractRepository contractRepository;

    @PostMapping(value = "/get_all_contract_of_employee")
    List<ContractDTO> getAllContract(@RequestBody String code_em_support){
        return contractService.getAllContract(code_em_support);
    }

    @PostMapping(value = "/search_all_contract_of_employee")
    List<ContractDTO> searchAllContract(@RequestBody String data){
        JSONObject contractObject = new JSONObject(data);
        return contractService.searchAllContract(contractObject.getString("code_em_support"),contractObject.getString("dateFrom"),contractObject.getString("dateTo"),contractObject.getString("searchValue"));
    }


    @GetMapping(value = "/get_all_contract_change_history/{id}")
    List<ContractChangeHistory> getAllContractHistory(@PathVariable("id") int id){
        return contractService.getAllContractHistory(id);
    }

    @PostMapping(value = "/set_active_contract")
    public ResponseEntity<?> setActiveContract(@RequestBody String data1){
        JSONObject data = new JSONObject(data1);
        contractService.setUpdateContract(Integer.parseInt(data.get("id_contract").toString()),Integer.parseInt(data.get("id_request").toString()),data.get("description").toString(),data.get("approval_status").toString());
        return ResponseEntity.status(HttpStatus.OK).body(data1);
    }

    @GetMapping(value = "/get_all_fee_payment_history/{id}")
    List<FeePaymentHistory> getAllFeePaymentHistory(@PathVariable("id") int id){
        return contractService.getAllFeePaymentHistory(id);
    }

    @GetMapping(value = "/get_all_interset_payment_history/{id}")
    List<BenifitPaymentHistory> getAllIntersetPaymentHistory(@PathVariable("id") int id){
        return contractService.getAllIntersetPaymentHistory(id);
    }
    // lấy hợp đồng của 1 saler
    @PostMapping(value = "/get_detail_contract")
    ContractDTO getDetailContract(@RequestBody String data){
        JSONObject jsonObject = new JSONObject(data);
        return contractService.getDetailContractForSaler(jsonObject.getString("code"),jsonObject.getInt("id"));
    }

    @PostMapping(value = "/get_detail_contract_for_customer")
    ContractDTO getDetailContractForCustomer(@RequestBody Integer id){
        return contractService.getDetailContractForCustomer(id);
    }

    @GetMapping(value = "/get_detail_contract_change_history/{id}")
    Optional<ContractChangeHistory> getDetailContractChange(@PathVariable("id") int id){
        return contractService.getDetailContractChange(id);
    }

    @PostMapping(value = "/add_contract")
    public ResponseEntity<?> addContract(@RequestBody Contract contract){
        contractRepository.save(contract);
        return ResponseEntity.status(HttpStatus.OK).body(contract);
    }

    @PostMapping(value = "/edit_contract")
    public ResponseEntity<?> editContract(@RequestBody Contract contract){
        contractService.updateContract(contract);
        return ResponseEntity.status(HttpStatus.OK).body(contract);
    }

    @PostMapping(value = "/get_all_count_contract")
    public ResponseEntity getAllCountContract(@RequestBody String data){
        JSONObject monthRevenue = new JSONObject(data);
        return ResponseEntity.status(HttpStatus.OK).body(contractService.getCountNewContract(monthRevenue.get("code_em_support").toString(),Integer.parseInt(monthRevenue.get("monthDate").toString())));
    }
}
