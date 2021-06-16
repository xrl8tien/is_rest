package com.is.issystem.repository.entity_dto_repository;

import com.is.issystem.dto.IllustrationItemOfList;
import com.is.issystem.entities.Illustration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IllustrationItemOfListRepository extends JpaRepository<IllustrationItemOfList,Integer> {
    @Query(value = "SELECT ill.*,mi.benifit_name FROM is_agency_db.illustration as ill INNER JOIN is_agency_db.illustration_main_benifit\n" +
            "                        as imi on ill.id = imi.id_illustration INNER JOIN is_agency_db.main_benifit as mi on mi.id = imi.id_main_benifit\n" +
            "                        LEFT JOIN contract as c on c.id_illustration = ill.id  where ill.id_customer_info = ?1 and c.id is null order by id desc",nativeQuery = true)
    List<IllustrationItemOfList> listIllustrationCustomerOwn(int id);

    @Query(value = "SELECT  ill.*,mi.benifit_name FROM is_agency_db.illustration as ill \n" +
            "            INNER JOIN is_agency_db.illustration_main_benifit as imi on ill.id = imi.id_illustration \n" +
            "            INNER JOIN is_agency_db.main_benifit as mi on mi.id = imi.id_main_benifit\n" +
            "\t\t\tLEFT JOIN contract as c on c.id_illustration = ill.id  \n" +
            "\t\t\twhere (ill.id_customer_info = ?1 and ill.create_time between ?2 and ?3 and c.id is null)\n" +
            "\t\t\tand (benifit_name LIKE ?4 or ill.id LIKE ?4)",nativeQuery = true)
    List<IllustrationItemOfList> searchListIllustrationCustomerOwn(int id,String dateFrom,String dateTo,String searchValue);
}
