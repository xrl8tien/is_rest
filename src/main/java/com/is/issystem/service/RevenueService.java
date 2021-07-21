package com.is.issystem.service;

import com.is.issystem.entities.Income;
import com.is.issystem.entities.Kpi;
import com.is.issystem.entities.Revenue;
import com.is.issystem.repository.entity_repository.IncomeRepository;
import com.is.issystem.repository.entity_repository.KpiRepository;
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

    @Autowired
    KpiRepository kpiRepository;

    public Revenue saveOneRevenue(Revenue revenue) {
        return revenueRepository.save(revenue);
    }

    public List<Revenue> getAllRevenueEmployee(String code_em_support) {
        return revenueRepository.getAllRevenueEmployee(code_em_support);
    }

    public List<Revenue> getAllRevenueEmployeeMonthBefore(String code_em_support, Integer monthDate, Integer yearDate) {
        return revenueRepository.getRevenueEmployeeMonthBefore(code_em_support, monthDate, yearDate);
    }

    public List<Revenue> getAllRevenueEmployeeYearBefore(String code_em_support, Integer yearDate) {
        return revenueRepository.getRevenueEmployeeYearBefore(code_em_support, yearDate);
    }

    public List<Income> getAllIncomeForSaler(String code_em_support) {
        return incomeRepository.listIncome(code_em_support);
    }

    public List<Kpi> getAllKpiEmployee(String code_employee) {
        return kpiRepository.getAllKpiEmployee(code_employee);
    }

    //sale executive
    public List<Revenue> getAllRevenueEmployeeEx(List<String> codes_em_support) {
        return revenueRepository.getAllRevenueEmployeeEx(codes_em_support);
    }

    public List<Income> getAllIncomeForSalerEx(List<String> codes_em_support) {
        return incomeRepository.listIncomeEx(codes_em_support);
    }

}
