package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.GroupMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupMemberRepository extends JpaRepository<GroupMember, Integer> {
    @Query(value = "select code_sale from is_agency_db.group_member as m\n" +
                    " inner join is_agency_db.group as g on g.id = m.id_group\n" +
                    " where g.code_sale_executive = ?1", nativeQuery = true)
    List<String> getAllCodeSaleByCodeEx(String code_ex);
}
