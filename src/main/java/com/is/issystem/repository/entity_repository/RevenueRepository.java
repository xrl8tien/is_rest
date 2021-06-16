package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.CustomerInfo;
import com.is.issystem.entities.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RevenueRepository extends JpaRepository<Revenue,Integer> {
    @Query(nativeQuery = true,value = "SELECT * FROM is_agency_db.revenue where code_employee = ?1")
    public List<Revenue> getAllRevenueEmployee(String code_em_support);

    @Query(nativeQuery = true,value = "SELECT * FROM is_agency_db.revenue where code_employee = ?1 and month(create_time)=?2-1 and year(create_time)=?3")
    public List<Revenue> getRevenueEmployeeMonthBefore(String code_em_support, Integer MonthDate,Integer YearDate);

    @Query(nativeQuery = true,value = "SELECT * FROM is_agency_db.revenue where code_employee = ?1 and year(create_time)=?2-1")
    public List<Revenue> getRevenueEmployeeYearBefore(String code_em_support, Integer YearDate);
}
