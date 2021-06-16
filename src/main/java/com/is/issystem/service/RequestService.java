package com.is.issystem.service;

import com.is.issystem.entities.Request;
import com.is.issystem.repository.entity_repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public List<Request> getAllContractRequestApproval(String code_appraiser) {
        return requestRepository.getAllCheckReq(code_appraiser);
    }
    public List<Request> searchAllContractRequestApproval(String code_appraiser,String dateFrom,String dateTo,String searchValue) {
        return requestRepository.searchAllCheckReq(code_appraiser,dateFrom,dateTo,searchValue);
    }

    public List<Request> getAllUncheckReq(String code_appraiser){
        return requestRepository.getAllUncheckReq(code_appraiser);
    }
    public List<Request> searchAllUncheckReq(String code_appraiser,String dateFrom,String dateTo,String searchValue){
        return requestRepository.searchAllUncheckReq(code_appraiser,dateFrom,dateTo,searchValue);
    }

    public Optional<Request> getDetailRequest(int id){
        return requestRepository.findById(id);
    }

    public Request addOneReq(Request request){
        return requestRepository.save(request);
    }
}
