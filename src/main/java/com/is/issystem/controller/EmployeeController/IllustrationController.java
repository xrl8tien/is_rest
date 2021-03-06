package com.is.issystem.controller.EmployeeController;

import com.is.issystem.dto.IllustrationItemOfList;
import com.is.issystem.dto.IllustrationDTO;
import com.is.issystem.entities.*;
import com.is.issystem.service.IllustrationService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/api/illustration"})
public class IllustrationController {
    @Autowired
    private IllustrationService illustrationService;

    @PostMapping(value = "/get_detail_illustration/")
    IllustrationDTO getDetailIllustration(@RequestBody Integer id) {
        return illustrationService.getDetailIllustration(id);
    }

    @GetMapping(value = "/get_all_illustration_belong_customer/{id}")
    List<IllustrationItemOfList> getAllIllustration(@PathVariable("id") int id) {
        return illustrationService.getAllIllustration(id);
    }

    @PostMapping(value = "/search_all_illustration_belong_customer")
    List<IllustrationItemOfList> searchAllIllustration(@RequestBody String data) {
        JSONObject illustrationObject = new JSONObject(data);
        return illustrationService.searchAllIllustration(illustrationObject.getInt("id"), illustrationObject.getString("dateFrom"), illustrationObject.getString("dateTo"), illustrationObject.getString("searchValue"));
    }

    @PostMapping(value = "/add_one_illustration")
    public void illustrationDTO(@RequestBody IllustrationDTO illustrationDTO) {
//        if(illustrationService.checkExistIllustration(illustrationDTO)){
//            illustrationService.updateIllustration(illustrationDTO);
//        } else {
        illustrationService.saveIllustration(illustrationDTO);
//        }
    }

    @GetMapping(value = "/get_all_sub_benefit/{id}")
    List<IllustrationSubBenifit> getAllSubBenefitById(@PathVariable("id") int id) {
        return illustrationService.getAllSubBenefitById(id);
    }

    @GetMapping(value = "/get_main_benefit/{id}")
    IllustrationMainBenifit getMainBenefitByIdIll(@PathVariable("id") int id) {
        return illustrationService.getMainBenefitByIdIll(id);
    }

    @GetMapping(value = "/get_all_main_benefit_scale/{id}")
    List<MainBenefitScale> getAllMainBenefitScaleByMainBenefitId(@PathVariable("id") int id) {
        return illustrationService.getAllMainBenefitScale(id);
    }

    @GetMapping(value = "/get_all_sub_benefit_scale/{id}")
    List<SubBenefitScale> getAllSubBenefitScaleBySubBenefitId(@PathVariable("id") int id) {
        return illustrationService.getAllSubBenefitScale(id);
    }

}
