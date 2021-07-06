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
        return requestRepository.getAllCheckClaimReq(code_appraiser);
    }

    public List<Request> searchAllClaimRequestApproval(String code_appraiser, String dateFrom, String dateTo, String searchValue) {
        return requestRepository.searchAllCheckClaimReq(code_appraiser, dateFrom, dateTo, searchValue);
    }

    public List<Request> getAllUncheckClaimReq(String code_appraiser) {
        return requestRepository.getAllUncheckClaimReq(code_appraiser);
    }

    public List<Request> searchAllUncheckClaimReq(String code_appraiser, String dateFrom, String dateTo, String searchValue) {
        return requestRepository.searchAllUncheckClaimReq(code_appraiser, dateFrom, dateTo, searchValue);
    }

    public RequestClaimApprove addClaimReq(RequestClaimApprove requestClaimApprove) {
        return requestClaimRepository.save(requestClaimApprove);
    }

    public Notification addOneNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public List<Request> getAllApprovedClaimReq(String code_appraiser) {
        return requestRepository.getAllApprovedClaimReq(code_appraiser);
    }

    public List<Request> searchAllApprovedClaimReq(String code_appraiser, String dateFrom, String dateTo, String searchValue) {
        return requestRepository.searchAllApprovedClaimReq(code_appraiser, dateFrom, dateTo, searchValue);
    }

}
