package com.is.issystem.service;

import com.is.issystem.entities.SubBenifit;
import com.is.issystem.repository.entity_repository.SubBenifitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubBenifitService {
    @Autowired
    SubBenifitRepository subBenifitRepository;
    public List<SubBenifit> getAllSubBenifit(){
        return subBenifitRepository.findAll();
    }
}
