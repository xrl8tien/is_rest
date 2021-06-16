package com.is.issystem.service;

import com.is.issystem.entities.Income;
import com.is.issystem.entities.Revenue;
import com.is.issystem.repository.entity_repository.IncomeRepository;
import com.is.issystem.repository.entity_repository.RevenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevenueService {
    @Autowired
    RevenueRepository revenueRepository;

    @Autowired
    IncomeRepository incomeRepository;

    public Revenue saveOneRevenue(Revenue revenue){
        return revenueRepository.save(revenue);
    }

    public List<Revenue> getAllRevenueEmployee(String code_em_support){return revenueRepository.getAllRevenueEmployee(code_em_support);}

    public List<Revenue> getAllRevenueEmployeeMonthBefore(String code_em_support,Integer monthDate,Integer yearDate)
    {return revenueRepository.getRevenueEmployeeMonthBefore(code_em_support,monthDate,yearDate);}

    public List<Revenue> getAllRevenueEmployeeYearBefore(String code_em_support,Integer yearDate)
    {return revenueRepository.getRevenueEmployeeYearBefore(code_em_support,yearDate);}

    public List<Income> getAllIncomeForSaler(String code_em_support){
        return incomeRepository.listIncome(code_em_support);
    }
}
