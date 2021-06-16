package com.is.issystem.service;

import com.is.issystem.dto.MailDTO;
import com.is.issystem.entities.Mail;
import com.is.issystem.repository.entity_dto_repository.MailDTORepository;
import com.is.issystem.repository.entity_repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class MailService {

    @Autowired
    private MailRepository mailRepository;
    @Autowired
    private MailDTORepository mailDTORepository;


    public List<MailDTO> getAllMailReceived(String userCode){
        return mailDTORepository.getAllMailReceived(userCode);
    }

    public MailDTO getDetailMail(int id){
        return mailDTORepository.getDetailMail(id);
    }

    public List<MailDTO> getAllMailSent(String userCode){
        return mailDTORepository.getAllMailSent(userCode);
    }

    public List<MailDTO> searchAllMailReceived(String userCode,String dateFrom,String dateTo,String searchValue){
        return mailDTORepository.searchAllMailReceived(userCode,dateFrom,dateTo,searchValue);
    }

    public List<MailDTO> searchAllMailSent(String userCode,String dateFrom,String dateTo,String searchValue){
        return mailDTORepository.searchAllMailSent(userCode,dateFrom,dateTo,searchValue);
    }

//    public MailDTO getDetailMail(String userCode, Integer mailId){
//        return mailRepository.getDetailMail(userCode, mailId);
//    }

    public Integer addNewMail(String title, String senderNameCode, String receiverNameCode,
                           String content, Integer status, Integer priority){
        return mailRepository.addNewMail(title, senderNameCode, receiverNameCode, content, status, priority);
    }
}
