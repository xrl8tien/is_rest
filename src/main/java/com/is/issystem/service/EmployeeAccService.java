package com.is.issystem.service;


import java.util.List;
import java.util.Optional;

import com.is.issystem.commons.Constant;
import com.is.issystem.commons.Ultility;
import com.is.issystem.dto.CustomerDTO;
import com.is.issystem.dto.EmployeeInfoDTO;
import com.is.issystem.entities.*;
import com.is.issystem.repository.entity_repository.*;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import static com.is.issystem.service.TokenAuthenticationService.SECRET;
import static com.is.issystem.service.TokenAuthenticationService.TOKEN_PREFIX;

@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeeAccService {
    @Autowired
    public JavaMailSender emailSender;
    @Autowired
    private EmployeeAccRepository employeeAccRepository;
    @Autowired
    private EmployeeInfoRepository employeeInfoRepository;
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private CustomerInfoRepository customerInfoRepository;
    @Autowired
    private PauseReasonHistoryRepository pauseReasonHistoryRepository;

    public EmployeeAcc resetAccountPasswordEmployee(EmployeeInfoDTO employeeInfoDTO) throws MessagingException {
        EmployeeAcc employeeAcc = employeeAccRepository.getOneAcc(employeeInfoDTO.getCode());
        employeeAcc.setPass(Ultility.generatePassword(8));
        EmployeeAcc employeeAcc1 = employeeAccRepository.save(employeeAcc);
        MimeMessage message1 = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message1);
        helper.setTo(employeeInfoDTO.getEmail());
        helper.setSubject("TH??NG TIN M???T KH???U ????NG NH???P");
        helper.setText("QU?? KH??CH ???? Y??U C???U ?????T L???I M???T KH???U,<br>D?????i ????y l?? t??i kho???n v?? m???t kh???u ????ng nh???p c???a Qu?? Kh??ch:<br>M?? ????ng Nh???p: " + "<b>" + employeeAcc1.getCode() + "</b>" + "<br>" +
                "M???t Kh???u ????ng Nh???p: " + "<b>" + employeeAcc1.getPass() + "</b>" + " <br>Qu?? Kh??ch vui l??ng d??ng th??ng tin tr??n ????? ????ng nh???p t??i kho???n c???a m??nh, c???m ??n qu?? kh??ch ! " + Constant.sign, true);
        try {
            this.emailSender.send(message1);
        } catch (MailException e) {
            e.printStackTrace();
        }
        return employeeAcc1;
    }

    public void pauseEmployee(String codeEmployeeNew, Integer id_employee_old, List<String> attachmentURLList) throws MessagingException {
        String codeEmployeeOld = employeeAccRepository.findById(id_employee_old).get().getCode();
        String email = employeeInfoRepository.getOneEmployeeInfo(id_employee_old).getEmail();

        customerInfoRepository.updateEmployeeSupportCustomerInfo(codeEmployeeNew, codeEmployeeOld);
        contractRepository.updateEmployeeSupportContract(codeEmployeeNew, codeEmployeeOld);

        employeeAccRepository.updateStatusEmployeeAcc(codeEmployeeOld);

        String listURL = "";
        for (String url : attachmentURLList) {
            listURL += url + "<br>";
        }

        MimeMessage message1 = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message1);
        helper.setSubject("[TH??NG B??O T???M NG??NG T??I KHO???N NH??N VI??N]");
        helper.setTo(email);

        boolean html = true;
        helper.setText("Do b???n ???? vi ph???m m???t s??? quy ?????nh c???a c??ng ty <br>" +
                "v?? v???y t??i kho???n c???a b???n ???? b??? <span style = " + "\"color:red\"" + ">T???M NG??NG</span>." +
                "<br>M???i th???c m???c xin li??n h??? v???i email sau ????y : saler@isolution.asia<br>" +
                "<br>D?????I ????Y L?? C??C T??I LI???U D??NG CHO VI???C QUY???T ?????NH T???M NG??NG:<br>" +
                listURL + Constant.sign, html);
        try {
            this.emailSender.send(message1);
        } catch (MailException e) {
            e.printStackTrace();
        }
    }

    public List<PauseReason> updatePauseReason(List<PauseReason> pauseReasons) {
        for (PauseReason pauseReason : pauseReasons) {
            pauseReasonHistoryRepository.save(pauseReason);
        }
        return pauseReasons;
    }

    public List<EmployeeAcc> findAll() {
        return employeeAccRepository.findAll();
    }

    public EmployeeAcc addEmployeeAccount(EmployeeAcc employee_acc, String email, String code_ap_support, Integer id_custInfo) throws MessagingException {
        // l??u t??i kho???n c???a nh??n vi??n
        EmployeeAcc employeeAcc = new EmployeeAcc();
        employeeAcc.setStatus(true);
        employeeAcc.setCode(employee_acc.getCode());
        employeeAcc.setId_role(employee_acc.getId_role());
        employeeAcc.setPass(Ultility.generatePassword(8));
        employeeAccRepository.save(employeeAcc);

        // th??m code c???a ng?????i gi??m s??t cho nh??n vi??n
        Optional<EmployeeInfo> employeeInfo = employeeInfoRepository.findById(id_custInfo);
        employeeInfo.get().setCode_ap_support(code_ap_support);
        employeeInfoRepository.save(employeeInfo.get());

        MimeMessage message1 = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message1);
        helper.setTo(email);
        helper.setSubject("TH??NG TIN T??I KHO???N NH??N VI??N");
        helper.setText("B???n vui l??ng d??ng th??ng tin b??n d?????i ????? ????ng nh???p v??o t??i kho???n:<br>"
                + "T??i Kho???n: " + "<b>" + employee_acc.getCode() + "<b>" + "<br>"
                + "M???t Kh???u: " + "<b>" + employeeAcc.getPass() + Constant.sign, true);

        try {
            this.emailSender.send(message1);
        } catch (MailException e) {
            e.printStackTrace();
        }
        return employeeAcc;
    }


    public Optional<EmployeeAcc> findEmployeeAccountByID(Integer id) {
        return employeeAccRepository.findById(id);
    }

    public EmployeeAcc findEmployeeAccountByCode(String token_id) {
        if (token_id != null) {
            String user = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token_id.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();
            return employeeAccRepository.getOneAcc(user);
        }
        return null;
    }

    public EmployeeAcc updateEmployeeAccountByCode(EmployeeAcc employee_acc) {
        EmployeeAcc existEmployeeAcc = employeeAccRepository.getOneAcc(employee_acc.getCode());
        existEmployeeAcc.setCode(employee_acc.getCode());
        existEmployeeAcc.setPass(employee_acc.getPass());
        existEmployeeAcc.setStatus(employee_acc.isStatus());
        return employeeAccRepository.save(existEmployeeAcc);
    }

    public EmployeeAcc updateEmployeeAccountById(EmployeeAcc employee_acc) {
        Optional<EmployeeAcc> existEmployeeAcc = employeeAccRepository.findById(employee_acc.getId());
        existEmployeeAcc.get().setCode(employee_acc.getCode());
        existEmployeeAcc.get().setPass(employee_acc.getPass());
        existEmployeeAcc.get().setStatus(employee_acc.isStatus());
        return employeeAccRepository.save(existEmployeeAcc.get());
    }

    public boolean checkExistEmployeeAccount(EmployeeAcc employee_acc) {
        return employeeAccRepository.getOneAcc(employee_acc.getCode()) == null ? false : true;
    }

    public List<EmployeeAcc> getAllEmployeeByIdRoleCodeApSpp(Integer id_role, String code_app_support) {
        if (code_app_support.isEmpty()) {
            return employeeAccRepository.getAllEmaccByIdRole(id_role);
        }
        return employeeAccRepository.getAllEmaccByIdRoleCodeApSpp(id_role, code_app_support);
    }


}

