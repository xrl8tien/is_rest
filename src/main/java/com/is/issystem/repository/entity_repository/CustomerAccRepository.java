package com.is.issystem.repository.entity_repository;

import com.is.issystem.entities.CustomerAcc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerAccRepository extends JpaRepository<CustomerAcc,Integer> {
    @Query(value = "SELECT  * from customer_acc where code = ?1 and id != ?2",nativeQuery = true)
    List<CustomerAcc> getAccExist(String code,Integer id);

    @Query(value = "SELECT * from customer_acc where id = (select id_account from customer_info where id = ?1 ) and pass = ?2 \n",nativeQuery = true)
    CustomerAcc getAccByIdPass(Integer id,String pass);

    @Query(value = "select customer_info.id from customer_info inner join customer_acc on customer_info.id_account = customer_acc.id \n" +
            "and customer_acc.code = ?1 and customer_acc.pass = ?2 ",nativeQuery = true)
    String getAccByCodePass(String code,String pass);
}
