package com.is.issystem.controller.EmployeeController;

import com.is.issystem.dto.CampaignDTO;
import com.is.issystem.dto.CustomerInfoDTO;
import com.is.issystem.service.CampaignService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/api/campaign"})
public class CampaignController {
    @Autowired
    CampaignService campaignService;

    @PostMapping(value = "/get_all_campaign")
    public List<CampaignDTO> getAllCampaign(@RequestBody String code_em_support){
        return campaignService.getAllCampaign(code_em_support);
    }
    @PostMapping(value = "/search_all_campaign")
    public List<CampaignDTO> searchAllCampaign(@RequestBody String data){
        JSONObject datajsObject = new JSONObject(data);
        return campaignService.searchAllCampaign(datajsObject.getString("code_em_support"),datajsObject.getString("create_time"),datajsObject.getString("end_time"),datajsObject.getString("searchValue"));
    }

    //sale executive
    @PostMapping(value = "/get_all_campaign_ex")
    public List<CampaignDTO> getAllCampaignEx(@RequestBody List<String> codes_em_support){
        return campaignService.getAllCampaignEx(codes_em_support);
    }
    @PostMapping(value = "/search_all_campaign_ex")
    public List<CampaignDTO> searchAllCampaignEx(@RequestBody CustomerInfoDTO data){
        return campaignService.searchAllCampaignEx(data.getCodes_saler(), data.getDateFrom(), data.getDateTo(), data.getSearchValue());
    }

    @PostMapping(value = "/add_one_campaign")
    public void addOneCampaign(@RequestBody String data){
        JSONObject jsObject = new JSONObject(data);
         campaignService.addOneCampaign(jsObject.getString("code"),jsObject.getString("end_time"));
    }

}
