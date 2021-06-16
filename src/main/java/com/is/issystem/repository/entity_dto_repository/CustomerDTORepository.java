package com.is.issystem.repository.entity_dto_repository;

import com.is.issystem.dto.CustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;
import java.util.Date;
import java.util.List;

@Repository
public interface CustomerDTORepository extends JpaRepository<CustomerDTO,Integer>{

    @Query(nativeQuery = true,name = "find_stock_akhir_dto")
    List<CustomerDTO> getAllCustomerInfo(String code_em_support);

    @Query(nativeQuery = true,name = "getAllCustomerInfoSearch")
    List<CustomerDTO> getAllCustomerInfoSearch(String code_em_support, String dateFrom, String dateTo, String searchValue);

    @Query(nativeQuery = true,name = "getAllCustomerInfoByAdmin")
    List<CustomerDTO> getAllCustomerInfoAdmin();

    @Query(nativeQuery = true,name = "searchAllCustomerInfoByAdmin")
    List<CustomerDTO> searchAllCustomerInfoAdmin(String dateFrom, String dateTo, String searchValue);


    @Query(nativeQuery = true,name = "getCustomerInfoDetail")
    List<CustomerDTO> getCustomerInfobyIDAndCodeEmSupport(int id, String code);


    @Query(nativeQuery = true,name = "getCustomerInfoDetailByIdCustomer")
    List<CustomerDTO> getCustomerInfobyIdCustomer(int id);

    // lấy tất cả thông tin khácsh hàng phục vụ cho việc chọn khách hàng ở dialog thêm hợp đồng
    @Query(nativeQuery = true,name = "getCustomerInfoDetailForSaler")
    List<CustomerDTO> getCustomerInfobySaler(String code);


}
