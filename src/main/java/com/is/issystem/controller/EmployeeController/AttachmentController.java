package com.is.issystem.controller.EmployeeController;

import com.is.issystem.entities.Attachment;
import com.is.issystem.entities.CustomerAttachment;
import com.is.issystem.entities.RequestAttachment;
import com.is.issystem.service.AttachmentService;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/attachment")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;

    @PostMapping(value = "/get_customer_attachment")
    public ResponseEntity<?> getCustomerAttachment(@RequestBody Integer id_contract){
        return ResponseEntity.status(HttpStatus.OK).body(attachmentService.getCustomerAttachment(id_contract));
    }

    @PostMapping(value = "/save_customer_attachment")
    public ResponseEntity<?> saveCustomerAttachment(@RequestBody List<CustomerAttachment> customerAttachments){
        return ResponseEntity.status(HttpStatus.OK).body(attachmentService.updateCustomerAttachment(customerAttachments));
    }

    @PostMapping(value = "/save_attachment")
    public ResponseEntity<?> saveAttachment(@RequestBody List<Attachment> Attachments){
        return ResponseEntity.status(HttpStatus.OK).body(attachmentService.updateAttachmentAll(Attachments));
    }

    @PostMapping(value = "/get_request_attachment")
    public ResponseEntity<?> getRequestAttachment(@RequestBody Integer id_request){
        return ResponseEntity.status(HttpStatus.OK).body(attachmentService.getRequestAttachment(id_request));
    }

    @PostMapping(value = "/save_request_attachment")
    public ResponseEntity<?> saveRequestAttachment(@RequestBody List<RequestAttachment> requestAttachments){
        return ResponseEntity.status(HttpStatus.OK).body(attachmentService.updateRequestAttachment(requestAttachments));
    }

}
