package com.is.issystem.controller.EmployeeController;

import com.is.issystem.dto.CustomerDTO;
import com.is.issystem.service.MailService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @PostMapping(value = "/all_mail")
    public ResponseEntity<?> viewAllMailReceived(@RequestBody String userCode){
        return ResponseEntity.status(HttpStatus.OK).body(mailService.getAllMailReceived(userCode));
    }


    @GetMapping(value = "/get_detail_mail/{id}")
    public ResponseEntity<?> getDetailMail(@PathVariable("id") int id){
        return ResponseEntity.status(HttpStatus.OK).body(mailService.getDetailMail(id));
    }


    @PostMapping(value = "/all_mail_sent")
    public ResponseEntity<?> viewAllMailSent(@RequestBody String userCode){
        return ResponseEntity.status(HttpStatus.OK).body(mailService.getAllMailSent(userCode));
    }

    @PostMapping(value = "/search_mail_receive")
    public ResponseEntity<?> searchAllMailReceive(@RequestBody String data){
        JSONObject emailObject = new JSONObject(data);
        return ResponseEntity.status(HttpStatus.OK).body(
                mailService.searchAllMailReceived(emailObject.getString("userCode"),emailObject.getString("dateFrom"),emailObject.getString("dateTo"),emailObject.getString("searchValue")));
    }

    @PostMapping(value = "/search_mail_sent")
    public ResponseEntity<?> searchAllMailSent(@RequestBody String data){
        JSONObject emailObject = new JSONObject(data);
        return ResponseEntity.status(HttpStatus.OK).body(
                mailService.searchAllMailSent(emailObject.getString("userCode"),emailObject.getString("dateFrom"),emailObject.getString("dateTo"),emailObject.getString("searchValue")));
    }


//    @GetMapping("/view_detail_mail/{mailId}/{token_key}")
//    public ResponseEntity<?> viewDetailMail(@PathVariable("mailId") int mailID, @PathVariable("token_key") String token_key){
//        String userCode = Ultility.getCodeInTokenKey(token_key);
//        return ResponseEntity.status(HttpStatus.OK).body(mailService.getDetailMail(userCode, mailID));
//    }

    @PostMapping("/add_mail/")
    public ResponseEntity<?> addNewMail(@RequestBody String data){
        JSONObject jsonObject = new JSONObject(data);
        return ResponseEntity.status(HttpStatus.OK).body(mailService.addNewMail(
                jsonObject.getString("title"),
                jsonObject.getString("senderCode"),
                jsonObject.getString("recieverCode"),
                jsonObject.getString("content"),
                1,
                1));
    }
}
