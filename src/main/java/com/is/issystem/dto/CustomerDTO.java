package com.is.issystem.dto;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NamedNativeQuery(
        name = "find_stock_akhir_dto",
        query =
                "SELECT ci.*,code ,ca.status ,\n" +
                "null as id_contract, null as id_illustration,\n" +
                "conadd_city , conadd_district \n" +
                ",conadd_no_street ,conadd_wards, \n" +
                "curadd_city ,curadd_district ,\n" +
                "curadd_no_street , curadd_wards,  \n" +
                "peradd_city,peradd_district,peradd_no_street,peradd_wards,\n" +
                "workadd_city,workadd_district,workadd_no_street,workadd_wards\n" +
                "FROM is_agency_db.customer_info as ci\n" +
                "LEFT JOIN is_agency_db.customer_acc as ca on ci.id_account = ca.id \n" +
                "INNER JOIN contact_address as conadd ON conadd.conadd_id = ci.id_contact_address\n" +
                "INNER JOIN current_address as curadd ON curadd.curadd_id = ci.id_current_address \n" +
                "INNER JOIN permanent_address as peradd on peradd.peradd_id = ci.id_permanent_address \n" +
                "INNER JOIN workplace_address as workadd ON workadd.workadd_id = ci.id_workplace_address \n" +
                "where ci.code_em_support = ?1 order by created_time desc",
        resultSetMapping = "stock_akhir_dto"
)
@NamedNativeQuery(
        name = "getAllCustomerInfoSearch",
        query =
                "SELECT ci.*,code ,ca.status ,\n" +
                "null as id_contract, null as id_illustration,\n" +
                "conadd_city , conadd_district \n" +
                ",conadd_no_street ,conadd_wards, \n" +
                "curadd_city ,curadd_district ,\n" +
                "curadd_no_street , curadd_wards,  \n" +
                "peradd_city,peradd_district,peradd_no_street,peradd_wards,\n" +
                "workadd_city,workadd_district,workadd_no_street,workadd_wards\n" +
                "FROM is_agency_db.customer_info as ci\n" +
                "LEFT JOIN is_agency_db.customer_acc as ca on ci.id_account = ca.id \n" +
                "INNER JOIN contact_address as conadd ON conadd.conadd_id = ci.id_contact_address\n" +
                "INNER JOIN current_address as curadd ON curadd.curadd_id = ci.id_current_address \n" +
                "INNER JOIN permanent_address as peradd on peradd.peradd_id = ci.id_permanent_address \n" +
                "INNER JOIN workplace_address as workadd ON workadd.workadd_id = ci.id_workplace_address \n" +
                "where (ci.code_em_support = ?1 and created_time between ?2 and ?3)\n" +
                "and (ci.full_name LIKE ?4 or ci.id LIKE ?4  or code LIKE ?4 or conadd_city LIKE ?4 or ci.phone_1 LIKE ?4\n" +
                "or workadd_no_street LIKE ?4)\n" +
                "order by created_time desc",
        resultSetMapping = "stock_akhir_dto"
)
@NamedNativeQuery(
        name = "getAllCustomerInfoByAdmin",
        query =
                "SELECT ci.*,code ,ca.status ,\n" +
                "null as id_contract, null as id_illustration,\n" +
                "conadd_city , conadd_district \n" +
                ",conadd_no_street ,conadd_wards, \n" +
                "curadd_city ,curadd_district ,\n" +
                "curadd_no_street , curadd_wards,  \n" +
                "peradd_city,peradd_district,peradd_no_street,peradd_wards,\n" +
                "workadd_city,workadd_district,workadd_no_street,workadd_wards\n" +
                "FROM is_agency_db.customer_info as ci\n" +
                "LEFT JOIN is_agency_db.customer_acc as ca on ci.id_account = ca.id \n" +
                "INNER JOIN contact_address as conadd ON conadd.conadd_id = ci.id_contact_address\n" +
                "INNER JOIN current_address as curadd ON curadd.curadd_id = ci.id_current_address \n" +
                "INNER JOIN permanent_address as peradd on peradd.peradd_id = ci.id_permanent_address \n" +
                "INNER JOIN workplace_address as workadd ON workadd.workadd_id = ci.id_workplace_address order by created_time desc",
        resultSetMapping = "stock_akhir_dto"
)
@NamedNativeQuery(
        name = "searchAllCustomerInfoByAdmin",
        query =
                "SELECT ci.*,code ,ca.status ,\n" +
                "null as id_contract, null as id_illustration,\n" +
                "conadd_city , conadd_district \n" +
                ",conadd_no_street ,conadd_wards, \n" +
                "curadd_city ,curadd_district ,\n" +
                "curadd_no_street , curadd_wards, \n" +
                "peradd_city,peradd_district,peradd_no_street,peradd_wards,\n" +
                "workadd_city,workadd_district,workadd_no_street,workadd_wards\n" +
                "FROM is_agency_db.customer_info as ci\n" +
                "LEFT JOIN is_agency_db.customer_acc as ca on ci.id_account = ca.id \n" +
                "INNER JOIN contact_address as conadd ON conadd.conadd_id = ci.id_contact_address\n" +
                "INNER JOIN current_address as curadd ON curadd.curadd_id = ci.id_current_address \n" +
                "INNER JOIN permanent_address as peradd on peradd.peradd_id = ci.id_permanent_address \n" +
                "INNER JOIN workplace_address as workadd ON workadd.workadd_id = ci.id_workplace_address \n" +
                "where (ci.birth_date between ?1 and ?2) \n" +
                "and (ci.id LIKE ?3 or ci.full_name LIKE ?3 or ci.phone_1 LIKE ?3 or ci.email LIKE ?3 )\n" +
                "order by created_time desc",
        resultSetMapping = "stock_akhir_dto"
)
@NamedNativeQuery(
        name = "getCustomerInfoDetail",
        query =
                "SELECT ci.*,code ,ca.status ,\n" +
                        "ct.id as id_contract, il.id as id_illustration,\n" +
                        "            conadd_city , conadd_district \n" +
                        "            ,conadd_no_street ,conadd_wards, \n" +
                        "            curadd_city ,curadd_district ,\n" +
                        "            curadd_no_street , curadd_wards,  \n" +
                        "            peradd_city,peradd_district,peradd_no_street,peradd_wards,\n" +
                        "            workadd_city,workadd_district,workadd_no_street,workadd_wards\n" +
                        "            FROM is_agency_db.customer_info as ci\n" +
                        "            LEFT JOIN is_agency_db.contract as ct on ct.id_customer = ci.id\n" +
                        "            LEFT JOIN is_agency_db.illustration as il on il.id = ct.id_illustration \n" +
                        "            LEFT JOIN is_agency_db.customer_acc as ca on ci.id_account = ca.id \n" +
                        "            INNER JOIN contact_address as conadd ON conadd.conadd_id = ci.id_contact_address\n" +
                        "            INNER JOIN current_address as curadd ON curadd.curadd_id = ci.id_current_address \n" +
                        "            INNER JOIN permanent_address as peradd on peradd.peradd_id = ci.id_permanent_address \n" +
                        "            INNER JOIN workplace_address as workadd ON workadd.workadd_id = ci.id_workplace_address where ci.id = ?1 and ci.code_em_support = ?2 order by created_time desc",
        resultSetMapping = "stock_akhir_dto"
)
@NamedNativeQuery(
        name = "getCustomerInfoDetailForSaler",
        query =
                "SELECT ci.*,code ,ca.status ,\n" +
                        "null as id_contract, null id_illustration,\n"+
                        "\tconadd_city , conadd_district \n" +
                        "\t,conadd_no_street ,conadd_wards, \n" +
                        "\tcuradd_city ,curadd_district ,\n" +
                        "\tcuradd_no_street , curadd_wards,  \n" +
                        "\tperadd_city,peradd_district,peradd_no_street,peradd_wards,\n" +
                        "\tworkadd_city,workadd_district,workadd_no_street,workadd_wards\n" +
                        "\tFROM is_agency_db.customer_info as ci\n" +
                        "\tLEFT JOIN is_agency_db.customer_acc as ca on ci.id_account = ca.id \n" +
                        "\tINNER JOIN contact_address as conadd ON conadd.conadd_id = ci.id_contact_address\n" +
                        "\tINNER JOIN current_address as curadd ON curadd.curadd_id = ci.id_current_address\n" +
                        "\tINNER JOIN permanent_address as peradd on peradd.peradd_id = ci.id_permanent_address\n" +
                        "\tINNER JOIN workplace_address as workadd ON workadd.workadd_id = ci.id_workplace_address \n" +
                        "    where ci.code_em_support = ?1  order by created_time desc",
        resultSetMapping = "stock_akhir_dto"
)
@NamedNativeQuery(
        name = "getCustomerInfoDetailByIdCustomer",
        query =
                "SELECT ci.*,code ,ca.status ,\n" +
                        "ct.id as id_contract, il.id as id_illustration,\n" +
                        "            conadd_city , conadd_district \n" +
                        "            ,conadd_no_street ,conadd_wards, \n" +
                        "            curadd_city ,curadd_district ,\n" +
                        "            curadd_no_street , curadd_wards,  \n" +
                        "            peradd_city,peradd_district,peradd_no_street,peradd_wards,\n" +
                        "            workadd_city,workadd_district,workadd_no_street,workadd_wards\n" +
                        "            FROM is_agency_db.customer_info as ci\n" +
                        "            LEFT JOIN is_agency_db.contract as ct on ct.id_customer = ci.id\n" +
                        "            LEFT JOIN is_agency_db.illustration as il on il.id = ct.id_illustration \n" +
                        "            LEFT JOIN is_agency_db.customer_acc as ca on ci.id_account = ca.id \n" +
                        "            INNER JOIN contact_address as conadd ON conadd.conadd_id = ci.id_contact_address\n" +
                        "            INNER JOIN current_address as curadd ON curadd.curadd_id = ci.id_current_address \n" +
                        "            INNER JOIN permanent_address as peradd on peradd.peradd_id = ci.id_permanent_address \n" +
                        "            INNER JOIN workplace_address as workadd ON workadd.workadd_id = ci.id_workplace_address where ci.id = ?1 order by created_time desc",
        resultSetMapping = "stock_akhir_dto"
)
@SqlResultSetMapping(
        name = "stock_akhir_dto",
        classes = @ConstructorResult(
                targetClass = CustomerDTO.class,
                columns = {
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "birth_date", type = Date.class),
                        @ColumnResult(name = "age", type = Long.class),
                        @ColumnResult(name = "birth_address", type = String.class),
                        @ColumnResult(name = "types_identification", type = String.class),
                        @ColumnResult(name = "id_card", type = String.class),
                        @ColumnResult(name = "nationality_1", type = String.class),
                        @ColumnResult(name = "nationality_2", type = String.class),
                        @ColumnResult(name = "nation", type = String.class),
                        @ColumnResult(name = "job", type = String.class),
                        @ColumnResult(name = "career", type = String.class),
                        @ColumnResult(name = "position", type = String.class),
                        @ColumnResult(name = "occupation_group", type = String.class),
                        @ColumnResult(name = "company_name", type = String.class),
                        @ColumnResult(name = "main_business", type = String.class),
                        @ColumnResult(name = "specific_work", type = String.class),
                        @ColumnResult(name = "monthly_income", type = Long.class),
                        @ColumnResult(name = "email", type = String.class),
                        @ColumnResult(name = "phone_1", type = String.class),
                        @ColumnResult(name = "phone_2", type = String.class),
                        @ColumnResult(name = "id_account", type = Long.class),
                        @ColumnResult(name = "full_name", type = String.class),
                        @ColumnResult(name = "code", type = String.class),
                        @ColumnResult(name = "status", type = Long.class),


                        @ColumnResult(name = "conadd_no_street", type = String.class),
                        @ColumnResult(name = "conadd_city", type = String.class),
                        @ColumnResult(name = "conadd_district", type = String.class),
                        @ColumnResult(name = "conadd_wards", type = String.class),

                        @ColumnResult(name = "curadd_no_street", type = String.class),
                        @ColumnResult(name = "curadd_city", type = String.class),
                        @ColumnResult(name = "curadd_district", type = String.class),
                        @ColumnResult(name = "curadd_wards", type = String.class),

                        @ColumnResult(name = "peradd_no_street", type = String.class),
                        @ColumnResult(name = "peradd_city", type = String.class),
                        @ColumnResult(name = "peradd_district", type = String.class),
                        @ColumnResult(name = "peradd_wards", type = String.class),

                        @ColumnResult(name = "workadd_no_street", type = String.class),
                        @ColumnResult(name = "workadd_city", type = String.class),
                        @ColumnResult(name = "workadd_district", type = String.class),
                        @ColumnResult(name = "workadd_wards", type = String.class),


                        @ColumnResult(name = "id_contract", type = Long.class),
                        @ColumnResult(name = "id_illustration", type = Long.class),

                        @ColumnResult(name = "code_em_support", type = String.class),
                        @ColumnResult(name = "gender", type = Long.class),
                        @ColumnResult(name = "id_current_address", type = Long.class),
                        @ColumnResult(name = "id_permanent_address", type = Long.class),
                        @ColumnResult(name = "id_contact_address", type = Long.class),
                        @ColumnResult(name = "id_workplace_address", type = Long.class),
                        @ColumnResult(name = "updated_time", type = Date.class),
                        @ColumnResult(name = "marital_status", type = Long.class),
                        @ColumnResult(name = "created_time", type = Date.class),
                        @ColumnResult(name = "source", type = String.class)




                }
        )
)
public class CustomerDTO {
    @Id
    @Column
    private Long id;
    @Column
    private Date birth_date;
    @Column
    private Long age;
    @Column
    private String birth_address;
    @Column
    private String types_identification;
    @Column
    private String id_card;
    @Column
    private String nationality_1;
    @Column
    private String nationality_2;
    @Column
    private String nation;
    @Column
    private String job;
    @Column
    private String career;
    @Column
    private String position;
    @Column
    private String occupation_group;
    @Column
    private String company_name;
    @Column
    private String main_business;
    @Column
    private String specific_work;
    @Column
    private Long monthly_income;
    @Column
    private String email;
    @Column
    private String phone_1;
    @Column
    private String phone_2;
    @Column
    private Long id_account;
    @Column
    private String full_name;
    @Column
    private String code;
    @Column
    private Long status;

    @Column
    private String conadd_no_street;
    @Column
    private String conadd_city;
    @Column
    private String conadd_district;
    @Column
    private String conadd_wards;

    @Column
    private String curadd_no_street;
    @Column
    private String curadd_city;
    @Column
    private String curadd_district;
    @Column
    private String curadd_wards;

    @Column
    private String peradd_no_street;
    @Column
    private String peradd_city;
    @Column
    private String peradd_district;
    @Column
    private String peradd_wards;

    @Column
    private String workadd_no_street;
    @Column
    private String workadd_city;
    @Column
    private String workadd_district;
    @Column
    private String workadd_wards;

    @Column
    private Long id_contract;
    @Column
    private Long id_illustration;

    @Column
    private String code_em_support;

    @Column
    private Long gender;
    @Column
    private Long id_current_address;
    @Column
    private Long id_permanent_address;
    @Column
    private Long id_contact_address;
    @Column
    private Long id_workplace_address;
    @Column
    private Date updated_time;
    @Column
    private Long marital_status;
    @Column
    private Date created_time;
    @Column
    private String source;

}
