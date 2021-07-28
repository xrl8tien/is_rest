package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.Kpi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KpiRepository extends JpaRepository<Kpi, Integer> {
    @Query(nativeQuery = true, value = "SELECT *\n" +
            "FROM (SELECT *\n" +
            "          , ROW_NUMBER() OVER (PARTITION BY YEAR(create_time), Month(create_time) " +
            "            ORDER BY id DESC) 'RowRank'\n" +
            "            FROM is_agency_db.kpi WHERE code_employee = ?1 \n" +
            "     )sub\n" +
            "WHERE RowRank = 1")
    public List<Kpi> getAllKpiEmployee(String code_employee);
}
