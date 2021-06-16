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
            helper.setSubject("THÔNG TIN MẬT KHẨU ĐĂNG NHẬP");
            helper.setText("QUÝ KHÁCH ĐÃ YÊU CẦU ĐẶT LẠI MẬT KHẨU,<br>Dưới đây là tài khoản và mật khẩu đăng nhập của Quý Khách:<br>Mã Đăng Nhập: " +"<b>"+ employeeAcc1.getCode() +"</b>"+ "<br>" +
                    "Mật Khẩu Đăng Nhập: "+"<b>"+employeeAcc1.getPass() +"</b>"+ " <br>Quý Khách vui lòng dùng thông tin trên để đăng nhập tài khoản của mình, cảm ơn quý khách ! "+ Constant.sign,true);
            try{
                this.emailSender.send(message1);
            } catch (MailException e){
                e.printStackTrace();
            }
            return employeeAcc1;
        }

        public void pauseEmployee(String codeEmployeeNew,Integer id_employee_old,List<String> attachmentURLList) throws MessagingException {
            String codeEmployeeOld =  employeeAccRepository.findById(id_employee_old).get().getCode();
            String email = employeeInfoRepository.getOneEmployeeInfo(id_employee_old).getEmail();

            customerInfoRepository.updateEmployeeSupportCustomerInfo(codeEmployeeNew,codeEmployeeOld);
            contractRepository.updateEmployeeSupportContract(codeEmployeeNew,codeEmployeeOld);

            employeeAccRepository.updateStatusEmployeeAcc(codeEmployeeOld);

            String listURL = "";
            for(String url : attachmentURLList){
                listURL += url+"<br>";
            }

            MimeMessage message1 = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message1);
            helper.setSubject("[THÔNG BÁO TẠM NGƯNG TÀI KHOẢN NHÂN VIÊN]");
            helper.setTo(email);

            boolean html = true;
            helper.setText("Do bạn đã vi phạm một số quy định của công ty <br>" +
                    "vì vậy tài khoản của bạn đã bị <span style = "+"\"color:red\""+">TẠM NGƯNG</span>." +
                    "<br>Mọi thắc mắc xin liên hệ với email sau đây : saler@isolution.asia<br>" +
                    "<br>DƯỚI ĐÂY LÀ CÁC TÀI LIỆU DÙNG CHO VIỆC QUYẾT ĐỊNH TẠM NGƯNG:<br>"+
                    listURL+ Constant.sign, html);
            try{
                this.emailSender.send(message1);
            } catch (MailException e){
                e.printStackTrace();
            }
        }

    public List<PauseReason> updatePauseReason(List<PauseReason> pauseReasons){
        for(PauseReason pauseReason : pauseReasons){
            pauseReasonHistoryRepository.save(pauseReason);
        }
        return pauseReasons;
    }

        public List<EmployeeAcc> findAll() {
            return employeeAccRepository.findAll();
        }

        public EmployeeAcc addEmployeeAccount(EmployeeAcc employee_acc,String email,String code_ap_support,Integer id_custInfo) throws MessagingException {
            // lưu tài khoản của nhân viên
            EmployeeAcc employeeAcc = new EmployeeAcc();
            employeeAcc.setStatus(true);
            employeeAcc.setCode(employee_acc.getCode());
            employeeAcc.setId_role(employee_acc.getId_role());
            employeeAcc.setPass(Ultility.generatePassword(8));
            employeeAccRepository.save(employeeAcc);

            // thêm code của người giám sát cho nhân viên
            Optional<EmployeeInfo> employeeInfo = employeeInfoRepository.findById(id_custInfo);
            employeeInfo.get().setCode_ap_support(code_ap_support);
            employeeInfoRepository.save(employeeInfo.get());

            MimeMessage message1 = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message1);
            helper.setTo(email);
            helper.setSubject("THÔNG TIN TÀI KHOẢN NHÂN VIÊN");
            helper.setText("Bạn vui lòng dùng thông tin bên dưới để đăng nhập vào tài khoản:<br>"
            +"Tài Khoản: "+"<b>"+employee_acc.getCode()+"<b>"+"<br>"
            +"Mật Khẩu: "+"<b>"+employeeAcc.getPass() + Constant.sign,true);

            try{
                this.emailSender.send(message1);
            } catch (MailException e){
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
            return employeeAccRepository.getOneAcc(employee_acc.getCode()) == null ?false:true;
        }

        public List<EmployeeAcc> getAllEmployeeByIdRoleCodeApSpp(Integer id_role, String code_app_support){
            if(code_app_support.isEmpty()){
                return employeeAccRepository.getAllEmaccByIdRole(id_role);
            }
            return employeeAccRepository.getAllEmaccByIdRoleCodeApSpp(id_role,code_app_support);
        }


    }

