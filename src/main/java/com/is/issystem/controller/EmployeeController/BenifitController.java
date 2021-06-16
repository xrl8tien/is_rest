package com.is.issystem.controller.EmployeeController;

import com.is.issystem.service.MainBenifitService;
import com.is.issystem.service.SubBenifitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/benifit/")
public class BenifitController {

    @Autowired
    MainBenifitService mainBenifitService;

    @Autowired
    SubBenifitService subBenifitService;

    @GetMapping(value = "/get_all_main_benifit")
    public ResponseEntity<?> getAllMainBenifit(){
        return ResponseEntity.status(HttpStatus.OK).body(mainBenifitService.getAllMainInterst());
    }

    @GetMapping(value = "/get_all_sub_benifit")
    public ResponseEntity<?> getAllSubBenifit(){
        System.out.println(subBenifitService.getAllSubBenifit());
        return ResponseEntity.status(HttpStatus.OK).body(subBenifitService.getAllSubBenifit());
    }
}
