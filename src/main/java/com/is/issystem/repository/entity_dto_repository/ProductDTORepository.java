package com.is.issystem.repository.entity_dto_repository;

import com.is.issystem.dto.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDTORepository extends JpaRepository<ProductDTO,Integer> {
    @Query(nativeQuery = true,value = "SELECT m.id, m.benifit_name, \n" +
            "       (SELECT COUNT(*) FROM is_agency_db.contract c \n" +
            "       WHERE c.id_main_benifit = m.id \n" +
            "       AND YEAR(c.start_time) = YEAR(CURDATE())) number_products\n" +
            "FROM is_agency_db.main_benifit m")
    List<ProductDTO> getAllProductDTO();
}
