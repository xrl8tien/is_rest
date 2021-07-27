package com.is.issystem.controller.EmployeeController;
import com.is.issystem.dto.EmployeeInfoDTO;
import com.is.issystem.dto.GroupDTO;
import com.is.issystem.service.EmployeeInfoService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = {"/api/employee"})
public class EmployeeInfoController {
    @Autowired
    EmployeeInfoService employeeInfoService;

    @GetMapping(value = {"/get_all_employee_info_acc"})
    public List<EmployeeInfoDTO> getListEmployeeInfoAcc(){
     return employeeInfoService.getAllEmployee();
    }

    @PostMapping(value = "/search_all_employee_info_acc")
    public List<EmployeeInfoDTO> searchListEmployeeInfoAcc(@RequestBody String data){
        JSONObject infoObject = new JSONObject(data);
        return employeeInfoService.searchAllEmployee(infoObject.getString("dateFrom"),infoObject.getString("dateTo"),infoObject.getString("searchValue"));
    }

    @PostMapping(value = {"/get_all_employee_info_acc_ex"})
    public List<EmployeeInfoDTO> getListEmployeeInfoAccEx(@RequestBody String code_sale_executive){
        return employeeInfoService.getAllEmployeeEx(code_sale_executive);
    }

    @PostMapping(value = {"/get_all_group"})
    public List<GroupDTO> getAllGroup(@RequestBody String code_sale_executive){
        return employeeInfoService.getAllGroup();
    }

    @PostMapping(value = {"/search_all_group"})
    public List<GroupDTO> searchAllGroup(@RequestBody String searchValue){
        return employeeInfoService.searchAllGroup(searchValue);
    }

    @PostMapping(value = "/search_all_employee_info_acc_ex")
    public List<EmployeeInfoDTO> searchListEmployeeInfoAccEx(@RequestBody String data){
        JSONObject infoObject = new JSONObject(data);
        return employeeInfoService.searchAllEmployeeEx(infoObject.getString("code_sale_executive"), infoObject.getString("dateFrom"),infoObject.getString("dateTo"),infoObject.getString("searchValue"));
    }

    @PostMapping(value = "/add_employee_info")
    public ResponseEntity<?> addEmployeeInfo(@RequestBody EmployeeInfoDTO employeeInfoDTO){
        if(employeeInfoService.addEmployeeInfo(employeeInfoDTO)){
            return ResponseEntity.status(HttpStatus.OK).body(employeeInfoDTO);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }

    }
    @GetMapping(value = {"/get_detail_employee_info/{id}"})
    public EmployeeInfoDTO getDetailEmployeeInfo(@PathVariable("id") int id){
        return employeeInfoService.getDetailEmployeebyID(id);
    }

    @PostMapping(value = {"/get_detail_employee_info_by_code/"})
    public EmployeeInfoDTO getDetailEmployeeInfo(@RequestBody String code){
        return employeeInfoService.getDetailEmployeebyCode(code);
    }

    @PostMapping(value = "/update_employee_info")
    public ResponseEntity<?> updateEmployeeInfo(@RequestBody EmployeeInfoDTO employeeInfoDTO){
        return ResponseEntity.status(HttpStatus.OK).body(employeeInfoService.updateEmployeeInfo(employeeInfoDTO));
    }
}
