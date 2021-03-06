package com.is.issystem.service;


import com.is.issystem.commons.Ultility;
import com.is.issystem.dto.ContractDTO;
import com.is.issystem.dto.CustomerDTO;
import com.is.issystem.entities.Contract;
import com.is.issystem.entities.CustomerAcc;
import com.is.issystem.repository.entity_repository.CustomerAccRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CustomerAccService {
    @Autowired
    public JavaMailSender emailSender;
    @Autowired
    private CustomerAccRepository customerAccRepository;
    @Autowired
    private CustomerInfoService customerInfoService;

    static final long EXPIRATIONTIME = 864_000_000; // 10 days
    static final String SECRET = "ThisIsASecret";
    static final String TOKEN_PREFIX = "Bearer";

    
    public List<CustomerAcc> findAll(){
        return customerAccRepository.findAll();
    }

    public void addCustomerAccount(CustomerAcc customerAcc){
        customerAccRepository.save(customerAcc);
    }

    public CustomerAcc sendCustomerAccount(Integer id){
        List<CustomerDTO> customerInfo = customerInfoService.getOneInfo(id);
        Optional<CustomerAcc> customerAcc = customerAccRepository.findById(customerInfo.get(0).getId_account().intValue());
        if(customerAcc.get().isStatus()){
            return customerAcc.get();
        } else {
            customerAcc.get().setStatus(true);
            customerAccRepository.save(customerAcc.get());
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(customerInfo.get(0).getEmail());
            message.setSubject("TH??NG TIN T??I KHO???N KH??CH H??NG");
            message.setText("D?????i ????y l?? t??i kho???n v?? m???t kh???u ????ng nh???p c???a Qu?? Kh??ch:\nM?? ????ng Nh???p: " + customerAcc.get().getCode() + "\n" +
                    "M???t Kh???u ????ng Nh???p: "+customerAcc.get().getPass() + "\nQu?? Kh??ch vui l??ng d??ng th??ng tin tr??n ????? ????ng nh???p t??i kho???n c???a m??nh, c???m ??n qu?? kh??ch ! ");

            try{
                this.emailSender.send(message);
            } catch (MailException e){
                e.printStackTrace();
            }
        }

        return customerAcc.get();
    }

    public CustomerAcc resetAccountPasswordCustomer(CustomerDTO customerDTO){
        Optional<CustomerAcc> customerAcc = customerAccRepository.findById(customerDTO.getId_account().intValue());
        customerAcc.get().setPass(Ultility.generatePassword(8));
        CustomerAcc customerAcc1 = customerAccRepository.save(customerAcc.get());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(customerDTO.getEmail());
        message.setSubject("TH??NG TIN M???T KH???U ????NG NH???P");
        message.setText("QU?? KH??CH ???? Y??U C???U ?????T L???I M???T KH???U,\nD?????i ????y l?? t??i kho???n v?? m???t kh???u ????ng nh???p c???a Qu?? Kh??ch:\nM?? ????ng Nh???p: " + customerAcc1.getCode() + "\n" +
                "M???t Kh???u ????ng Nh???p: "+customerAcc1.getPass() + "\nQu?? Kh??ch vui l??ng d??ng th??ng tin tr??n ????? ????ng nh???p t??i kho???n c???a m??nh, c???m ??n qu?? kh??ch ! ");
        try{
            this.emailSender.send(message);
        } catch (MailException e){
            e.printStackTrace();
        }
        return customerAcc1;
    }

    public Contract notificationEmail(Contract contract){
        List<CustomerDTO> customerInfo = customerInfoService.getOneInfo(contract.getId_customer());
        LocalDate dateTo;
        LocalDate startTime = contract.getStart_time().toLocalDate();
        if (contract.getPayment_period_id() == 1) {
            dateTo = startTime.plusYears(1);
        } else if (contract.getPayment_period_id() == 2) {
            dateTo = startTime.plusMonths(6);
        } else if (contract.getPayment_period_id() == 3) {
            dateTo = startTime.plusMonths(3);
        } else {
            dateTo = startTime.plusMonths(1);
        }
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(customerInfo.get(0).getEmail());
        message.setSubject("TH??NG B??O S???P ?????N H???N ????NG PH?? B???O HI???M");
        message.setText("H???P ?????NG: #HD" + contract.getId() + "-" + contract.getInsurance_type() + " c???a Qu?? Kh??ch: " + customerInfo.get(0).getFull_name() + " s???p ????n h???n thanh to??n.\n" +
                "Qu?? Kh??ch vui l??ng thanh to??n tr?????c ng??y" + dateTo + " ! ");
        try{
            this.emailSender.send(message);
        } catch (MailException e){
            e.printStackTrace();
        }
        return contract;
    }

    public CustomerAcc updateCustomerAccount(CustomerAcc customerAcc){
        Optional<CustomerAcc> acc = customerAccRepository.findById(customerAcc.getId());
        acc.get().setCode(customerAcc.getCode());
        acc.get().setPass(customerAcc.getPass());
        acc.get().setStatus(customerAcc.isStatus());

        return customerAccRepository.save(acc.get());
    }

    public boolean checkExistCustomerAccount(CustomerAcc customerAcc){
        return customerAccRepository.getAccExist(customerAcc.getCode(),customerAcc.getId()).size() > 0 ? true : false;
    }

    public CustomerAcc checkExistCustomerAccountByIdPass(String data[]){
        return customerAccRepository.getAccByIdPass(Integer.parseInt(data[0]),data[1]);
    }

    public String getAccountbyCodePass(CustomerAcc customerAcc){
        String JWToken = null;
        String result = customerAccRepository.getAccByCodePass(customerAcc.getCode(),customerAcc.getPass());
        if(result!=null){
            JWToken = Jwts.builder()
                .setSubject(result)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        }
        return JWToken;
    }
}
