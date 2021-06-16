package com.is.issystem.controller.EmployeeController;

import com.google.api.client.util.Value;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.is.issystem.entities.CustomerAttachment;
import com.is.issystem.service.AttachmentService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Deflater;

@RestController
@RequestMapping(value = "/api/file_management",headers=("content-type=multipart/*"))
public class FileManagementController {

    @Autowired
    private Storage storage;

    @Autowired
    private AttachmentService attachmentService;

    @PostMapping(value = "/upload_file")
    public ResponseEntity uploadFile(@RequestParam("fileData") MultipartFile[] fileData) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(attachmentService.uploadCustomerAttachmentToGCP(fileData,storage));
    }


}
