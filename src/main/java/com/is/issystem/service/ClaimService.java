package com.is.issystem.service;

import com.is.issystem.entities.Request;
import com.is.issystem.repository.entity_repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    //add and get request
    public Optional<Request> getDetailClaim(int id) {
        return claimRepository.findById(id);
    }

    public Request addOneClaim(Request request) {
        return claimRepository.save(request);
    }

    //claim request
    public List<Request> getAllClaimApproval() {
        return claimRepository.getAllCheckClaim();
    }

    public List<Request> searchAllClaimApproval(String dateFrom, String dateTo, String searchValue) {
        return claimRepository.searchAllCheckClaim(dateFrom, dateTo, searchValue);
    }

    public List<Request> getAllUncheckClaim() {
        return claimRepository.getAllUncheckClaim();
    }

    public List<Request> searchAllUncheckClaim(String dateFrom, String dateTo, String searchValue) {
        return claimRepository.searchAllUncheckClaim(dateFrom, dateTo, searchValue);
    }

}
