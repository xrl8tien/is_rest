package com.is.issystem.controller.EmployeeController;

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
    public ResponseEntity saveOneRevenue(@RequestBody String code_em_support){
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

    // tính thu nhập của năm hiện tại trong đó bao gồm các dự đoán trước thu nhập cho các tháng tương lai
    @PostMapping(value = "/get_all_income_saler")
    public ResponseEntity getAllIncomeSaler(@RequestBody String code_em_support){
        return ResponseEntity.status(HttpStatus.OK).body(revenueService.getAllIncomeForSaler(code_em_support));
    }



}
