package com.is.issystem.controller.EmployeeController;

import com.is.issystem.entities.Kpi;
import com.is.issystem.entities.Revenue;
import com.is.issystem.service.RevenueService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/revenue/")
public class RevenueController {
    @Autowired
    RevenueService revenueService;

    @PostMapping(value = "/save_one_revenue")
    public ResponseEntity saveOneRevenue(@RequestBody Revenue revenue){
        return ResponseEntity.status(HttpStatus.OK).body(revenueService.saveOneRevenue(revenue));
    }

    @PostMapping(value = "/get_all_revenue_employee")
    public ResponseEntity getAllRevenueEmployee(@RequestBody String code_em_support){
        return ResponseEntity.status(HttpStatus.OK).body(revenueService.getAllRevenueEmployee(code_em_support));
    }

    @PostMapping(value = "/get_all_revenue_employee_month_before")
    public ResponseEntity getRevenueEmployeeMonthBefore(@RequestBody String data){
        JSONObject monthRevenue = new JSONObject(data);
        return ResponseEntity.status(HttpStatus.OK).body(revenueService.getAllRevenueEmployeeMonthBefore(monthRevenue.get("code_em_support").toString(),Integer.parseInt(monthRevenue.get("monthDate").toString()),Integer.parseInt(monthRevenue.get("yearDate").toString())));
    }

    @PostMapping(value = "/get_all_revenue_employee_year_before")
    public ResponseEntity getRevenueEmployeeYearBefore(@RequestBody String data){
        JSONObject monthRevenue = new JSONObject(data);
        return ResponseEntity.status(HttpStatus.OK).body(revenueService.getAllRevenueEmployeeYearBefore(monthRevenue.get("code_em_support").toString(),Integer.parseInt(monthRevenue.get("yearDate").toString())));
    }

    // t??nh thu nh???p c???a n??m hi???n t???i trong ???? bao g???m c??c d??? ??o??n tr?????c thu nh???p cho c??c th??ng t????ng lai
    @PostMapping(value = "/get_all_income_saler")
    public ResponseEntity getAllIncomeSaler(@RequestBody String code_em_support){
        return ResponseEntity.status(HttpStatus.OK).body(revenueService.getAllIncomeForSaler(code_em_support));
    }

    // l???y kpi cho t???ng employee
    @PostMapping(value = "/get_all_kpi_employee")
    public ResponseEntity getAllKpiEmployee(@RequestBody String code_employee){
        return ResponseEntity.status(HttpStatus.OK).body(revenueService.getAllKpiEmployee(code_employee));
    }

    @PostMapping(value = "/save_one_kpi")
    public ResponseEntity saveOneRevenue(@RequestBody Kpi kpi){
        return ResponseEntity.status(HttpStatus.OK).body(revenueService.saveOneKpi(kpi));
    }

    //sale executive
    @PostMapping(value = "/get_all_revenue_employee_ex")
    public ResponseEntity getAllRevenueEmployeeEx(@RequestBody List<String> codes_em_support){
        return ResponseEntity.status(HttpStatus.OK).body(revenueService.getAllRevenueEmployeeEx(codes_em_support));
    }

    @PostMapping(value = "/get_all_income_saler_ex")
    public ResponseEntity getAllIncomeSalerEx(@RequestBody List<String> codes_em_support){
        return ResponseEntity.status(HttpStatus.OK).body(revenueService.getAllIncomeForSalerEx(codes_em_support));
    }

}
