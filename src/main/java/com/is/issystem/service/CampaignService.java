package com.is.issystem.service;

import com.is.issystem.dto.CampaignDTO;
import com.is.issystem.repository.entity_dto_repository.CampaignDTORepository;
import com.is.issystem.repository.entity_repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {
    @Autowired
    private CampaignDTORepository campaignDTORepository;

    @Autowired
    private CampaignRepository campaignRepository;

    public List<CampaignDTO> getAllCampaign(String code_em_support){
        return campaignDTORepository.listCampaign(code_em_support);
    }

    public List<CampaignDTO> searchAllCampaign(String code_em_support, String create_time, String end_time, String searchValue){
        return campaignDTORepository.searchListCampaign(code_em_support,create_time,end_time,searchValue);
    }

    public void addOneCampaign(String code, String end_time){
         campaignRepository.addOneCampaign(code,end_time);
    }
}
