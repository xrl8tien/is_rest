package com.is.issystem.service;

import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.is.issystem.entities.Attachment;
import com.is.issystem.entities.CustomerAttachment;
import com.is.issystem.repository.entity_repository.AttachmentRepository;
import com.is.issystem.repository.entity_repository.CustomerAttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {
    @Autowired
    CustomerAttachmentRepository customerAttachmentRepository;
    @Autowired
    AttachmentRepository attachmentRepository;

    //luu 1 tài liệu của khách hàng
    public CustomerAttachment saveOneCustomerAttachment(CustomerAttachment customerAttachment){
        try{
            return customerAttachmentRepository.save(customerAttachment);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // lấy tất cả tài liệu của khách hàng theo id hợp đồng
    public List<CustomerAttachment> getCustomerAttachment(Integer id_contract){
        return customerAttachmentRepository.getCustomerAttachemnt(id_contract);
    }

    // lưu tất cả tài liệu của khách hàng
    public List<CustomerAttachment> saveCustomerAttachment(List<CustomerAttachment> customerAttachment){
        return customerAttachmentRepository.saveAll(customerAttachment);
    }

    // Tải tài liệu lên Google Cloud Storage
    public List<String[]> uploadCustomerAttachmentToGCP(MultipartFile[] fileData, Storage storage) throws IOException {
        List<String[]> urlMedia = new ArrayList<>();
        for(MultipartFile file : fileData){
            CustomerAttachment customerAttachment = new CustomerAttachment();
            // lấy id doc để đặt tên cho tài liệu vì gcp không thể lưu các doc có name giống nhau
            Integer idDoc = this.saveOneCustomerAttachment(customerAttachment).getId();
            BlobId blobId = BlobId.of("is-solution.appspot.com", idDoc+"_"+file.getOriginalFilename());
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
            urlMedia.add(new String[]{storage.create(blobInfo, file.getBytes()).getMediaLink(), idDoc.toString()});
        }
        return urlMedia;
    }

    // cập nhật tài liệu trong database
    public List<CustomerAttachment> updateAttachment(List<CustomerAttachment> customerAttachments){
        for(CustomerAttachment customerAttachment : customerAttachments){
            Optional<CustomerAttachment> customerAttachment1 = customerAttachmentRepository.findById(customerAttachment.getId());
            customerAttachment1.get().setId_contract(customerAttachment.getId_contract());
            customerAttachment1.get().setName_document(customerAttachment.getName_document());
            customerAttachment1.get().setUrl(customerAttachment.getUrl());
            customerAttachmentRepository.save(customerAttachment1.get());
        }
        return customerAttachments;
    }

    public List<Attachment> updateAttachmentAll(List<Attachment> attachments){
        for(Attachment attachment : attachments){
            attachmentRepository.save(attachment);
        }
        return attachments;
    }

}
