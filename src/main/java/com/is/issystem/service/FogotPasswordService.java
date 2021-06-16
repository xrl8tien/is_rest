package com.is.issystem.service;

import com.is.issystem.commons.Constant;
import com.is.issystem.commons.Ultility;
import com.is.issystem.dto.EmployeeInfoDTO;
import com.sendgrid.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@Service
public class FogotPasswordService {
    @Autowired
    public JavaMailSender emailSender;
    @Autowired
    public EmployeeInfoService employeeInfoService;
    public EmployeeInfoDTO sendSimpleEmail(String data) throws MailException, MessagingException {
        JSONObject jsonObject = new JSONObject(data);
        MimeMessage message1 = emailSender.createMimeMessage();

        EmployeeInfoDTO employeeDTO = employeeInfoService.getAllEmployee().stream().
                filter(em -> em.getEmail().equalsIgnoreCase(jsonObject.get("email").toString())).findAny().orElse(null);

        if(employeeDTO != null){
            MimeMessageHelper helper = new MimeMessageHelper(message1);
            helper.setSubject("YÊU CẦU THAY ĐỔI MẬT KHẨU");
            helper.setTo(jsonObject.get("email").toString());

            boolean html = true;
            helper.setText("<h3>Để được cấp lại mật khẩu, quý khách vui lòng đi tới đường dẫn sau để " +
                    "thay đổi mật khẩu: </h3> </br>http://isolution.asia/confirm-change-pass?active_key="+ Ultility.generateTokenKey(employeeDTO.getCode())+
                    Constant.sign, html);


            try{
                this.emailSender.send(message1);
                return employeeDTO;
            } catch (MailException e){
                e.printStackTrace();
            }
        } else {
            return null;
        }


        return new EmployeeInfoDTO();
    }
}
