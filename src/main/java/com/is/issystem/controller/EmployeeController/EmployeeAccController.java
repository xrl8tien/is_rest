package com.is.issystem.controller.EmployeeController;

import com.google.gson.Gson;
import com.is.issystem.dto.CustomerDTO;
import com.is.issystem.dto.EmployeeInfoDTO;
import com.is.issystem.entities.Attachment;
import com.is.issystem.entities.EmployeeAcc;
import com.is.issystem.entities.PauseReason;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.is.issystem.service.EmployeeAccService;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = {"/api/employee"})
public class EmployeeAccController {
    @Autowired
    private EmployeeAccService employeeAccService;

    @GetMapping(value = {"/get_all_employee_acc"})
    public ResponseEntity<?>  listEmployeeAccount(){
        List<EmployeeAcc> listAccEm = employeeAccService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listAccEm);
    }



    @PostMapping(value = "/add_employee_acc")
    public ResponseEntity<?> addEmployeeAccount(@RequestBody String data) throws MessagingException {
        JSONObject jsonObject = new JSONObject(data);
        Gson gson=new Gson();
        EmployeeAcc employeeAcc = gson.fromJson(jsonObject.getJSONObject("emAcc").toString(),EmployeeAcc.class);
        if(employeeAccService.checkExistEmployeeAccount(employeeAcc)){
            return null;
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(employeeAccService.addEmployeeAccount(
                    employeeAcc,
                    jsonObject.getString("email"),
                    jsonObject.getString("code_suppervisor"),
                    jsonObject.getInt("id_custInfo")).getId());
        }
    }

    @PostMapping(value = "/get_all_employee_acc_by_idRole")
    public ResponseEntity<?> getAllEmaccByIdRole(@RequestBody String data){
        JSONObject jsonObject = new JSONObject(data);
        return ResponseEntity.status(HttpStatus.OK).body(employeeAccService.
                getAllEmployeeByIdRoleCodeApSpp(jsonObject.getInt("id"),jsonObject.getString("code_app_support")));
    }

    @PostMapping(value = "/update_employee_acc")
    public ResponseEntity<?> updateEmployeeAccount(@RequestBody EmployeeAcc employee_acc){
        employeeAccService.updateEmployeeAccountByCode(employee_acc);
        return ResponseEntity.status(HttpStatus.OK).body(employee_acc);
    }

    @PostMapping(value = "/pause_employee_acc")
    public ResponseEntity<?> pauseEmployeeAccount(@RequestBody String data ) throws MessagingException {
        JSONObject employeeObject = new JSONObject(data);
        JSONArray attachmentList = employeeObject.getJSONArray("listFileAttackment");
        List<String> attachmentURLList = new ArrayList<>();
        for(int i=0 ; i<attachmentList.length();i++){
            JSONObject jsonObject = attachmentList.getJSONObject(i);
            attachmentURLList.add(jsonObject.getString("url"));
        }
        employeeAccService.pauseEmployee(employeeObject.getString("codeEmployeeNew"),employeeObject.getInt("id_employee_old"),attachmentURLList);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @PostMapping(value = "/pause_reason_employee")
    public ResponseEntity<?> pauseReasonEmployee(@RequestBody List<PauseReason> pauseReasons ){
        employeeAccService.updatePauseReason(pauseReasons);
        return ResponseEntity.status(HttpStatus.OK).body(pauseReasons);
    }

    @GetMapping(value = {"/get_one_employee_acc/{token_id}"})
    public ResponseEntity<?> getOneEmployeeAccount(@PathVariable String token_id){
        return ResponseEntity.status(HttpStatus.OK).body(employeeAccService.findEmployeeAccountByCode(token_id));
    }

    @PostMapping(value = "/reset_acc_password_for_employee")
    public ResponseEntity<?> resetCustomerAccount(@RequestBody EmployeeInfoDTO employeeInfoDTO) throws MessagingException {
        return ResponseEntity.status(HttpStatus.OK).body(employeeAccService.resetAccountPasswordEmployee(employeeInfoDTO));
    }
}
