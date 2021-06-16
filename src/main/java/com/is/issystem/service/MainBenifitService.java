package com.is.issystem.service;

import com.is.issystem.entities.MainBenifit;
import com.is.issystem.repository.entity_repository.MainBenifitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainBenifitService {
    @Autowired
    MainBenifitRepository mainBenifitRepository;

    public List<MainBenifit> getAllMainInterst(){
        return mainBenifitRepository.findAll();
    }
}
