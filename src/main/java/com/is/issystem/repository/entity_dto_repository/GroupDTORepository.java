package com.is.issystem.repository.entity_dto_repository;

import com.is.issystem.dto.GroupDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupDTORepository extends JpaRepository<GroupDTO, Integer> {
    @Query(nativeQuery = true, value = "SELECT g.id, g.code_sale_executive, p.type, p.name\n" +
            "FROM is_agency_db.group as g \n" +
            "INNER JOIN is_agency_db.province as p on p.code_sale_executive = g.code_sale_executive")
    List<GroupDTO> getAllGroup();

    @Query(nativeQuery = true, value = "SELECT g.id, g.code_sale_executive, p.type, p.name\n" +
            "FROM is_agency_db.group as g \n" +
            "INNER JOIN is_agency_db.province as p on p.code_sale_executive = g.code_sale_executive \n" +
            "WHERE (g.code_sale_executive LIKE ?1 or p.name LIKE ?1 or p.type LIKE ?1)")
    List<GroupDTO> searchAllGroup(String searchValue);
}
