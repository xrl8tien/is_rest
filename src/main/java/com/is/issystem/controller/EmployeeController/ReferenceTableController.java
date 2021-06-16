package com.is.issystem.controller.EmployeeController;

import com.is.issystem.entities.Referencetable;
import com.is.issystem.service.ReferenceTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/reference_table")
public class ReferenceTableController {
    @Autowired
    ReferenceTableService referenceTableService;

    @GetMapping(value = "/get_all_reference_table")
    public ResponseEntity<?> getAllReference(){
        return ResponseEntity.status(HttpStatus.OK).body(new Referencetable(
                referenceTableService.findAllMultiplierForAge(),
                referenceTableService.findAllMultiplierForCareerGroup(),
                referenceTableService.findAllMultiplierForGenders()
        , referenceTableService.findAllMultiplierForMainBenifit(),
                referenceTableService.findAllMultiplierForPaymentPeriod()
        ,referenceTableService.findAllMultiplierForSubBenifit()));
    }
}
