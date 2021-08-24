package com.is.issystem;

import com.is.issystem.dto.DistrictDTO;
import com.is.issystem.entities.Contact;
import com.is.issystem.entities.Kpi;
import com.is.issystem.entities.Notification;
import com.is.issystem.entities.RequestClaimApprove;
import com.is.issystem.service.ContactService;
import com.is.issystem.service.RequestService;
import com.is.issystem.service.RevenueService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class IssystemApplicationTests {

    @Autowired
    RevenueService revenueService;

    @Autowired
    ContactService contactService;


    @Test
    void contextLoads() {
    }

    @Test
    void getAllKpiEmployee_UTC01() {
        String code_employee = "cuong";
        Assertions.assertNotNull(revenueService.getAllKpiEmployee(code_employee));
    }

    @Test
    void getAllKpiEmployee_UTC02() {
        String code_employee = "cuongnvm";
        Assertions.assertNotNull(revenueService.getAllKpiEmployee(code_employee));
    }

    @Test
    void getAllKpiEmployee_UTC03() {
        String code_employee = "cuongnvm34";
        Assertions.assertNotNull(revenueService.getAllKpiEmployee(code_employee));
    }

    @Test
    void getAllNewContactByIdProvince_UTC01() {
        Integer id_province = 1;
        Assertions.assertNotNull(contactService.getAllNewContactByProvince(id_province));
    }

    @Test
    void getAllNewContactByIdProvince_UTC02() {
        Integer id_province = 21;
        Assertions.assertNotNull(contactService.getAllNewContactByProvince(id_province));
    }

    @Test
    void getAllNewContactByIdProvince_UTC03() {
        Integer id_province = 30;
        Assertions.assertNotNull(contactService.getAllNewContactByProvince(id_province));
    }

    @Test
    void getAllNewContactByIdProvince_UTC04() {
        Integer id_province = 50;
        Assertions.assertNotNull(contactService.getAllNewContactByProvince(id_province));
    }

    @Test
    void getAllNewContactByIdProvince_UTC05() {
        Integer id_province = -7;
        Assertions.assertNotNull(contactService.getAllNewContactByProvince(id_province));
    }

    @Test
    void getAllNewContactByIdProvince_UTC06() {
        Integer id_province = 4;
        Assertions.assertNotNull(contactService.getAllNewContactByProvince(id_province));
    }

    @Test
    void getAllNewContactByIdProvince_UTC07() {
        Integer id_province = 2;
        Assertions.assertNotNull(contactService.getAllNewContactByProvince(id_province));
    }

    @Test
    void searchAllNewContactByIdProvince_UTC01() {
        Integer id_province = 1;
        String dateFrom = "2021/05/13";
        String dateTo = "2021/08/05";
        String searchValue = "";
        Assertions.assertNotNull(contactService.searchAllNewContactByIdProvince(id_province,dateFrom,dateTo,searchValue));
    }

    @Test
    void searchAllNewContactByIdProvince_UTC02() {
        Integer id_province = 1;
        String dateFrom = "2021/05/13";
        String dateTo = "2021/08/05";
        String searchValue = "Ng";
        Assertions.assertNotNull(contactService.searchAllNewContactByIdProvince(id_province,dateFrom,dateTo,searchValue));
    }

    @Test
    void searchAllNewContactByIdProvince_UTC03() {
        Integer id_province = 1;
        String dateFrom = "2021/05/13";
        String dateTo = "2021/08/05";
        String searchValue = "Dong";
        Assertions.assertNotNull(contactService.searchAllNewContactByIdProvince(id_province,dateFrom,dateTo,searchValue));
    }

    @Test
    void searchAllNewContactByIdProvince_UTC04() {
        Integer id_province = -2;
        String dateFrom = "2021/05/13";
        String dateTo = "2021/08/05";
        String searchValue = "";
        Assertions.assertNotNull(contactService.searchAllNewContactByIdProvince(id_province,dateFrom,dateTo,searchValue));
    }

    @Test
    void searchAllNewContactByIdProvince_UTC05() {
        Integer id_province = -2;
        String dateFrom = "2021/02/30";
        String dateTo = "2021/04/11";
        String searchValue = "Ng";
        Assertions.assertNotNull(contactService.searchAllNewContactByIdProvince(id_province,dateFrom,dateTo,searchValue));
    }

    @Test
    void searchAllNewContactByIdProvince_UTC06() {
        Integer id_province = 1;
        String dateFrom = "2021/02/30";
        String dateTo = "2021/04/11";
        String searchValue = "Dong";
        Assertions.assertNotNull(contactService.searchAllNewContactByIdProvince(id_province,dateFrom,dateTo,searchValue));
    }

    @Test
    void searchAllNewContactByIdProvince_UTC07() {
        Integer id_province = 1;
        String dateFrom = "2021/02/30";
        String dateTo = "2021/02/31";
        String searchValue = "Ng";
        Assertions.assertNotNull(contactService.searchAllNewContactByIdProvince(id_province,dateFrom,dateTo,searchValue));
    }

    @Test
    void searchAllNewContactByIdProvince_UTC08() {
        Integer id_province = 1;
        String dateFrom = "2021/05/13";
        String dateTo = "2021/02/31";
        String searchValue = "Ng";
        Assertions.assertNotNull(contactService.searchAllNewContactByIdProvince(id_province,dateFrom,dateTo,searchValue));
    }

    @Test
    void searchAllNewContactByIdProvince_UTC09() {
        Integer id_province = 1;
        String dateFrom = "2021/05/13";
        String dateTo = "2021/04/11";
        String searchValue = "";
        Assertions.assertNotNull(contactService.searchAllNewContactByIdProvince(id_province,dateFrom,dateTo,searchValue));
    }

    @Test
    void searchAllNewContactByIdProvince_UTC10() {
        Integer id_province = 1;
        String dateFrom = "2021/05/13";
        String dateTo = "2021/04/11";
        String searchValue = "Ng";
        Assertions.assertNotNull(contactService.searchAllNewContactByIdProvince(id_province,dateFrom,dateTo,searchValue));
    }

    @Test
    void searchAllNewContactByIdProvince_UTC011() {
        Integer id_province = 1;
        String dateFrom = "2021/05/13";
        String dateTo = "2021/08/05";
        String searchValue = "";
        Assertions.assertNotNull(contactService.searchAllNewContactByIdProvince(id_province,dateFrom,dateTo,searchValue));
    }

    @Test
    void searchAllNewContactByIdProvince_UTC012() {
        Integer id_province = 1;
        String dateFrom = "2021/05/13";
        String dateTo = "2021/08/05";
        String searchValue = "Ng";
        Assertions.assertNotNull(contactService.searchAllNewContactByIdProvince(id_province,dateFrom,dateTo,searchValue));
    }

    @Test
    void searchAllNewContactByIdProvince_UTC013() {
        Integer id_province = 1;
        String dateFrom = "";
        String dateTo = "";
        String searchValue = "Ng";
        Assertions.assertNotNull(contactService.searchAllNewContactByIdProvince(id_province,dateFrom,dateTo,searchValue));
    }

    @Test
    void searchAllNewContactByIdProvince_UTC014() {
        Integer id_province = 1;
        String dateFrom = "2021/05/13";
        String dateTo = "2021/08/05";
        String searchValue = "Dong";
        Assertions.assertNotNull(contactService.searchAllNewContactByIdProvince(id_province,dateFrom,dateTo,searchValue));
    }

    @Test
    void searchAllNewContactByIdProvince_UTC015() {
        Integer id_province = 3;
        String dateFrom = "";
        String dateTo = "2021/08/05";
        String searchValue = "";
        Assertions.assertNotNull(contactService.searchAllNewContactByIdProvince(id_province,dateFrom,dateTo,searchValue));
    }

    @Test
    void searchAllNewContactByIdProvince_UTC016() {
        Integer id_province = 1;
        String dateFrom = "2021/05/13";
        String dateTo = "2021/08/05";
        String searchValue = "Ng";
        Assertions.assertNotNull(contactService.searchAllNewContactByIdProvince(id_province,dateFrom,dateTo,searchValue));
    }

    @Test
    void searchAllNewContactByIdProvince_UTC017() {
        Integer id_province = 3;
        String dateFrom = "2021/05/13";
        String dateTo = "";
        String searchValue = "";
        Assertions.assertNotNull(contactService.searchAllNewContactByIdProvince(id_province,dateFrom,dateTo,searchValue));
    }

    @Test
    void searchAllNewContactByIdProvince_UTC018() {
        Integer id_province = 1;
        String dateFrom = "";
        String dateTo = "2021/04/11";
        String searchValue = "";
        Assertions.assertNotNull(contactService.searchAllNewContactByIdProvince(id_province,dateFrom,dateTo,searchValue));
    }

    @Test
    void searchAllNewContactByIdProvince_UTC019() {
        Integer id_province = 1;
        String dateFrom = "";
        String dateTo = "2021/08/05";
        String searchValue = "";
        Assertions.assertNotNull(contactService.searchAllNewContactByIdProvince(id_province,dateFrom,dateTo,searchValue));
    }

    @Test
    void searchAllNewContactByIdProvince_UTC020() {
        Integer id_province = -2;
        String dateFrom = "";
        String dateTo = "2021/08/05";
        String searchValue = "";
        Assertions.assertNotNull(contactService.searchAllNewContactByIdProvince(id_province,dateFrom,dateTo,searchValue));
    }

    @Test
    void searchAllNewContactByIdProvince_UTC021() {
        Integer id_province = 3;
        String dateFrom = "";
        String dateTo = "2021/02/31";
        String searchValue = "";
        Assertions.assertNotNull(contactService.searchAllNewContactByIdProvince(id_province,dateFrom,dateTo,searchValue));
    }

    @Autowired
    private RequestService requestService;

    @Test
    void getDetailClaimRequest_UTC01() {
        Integer claimRequest_id = 10;
        Assertions.assertNotNull(requestService.getDetailClaimRequest(claimRequest_id));
    }

    @Test
    void getDetailClaimRequest_UTC02() {
        Integer claimRequest_id = 9;
        Assertions.assertNotNull(requestService.getDetailClaimRequest(claimRequest_id));
    }

    @Test
    void getDetailClaimRequest_UTC03() {
        Integer claimRequest_id = 11;
        Assertions.assertNotNull(requestService.getDetailClaimRequest(claimRequest_id));
    }

    @Test
    void getDetailClaimRequest_UTC04() {
        Integer claimRequest_id = 12;
        Assertions.assertNotNull(requestService.getDetailClaimRequest(claimRequest_id));
    }

    @Test
    void getDetailClaimRequest_UTC05() {
        Integer claimRequest_id = -4;
        Assertions.assertNotNull(requestService.getDetailClaimRequest(claimRequest_id));
    }

    @Test
    void getDetailClaimRequest_UTC06() {
        Integer claimRequest_id = 6;
        Assertions.assertNotNull(requestService.getDetailClaimRequest(claimRequest_id));
    }

    @Test
    void getAllRevenueEmployeeEx_UTC01() {
        List<String> codes_em_support = new ArrayList<>();
        codes_em_support.add("cuong");
        codes_em_support.add("manh");
        Assertions.assertNotNull(revenueService.getAllRevenueEmployeeEx(codes_em_support));
    }

    @Test
    void getAllRevenueEmployeeEx_UTC02() {
        List<String> codes_em_support = new ArrayList<>();
        codes_em_support.add("cuong");
        codes_em_support.add("manh");
        codes_em_support.add("hieudd2");
        codes_em_support.add("cuongnvm");
        Assertions.assertNotNull(revenueService.getAllRevenueEmployeeEx(codes_em_support));
    }

    @Test
    void getAllRevenueEmployeeEx_UTC03() {
        List<String> codes_em_support = new ArrayList<>();
        codes_em_support.add("cuong");
        codes_em_support.add("manh");
        codes_em_support.add("hieudd2");
        Assertions.assertNotNull(revenueService.getAllRevenueEmployeeEx(codes_em_support));
    }

    @Test
    void getAllRevenueEmployeeEx_UTC04() {
        List<String> codes_em_support = new ArrayList<>();
        codes_em_support.add("cuong");
        codes_em_support.add("manh");
        codes_em_support.add("hieudd2");
        codes_em_support.add("cuongnvm34");
        Assertions.assertNotNull(revenueService.getAllRevenueEmployeeEx(codes_em_support));
    }

    @Test
    void getAllRevenueEmployeeEx_UTC05() {
        List<String> codes_em_support = new ArrayList<>();
        codes_em_support.add("cuong");
        codes_em_support.add("manh");
        codes_em_support.add("hieudd2");
        codes_em_support.add("cuongnvm34");
        codes_em_support.add("minhnq1");
        Assertions.assertNotNull(revenueService.getAllRevenueEmployeeEx(codes_em_support));
    }

    @Test
    void getAllRevenueEmployeeEx_UTC06() {
        List<String> codes_em_support = new ArrayList<>();
        codes_em_support.add("cuong");
        codes_em_support.add("manh");
        codes_em_support.add("hieudd2");
        codes_em_support.add("cuongnvm34");
        codes_em_support.add("dong1");
        Assertions.assertNotNull(revenueService.getAllRevenueEmployeeEx(codes_em_support));
    }

    @Test
    void getAllIncomeForSaler_UTC01() {
        String code_employee = "cuong";
        Assertions.assertNotNull(revenueService.getAllIncomeForSaler(code_employee));
    }

    @Test
    void getAllIncomeForSaler_UTC02() {
        String code_employee = "cuongnvm";
        Assertions.assertNotNull(revenueService.getAllIncomeForSaler(code_employee));
    }

    @Test
    void getAllIncomeForSaler_UTC03() {
        String code_employee = "tupa1";
        Assertions.assertNotNull(revenueService.getAllIncomeForSaler(code_employee));
    }

    @Test
    void saveOneKpi_UTC01() throws ParseException{
        Kpi kpi = new Kpi();
        kpi.setCode_employee("cuong");
        kpi.setTarget(BigInteger.valueOf(90000000));
        kpi.setCreate_time(new SimpleDateFormat("yyyy/mm/dd").parse("2021/07/21"));
        Assertions.assertNotNull(revenueService.saveOneKpi(kpi));
    }

    @Test
    void saveOneKpi_UTC02() throws ParseException{
        Kpi kpi = new Kpi();
        kpi.setCode_employee("cuong");
        kpi.setTarget(BigInteger.valueOf(-20000000));
        kpi.setCreate_time(new SimpleDateFormat("yyyy/mm/dd").parse("2021/07/21"));
        Assertions.assertNotNull(revenueService.saveOneKpi(kpi));
    }

    @Test
    void saveOneKpi_UTC03() throws ParseException{
        Kpi kpi = new Kpi();
        kpi.setCode_employee("cuong");
        kpi.setTarget(BigInteger.valueOf(90000000));
        kpi.setCreate_time(new SimpleDateFormat("yyyy/mm/dd").parse("2021/08/10"));
        Assertions.assertNotNull(revenueService.saveOneKpi(kpi));
    }

    @Test
    void saveOneKpi_UTC04() throws ParseException{
        Kpi kpi = new Kpi();
        kpi.setCode_employee("cuongnvm");
        kpi.setTarget(BigInteger.valueOf(90000000));
        kpi.setCreate_time(new SimpleDateFormat("yyyy/mm/dd").parse("2021/07/21"));
        Assertions.assertNotNull(revenueService.saveOneKpi(kpi));
    }

    @Test
    void saveOneKpi_UTC05() throws ParseException{
        Kpi kpi = new Kpi();
        kpi.setCode_employee("cuongnvm");
        kpi.setTarget(BigInteger.valueOf(90000000));
        kpi.setCreate_time(new SimpleDateFormat("yyyy/mm/dd").parse("2021/08/10"));
        Assertions.assertNotNull(revenueService.saveOneKpi(kpi));
    }

    @Test
    void updateContact_UTC01() {
        String status = "Đã liên hệ với khách hàng";
        String code_sale = "cuong";
        Integer id_contact = 11;
        Assertions.assertNotNull(contactService.updateContact(code_sale,status,id_contact));
    }

    @Test
    void updateContact_UTC02() {
        String status = "";
        String code_sale = "cuong";
        Integer id_contact = 11;
        Assertions.assertNotNull(contactService.updateContact(code_sale,status,id_contact));
    }

    @Test
    void updateContact_UTC03() {
        String status = "Đã liên hệ với khách hàng";
        String code_sale = "cuong";
        Integer id_contact = 20;
        Assertions.assertNotNull(contactService.updateContact(code_sale,status,id_contact));
    }

    @Test
    void updateContact_UTC04() {
        String status = "";
        String code_sale = "cuong";
        Integer id_contact = 20;
        Assertions.assertNotNull(contactService.updateContact(code_sale,status,id_contact));
    }

    @Test
    void addOneContact_UTC01() {
        Contact contact = new Contact();
        contact.setCustomer_name("Nguyễn Duy Đông");
        contact.setPhone("091357035");
        contact.setId_province(1);
        contact.setId_district(1);
        contact.setQuestion("Tư vấn giúp tôi các loại bảo hiểm");
        contact.setStatus("");
        contact.setCreate_time(new Date());
        contact.setCode_sale("cuong");
        Assertions.assertThrows(Exception.class, () -> contactService.addOneContact(contact));
    }

    @Test
    void addOneContact_UTC02() {
        Contact contact = new Contact();
        contact.setCustomer_name("Nguyễn Duy Đông");
        contact.setPhone("091357035");
        contact.setId_province(1);
        contact.setId_district(1);
        contact.setQuestion("");
        Assertions.assertThrows(Exception.class, () -> contactService.addOneContact(contact));
    }

    @Test
    void addOneContact_UTC03() {
        Contact contact = new Contact();
        contact.setCustomer_name("");
        contact.setPhone("091357035");
        contact.setId_province(1);
        contact.setId_district(1);
        contact.setQuestion("Tư vấn giúp tôi các loại bảo hiểm");
        Assertions.assertThrows(Exception.class, () -> contactService.addOneContact(contact));
    }

    @Test
    void addOneContact_UTC04() {
        Contact contact = new Contact();
        contact.setCustomer_name("");
        contact.setPhone("091357035");
        contact.setId_province(1);
        contact.setId_district(1);
        contact.setQuestion("");
        Assertions.assertThrows(Exception.class, () -> contactService.addOneContact(contact));
    }

    @Test
    void addOneContact_UTC05() {
        Contact contact = new Contact();
        contact.setCustomer_name("");
        contact.setPhone("091357035");
        contact.setId_province(0);
        contact.setId_district(0);
        contact.setQuestion("Tư vấn giúp tôi các loại bảo hiểm");
        Assertions.assertThrows(Exception.class, () -> contactService.addOneContact(contact));
    }

    @Test
    void addOneContact_UTC06() {
        Contact contact = new Contact();
        contact.setCustomer_name("");
        contact.setPhone("091357035");
        contact.setId_province(0);
        contact.setId_district(0);
        contact.setQuestion("");
        Assertions.assertThrows(Exception.class, () -> contactService.addOneContact(contact));
    }

    @Test
    void addOneContact_UTC07() {
        Contact contact = new Contact();
        contact.setCustomer_name("Nguyễn Duy Tiến");
        contact.setPhone("");
        contact.setId_province(1);
        contact.setId_district(1);
        contact.setQuestion("Tư vấn giúp tôi các loại bảo hiểm");
        Assertions.assertThrows(Exception.class, () -> contactService.addOneContact(contact));
    }

    @Test
    void addOneContact_UTC08() {
        Contact contact = new Contact();
        contact.setCustomer_name("");
        contact.setPhone("");
        contact.setId_province(0);
        contact.setId_district(0);
        contact.setQuestion("");
        Assertions.assertThrows(Exception.class, () -> contactService.addOneContact(contact));
    }

    @Test
    void addOneContact_UTC09() {
        Contact contact = new Contact();
        contact.setCustomer_name("Nguyễn Duy Tiến");
        contact.setPhone("091354876");
        contact.setId_province(0);
        contact.setId_district(0);
        contact.setQuestion("");
        Assertions.assertThrows(Exception.class, () -> contactService.addOneContact(contact));
    }

    @Test
    void addOneContact_UTC10() {
        Contact contact = new Contact();
        contact.setCustomer_name("Nguyễn Duy Tiến");
        contact.setPhone("");
        contact.setId_province(1);
        contact.setId_district(1);
        contact.setQuestion("Tư vấn giúp tôi các loại bảo hiểm");
        Assertions.assertThrows(Exception.class, () -> contactService.addOneContact(contact));
    }

    @Test
    void getAllClaimRequestApproval_UTC01() {
        String userCode = "tien";
        Assertions.assertNotNull(requestService.getAllClaimRequestApproval(userCode));
    }

    @Test
    void getAllClaimRequestApproval_UTC02() {
        String userCode = "quannv";
        Assertions.assertNotNull(requestService.getAllClaimRequestApproval(userCode));
    }

    @Test
    void getAllClaimRequestApproval_UTC03() {
        String userCode = "dong";
        Assertions.assertNotNull(requestService.getAllClaimRequestApproval(userCode));
    }

    @Test
    void searchAllClaimRequestApproval_UTC01() {
        String code_appraiser = "tien";
        String fromDate = "2021/06/24";
        String toDate = "2021/07/13";
        String searchValue = "";
        Assertions.assertNotNull(requestService.searchAllClaimRequestApproval(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllClaimRequestApproval_UTC02() {
        String code_appraiser = "tien";
        String fromDate = "2021/07/13";
        String toDate = "";
        String searchValue = "";
        Assertions.assertNotNull(requestService.searchAllClaimRequestApproval(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllClaimRequestApproval_UTC03() {
        String code_appraiser = "tien";
        String fromDate = "2021/06/24";
        String toDate = "2021/07/13";
        String searchValue = "64";
        Assertions.assertNotNull(requestService.searchAllClaimRequestApproval(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllClaimRequestApproval_UTC04() {
        String code_appraiser = "tien";
        String fromDate = "2021/06/24";
        String toDate = "2021/07/13";
        String searchValue = "19";
        Assertions.assertNotNull(requestService.searchAllClaimRequestApproval(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllClaimRequestApproval_UTC05() {
        String code_appraiser = "tien";
        String fromDate = "2021/06/24";
        String toDate = "2021/07/13";
        String searchValue = "kh";
        Assertions.assertNotNull(requestService.searchAllClaimRequestApproval(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllClaimRequestApproval_UTC06() {
        String code_appraiser = "tien";
        String fromDate = "";
        String toDate = "";
        String searchValue = "";
        Assertions.assertNotNull(requestService.searchAllClaimRequestApproval(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllClaimRequestApproval_UTC07() {
        String code_appraiser = "tien";
        String fromDate = "";
        String toDate = "";
        String searchValue = "64";
        Assertions.assertNotNull(requestService.searchAllClaimRequestApproval(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllClaimRequestApproval_UTC08() {
        String code_appraiser = "tien";
        String fromDate = "";
        String toDate = "";
        String searchValue = "19";
        Assertions.assertNotNull(requestService.searchAllClaimRequestApproval(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllClaimRequestApproval_UTC09() {
        String code_appraiser = "tien";
        String fromDate = "";
        String toDate = "";
        String searchValue = "kh";
        Assertions.assertNotNull(requestService.searchAllClaimRequestApproval(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllClaimRequestApproval_UTC10() {
        String code_appraiser = "tien";
        String fromDate = "";
        String toDate = "2021/07/13";
        String searchValue = "";
        Assertions.assertNotNull(requestService.searchAllClaimRequestApproval(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllClaimRequestApproval_UTC11() {
        String code_appraiser = "tien";
        String fromDate = "";
        String toDate = "2021/07/13";
        String searchValue = "64";
        Assertions.assertNotNull(requestService.searchAllClaimRequestApproval(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllClaimRequestApproval_UTC12() {
        String code_appraiser = "tien";
        String fromDate = "";
        String toDate = "2021/07/13";
        String searchValue = "19";
        Assertions.assertNotNull(requestService.searchAllClaimRequestApproval(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllClaimRequestApproval_UTC13() {
        String code_appraiser = "tien";
        String fromDate = "";
        String toDate = "2021/07/13";
        String searchValue = "kh";
        Assertions.assertNotNull(requestService.searchAllClaimRequestApproval(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllClaimRequestApproval_UTC14() {
        String code_appraiser = "tien";
        String fromDate = "2021/07/01";
        String toDate = "2021/07/13";
        String searchValue = "";
        Assertions.assertNotNull(requestService.searchAllClaimRequestApproval(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllClaimRequestApproval_UTC15() {
        String code_appraiser = "tien";
        String fromDate = "2021/07/01";
        String toDate = "2021/07/13";
        String searchValue = "64";
        Assertions.assertNotNull(requestService.searchAllClaimRequestApproval(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllClaimRequestApproval_UTC16() {
        String code_appraiser = "tien";
        String fromDate = "2021/07/01";
        String toDate = "2021/07/13";
        String searchValue = "19";
        Assertions.assertNotNull(requestService.searchAllClaimRequestApproval(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllClaimRequestApproval_UTC17() {
        String code_appraiser = "tien";
        String fromDate = "2021/07/01";
        String toDate = "2021/07/13";
        String searchValue = "kh";
        Assertions.assertNotNull(requestService.searchAllClaimRequestApproval(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllClaimRequestApproval_UTC18() {
        String code_appraiser = "tien";
        String fromDate = "2021/07/01";
        String toDate = "";
        String searchValue = "64";
        Assertions.assertNotNull(requestService.searchAllClaimRequestApproval(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllClaimRequestApproval_UTC19() {
        String code_appraiser = "tien";
        String fromDate = "2021/07/01";
        String toDate = "";
        String searchValue = "19";
        Assertions.assertNotNull(requestService.searchAllClaimRequestApproval(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllClaimRequestApproval_UTC20() {
        String code_appraiser = "tien";
        String fromDate = "2021/07/01";
        String toDate = "";
        String searchValue = "kh";
        Assertions.assertNotNull(requestService.searchAllClaimRequestApproval(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void getAllApprovedClaimReq_UTC01() {
        String code_appraiser = "tien";
        Assertions.assertNotNull(requestService.getAllApprovedClaimReq(code_appraiser));
    }

    @Test
    void getAllApprovedClaimReq_UTC02() {
        String code_appraiser = "quan";
        Assertions.assertNotNull(requestService.getAllApprovedClaimReq(code_appraiser));
    }

    @Test
    void searchAllUncheckClaimReq_UTC01() {
        String code_appraiser = "tien";
        String fromDate = "2021/06/24";
        String toDate = "2021/07/13";
        String searchValue = "";
        Assertions.assertNotNull(requestService.searchAllUncheckClaimReq(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllUncheckClaimReq_UTC02() {
        String code_appraiser = "tien";
        String fromDate = "2021/07/01";
        String toDate = "";
        String searchValue = "";
        Assertions.assertNotNull(requestService.searchAllUncheckClaimReq(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllUncheckClaimReq_UTC03() {
        String code_appraiser = "tien";
        String fromDate = "2021/06/24";
        String toDate = "2021/07/13";
        String searchValue = "64";
        Assertions.assertNotNull(requestService.searchAllUncheckClaimReq(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllUncheckClaimReq_UTC04() {
        String code_appraiser = "tien";
        String fromDate = "2021/06/24";
        String toDate = "2021/07/13";
        String searchValue = "19";
        Assertions.assertNotNull(requestService.searchAllUncheckClaimReq(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllUncheckClaimReq_UTC05() {
        String code_appraiser = "tien";
        String fromDate = "2021/06/24";
        String toDate = "2021/07/13";
        String searchValue = "abc";
        Assertions.assertNotNull(requestService.searchAllUncheckClaimReq(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllUncheckClaimReq_UTC06() {
        String code_appraiser = "tien";
        String fromDate = "";
        String toDate = "";
        String searchValue = "";
        Assertions.assertNotNull(requestService.searchAllUncheckClaimReq(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllUncheckClaimReq_UTC07() {
        String code_appraiser = "tien";
        String fromDate = "";
        String toDate = "";
        String searchValue = "64";
        Assertions.assertNotNull(requestService.searchAllUncheckClaimReq(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllUncheckClaimReq_UTC08() {
        String code_appraiser = "tien";
        String fromDate = "";
        String toDate = "";
        String searchValue = "19";
        Assertions.assertNotNull(requestService.searchAllUncheckClaimReq(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllUncheckClaimReq_UTC09() {
        String code_appraiser = "tien";
        String fromDate = "";
        String toDate = "";
        String searchValue = "abc";
        Assertions.assertNotNull(requestService.searchAllUncheckClaimReq(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllUncheckClaimReq_UTC10() {
        String code_appraiser = "tien";
        String fromDate = "";
        String toDate = "2021/07/13";
        String searchValue = "";
        Assertions.assertNotNull(requestService.searchAllUncheckClaimReq(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllUncheckClaimReq_UTC11() {
        String code_appraiser = "tien";
        String fromDate = "";
        String toDate = "2021/07/13";
        String searchValue = "64";
        Assertions.assertNotNull(requestService.searchAllUncheckClaimReq(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllUncheckClaimReq_UTC12() {
        String code_appraiser = "tien";
        String fromDate = "";
        String toDate = "2021/07/13";
        String searchValue = "19";
        Assertions.assertNotNull(requestService.searchAllUncheckClaimReq(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllUncheckClaimReq_UTC13() {
        String code_appraiser = "tien";
        String fromDate = "";
        String toDate = "2021/07/13";
        String searchValue = "abc";
        Assertions.assertNotNull(requestService.searchAllUncheckClaimReq(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllUncheckClaimReq_UTC14() {
        String code_appraiser = "tien";
        String fromDate = "2021/07/01";
        String toDate = "2021/07/13";
        String searchValue = "";
        Assertions.assertNotNull(requestService.searchAllUncheckClaimReq(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllUncheckClaimReq_UTC15() {
        String code_appraiser = "tien";
        String fromDate = "2021/07/01";
        String toDate = "2021/07/13";
        String searchValue = "64";
        Assertions.assertNotNull(requestService.searchAllUncheckClaimReq(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllUncheckClaimReq_UTC16() {
        String code_appraiser = "tien";
        String fromDate = "2021/07/01";
        String toDate = "2021/07/13";
        String searchValue = "19";
        Assertions.assertNotNull(requestService.searchAllUncheckClaimReq(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllUncheckClaimReq_UTC17() {
        String code_appraiser = "tien";
        String fromDate = "2021/07/01";
        String toDate = "2021/07/13";
        String searchValue = "abc";
        Assertions.assertNotNull(requestService.searchAllUncheckClaimReq(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllUncheckClaimReq_UTC18() {
        String code_appraiser = "tien";
        String fromDate = "2021/07/01";
        String toDate = "";
        String searchValue = "64";
        Assertions.assertNotNull(requestService.searchAllUncheckClaimReq(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllUncheckClaimReq_UTC19() {
        String code_appraiser = "tien";
        String fromDate = "2021/07/01";
        String toDate = "";
        String searchValue = "19";
        Assertions.assertNotNull(requestService.searchAllUncheckClaimReq(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void searchAllUncheckClaimReq_UTC20() {
        String code_appraiser = "tien";
        String fromDate = "2021/07/01";
        String toDate = "";
        String searchValue = "abc";
        Assertions.assertNotNull(requestService.searchAllUncheckClaimReq(code_appraiser,fromDate,toDate,searchValue));
    }

    @Test
    void addClaimReq_UTC01() throws ParseException {
        RequestClaimApprove requestClaimApprove = new RequestClaimApprove();
        requestClaimApprove.setName("Yeu cau duyet boi thuong tai nan giao thong");
        requestClaimApprove.setDate(new SimpleDateFormat("yyyy/mm/dd").parse("2021/06/30"));
        requestClaimApprove.setCode_sender("fdsv");
        requestClaimApprove.setDescription("Dong y chi tra");
        requestClaimApprove.setAmount_main(BigInteger.valueOf(11111111));
        requestClaimApprove.setStatus("DD");
        requestClaimApprove.setId_contract(19);
        requestClaimApprove.setId_request(75);
        Assertions.assertNotNull(requestService.addClaimReq(requestClaimApprove));
    }

    @Test
    void addClaimReq_UTC02() throws ParseException {
        RequestClaimApprove requestClaimApprove = new RequestClaimApprove();
        requestClaimApprove.setName("Yeu cau duyet boi thuong tai nan giao thong");
        requestClaimApprove.setDate(new SimpleDateFormat("yyyy/mm/dd").parse("2021/06/30"));
        requestClaimApprove.setCode_sender("fdsv");
        requestClaimApprove.setDescription("");
        requestClaimApprove.setAmount_main(BigInteger.valueOf(11111111));
        requestClaimApprove.setStatus("DD");
        requestClaimApprove.setId_contract(19);
        requestClaimApprove.setId_request(75);
        Assertions.assertNotNull(requestService.addClaimReq(requestClaimApprove));
    }

    @Test
    void addClaimReq_UTC03() throws ParseException {
        RequestClaimApprove requestClaimApprove = new RequestClaimApprove();
        requestClaimApprove.setName("Yeu cau duyet boi thuong tai nan giao thong");
        requestClaimApprove.setDate(new SimpleDateFormat("yyyy/mm/dd").parse("2021/02/30"));
        requestClaimApprove.setCode_sender("fdsv");
        requestClaimApprove.setDescription("Dong y chi tra");
        requestClaimApprove.setAmount_main(BigInteger.valueOf(11111111));
        requestClaimApprove.setStatus("DD");
        requestClaimApprove.setId_contract(19);
        requestClaimApprove.setId_request(75);
        Assertions.assertNotNull(requestService.addClaimReq(requestClaimApprove));
    }

    @Test
    void addClaimReq_UTC04() throws ParseException {
        RequestClaimApprove requestClaimApprove = new RequestClaimApprove();
        requestClaimApprove.setName("Yeu cau duyet boi thuong tai nan giao thong");
        requestClaimApprove.setDate(new SimpleDateFormat("yyyy/mm/dd").parse("2021/06/30"));
        requestClaimApprove.setCode_sender("fdsv");
        requestClaimApprove.setDescription("");
        requestClaimApprove.setAmount_main(BigInteger.valueOf(0));
        requestClaimApprove.setStatus("TC");
        requestClaimApprove.setId_contract(19);
        requestClaimApprove.setId_request(75);
        Assertions.assertNotNull(requestService.addClaimReq(requestClaimApprove));
    }

    @Test
    void addClaimReq_UTC05() throws ParseException {
        RequestClaimApprove requestClaimApprove = new RequestClaimApprove();
        requestClaimApprove.setName("Yeu cau duyet boi thuong tai nan giao thong");
        requestClaimApprove.setDate(new SimpleDateFormat("yyyy/mm/dd").parse("2021/06/30"));
        requestClaimApprove.setCode_sender("fdsv");
        requestClaimApprove.setDescription("Dong y chi tra");
        requestClaimApprove.setAmount_main(BigInteger.valueOf(-111111));
        requestClaimApprove.setStatus("TC");
        requestClaimApprove.setId_contract(19);
        requestClaimApprove.setId_request(75);
        Assertions.assertNotNull(requestService.addClaimReq(requestClaimApprove));
    }

    @Test
    void addClaimReq_UTC06() throws ParseException {
        RequestClaimApprove requestClaimApprove = new RequestClaimApprove();
        requestClaimApprove.setName("Yeu cau duyet boi thuong tai nan giao thong");
        requestClaimApprove.setDate(new SimpleDateFormat("yyyy/mm/dd").parse("2021/02/30"));
        requestClaimApprove.setCode_sender("fdsv");
        requestClaimApprove.setDescription("Dong y chi tra");
        requestClaimApprove.setAmount_main(BigInteger.valueOf(-111111));
        requestClaimApprove.setStatus("DD");
        requestClaimApprove.setId_contract(75);
        requestClaimApprove.setId_request(75);
        Assertions.assertNotNull(requestService.addClaimReq(requestClaimApprove));
    }

    @Test
    void addClaimReq_UTC07() throws ParseException {
        RequestClaimApprove requestClaimApprove = new RequestClaimApprove();
        requestClaimApprove.setName("Yeu cau duyet boi thuong tai nan giao thong");
        requestClaimApprove.setDate(new SimpleDateFormat("yyyy/mm/dd").parse("2021/06/30"));
        requestClaimApprove.setCode_sender("CTM2127166");
        requestClaimApprove.setDescription("Dong y chi tra");
        requestClaimApprove.setAmount_main(BigInteger.valueOf(11111111));
        requestClaimApprove.setStatus("DD");
        requestClaimApprove.setId_contract(75);
        requestClaimApprove.setId_request(85);
        Assertions.assertNotNull(requestService.addClaimReq(requestClaimApprove));
    }

    @Test
    void updateSaleDistrict_UTC01() {
        List<String> codes_sale = new ArrayList<>();
        codes_sale.add("cuong");
        DistrictDTO districtDTO = new DistrictDTO();
        districtDTO.setId(3);
        districtDTO.setName("Quận Tây Hồ");
        districtDTO.setType("Quận");
        districtDTO.setId_province(1);
        districtDTO.setCodes_sale(codes_sale);
        Assertions.assertNotNull(contactService.updateSaleDistrict(districtDTO));
    }

    @Test
    void updateSaleDistrict_UTC02() {
        List<String> codes_sale = new ArrayList<>();
        codes_sale.add("cuongnvm34");
        DistrictDTO districtDTO = new DistrictDTO();
        districtDTO.setId(268);
        districtDTO.setName("Quận Hà Đông");
        districtDTO.setType("Quận");
        districtDTO.setId_province(1);
        districtDTO.setCodes_sale(codes_sale);
        Assertions.assertNotNull(contactService.updateSaleDistrict(districtDTO));
    }

    @Test
    void updateSaleDistrict_UTC03() {
        List<String> codes_sale = new ArrayList<>();
        codes_sale.add("cuong");
        codes_sale.add("cuongnvm34");
        DistrictDTO districtDTO = new DistrictDTO();
        districtDTO.setId(3);
        districtDTO.setName("Quận Đống Đa");
        districtDTO.setType("Quận");
        districtDTO.setId_province(1);
        districtDTO.setCodes_sale(codes_sale);
        Assertions.assertNotNull(contactService.updateSaleDistrict(districtDTO));
    }

    @Test
    void addOneNotification_UCT01() throws ParseException{
        Notification noti = new Notification();
        noti.setId_customer(16);
        noti.setTitle("Hợp đồng của quý khách sắp đến hạn nộp tiền");
        noti.setDescription("Quý khách vui lòng đóng tiền đúng hạn theo như hợp đồng");
        noti.setUrl("contract-customerweb");
        noti.setType(2);
        noti.setDate(new SimpleDateFormat("yyyy/mm/dd").parse("2021/07/19"));
        Assertions.assertNotNull(requestService.addOneNotification(noti));
    }

    @Test
    void addOneNotification_UCT02() throws ParseException{
        Notification noti = new Notification();
        noti.setId_customer(157);
        noti.setTitle("Yêu cầu duyệt bồi thường");
        noti.setDescription("Yêu cầu của bạn cần bổ sung thêm giấy tờ liên quan đến sự kiện bảo hiểm");
        noti.setUrl("list-request-customer");
        noti.setType(1);
        noti.setDate(new SimpleDateFormat("yyyy/mm/dd").parse("2021/07/08"));
        Assertions.assertNotNull(requestService.addOneNotification(noti));
    }

    @Test
    void addOneNotification_UCT03() throws ParseException{
        Notification noti = new Notification();
        noti.setId_customer(157);
        noti.setTitle("Chúc mừng sinh nhật");
        noti.setDescription("Chúc quý khách sinh nhật vui vẻ, nhiều sức khỏe và hạnh phúc");
        noti.setUrl("");
        noti.setType(4);
        noti.setDate(new SimpleDateFormat("yyyy/mm/dd").parse("2021/08/03"));
        Assertions.assertNotNull(requestService.addOneNotification(noti));
    }

    @Test
    void addOneNotification_UCT04() throws ParseException{
        Notification noti = new Notification();
        noti.setId_customer(157);
        noti.setTitle("Khuyến mại tháng 8");
        noti.setDescription("Bên bảo hiểm đang có chương trình khuyến mại tháng 8 khi mua hợp đồng tử kỳ");
        noti.setUrl("");
        noti.setType(3);
        noti.setDate(new SimpleDateFormat("yyyy/mm/dd").parse("2021/08/03"));
        Assertions.assertNotNull(requestService.addOneNotification(noti));
    }
}
