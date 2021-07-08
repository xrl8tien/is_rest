package com.is.issystem.service;

import com.is.issystem.entities.*;
import com.is.issystem.repository.entity_repository.NotificationRepository;
import com.is.issystem.repository.entity_repository.RequestClaimRepository;
import com.is.issystem.repository.entity_repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private RequestClaimRepository requestClaimRepository;
    @Autowired
    private NotificationRepository notificationRepository;



    //contract request
    public List<Request> getAllContractRequestApproval(String code_appraiser) {
        return requestRepository.getAllCheckReq(code_appraiser);
    }

    public List<Request> searchAllContractRequestApproval(String code_appraiser, String dateFrom, String dateTo, String searchValue) {
        return requestRepository.searchAllCheckReq(code_appraiser, dateFrom, dateTo, searchValue);
    }

    public List<Request> getAllUncheckReq(String code_appraiser) {
        return requestRepository.getAllUncheckReq(code_appraiser);
    }

    public List<Request> searchAllUncheckReq(String code_appraiser, String dateFrom, String dateTo, String searchValue) {
        return requestRepository.searchAllUncheckReq(code_appraiser, dateFrom, dateTo, searchValue);
    }

    //add and get request
    public Optional<Request> getDetailRequest(int id) {
        return requestRepository.findById(id);
    }

    public Request addOneReq(Request request) {
        Request req = requestRepository.save(request);
        requestRepository.flush();
        return req;
    }

    public void setUpdateRequest(Integer id_request, String description, String approval_status) {
        Optional<Request> request = requestRepository.findById(id_request);
        request.get().setStatus(approval_status);
        request.get().setDescription(description);
        request.get().setStatus(approval_status);
        requestRepository.save(request.get());
    }


    //claim request
    public List<Request> getAllClaimRequestApproval(String code_appraiser) {
        return requestRepository.getAllCheckClaimReq();
    }

    public List<Request> searchAllClaimRequestApproval(String code_appraiser, String dateFrom, String dateTo, String searchValue) {
        return requestRepository.searchAllCheckClaimReq(dateFrom, dateTo, searchValue);
    }

    public List<Request> getAllUncheckClaimReq() {
        return requestRepository.getAllUncheckClaimReq();
    }

    public List<Request> searchAllUncheckClaimReq(String code_appraiser, String dateFrom, String dateTo, String searchValue) {
        return requestRepository.searchAllUncheckClaimReq(dateFrom, dateTo, searchValue);
    }

    public RequestClaimApprove addClaimReq(RequestClaimApprove requestClaimApprove) {
        return requestClaimRepository.save(requestClaimApprove);
    }

    public List<Request> getAllApprovedClaimReq(String code_appraiser) {
        return requestRepository.getAllApprovedClaimReq();
    }

    public List<Request> searchAllApprovedClaimReq(String code_appraiser, String dateFrom, String dateTo, String searchValue) {
        return requestRepository.searchAllApprovedClaimReq(dateFrom, dateTo, searchValue);
    }

    //customer request
    public List<Request> getAllCustomerRequest(String code_sender) {
        return requestRepository.getAllCustomerClaimReq(code_sender);
    }

    public List<Request> searchAllCustomerRequest(String code_sender, String dateFrom, String dateTo, String searchValue) {
        return requestRepository.searchAllCustomerClaimReq(code_sender, dateFrom, dateTo, searchValue);
    }

    //notification
    public Notification addOneNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public List<Notification> getAllNotificationByIdCustomer(Integer id_customer) {
        return notificationRepository.getAllNotificationByIdCustomer(id_customer);
    }

}
