package com.is.issystem.controller.EmployeeController;

import com.is.issystem.entities.DetailCommission;
import com.is.issystem.service.DetailCommissionService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequestMapping(value = "api/detail_commission")
public class DetailCommissionController {
    @Autowired
    DetailCommissionService detailCommissionService;

    @PostMapping(value = "/get_one_detail_commision")
    public ResponseEntity<?> getOneDetailComission(@RequestBody String jsonObject){
        JSONObject data = new JSONObject(jsonObject);
        return ResponseEntity.status(HttpStatus.OK).body(detailCommissionService
                .getOneDetailComission(data.getInt("payment_period_id"),data.getBigInteger("denomination")));
    }
}
