package com.is.issystem.controller.EmployeeController;

import com.is.issystem.entities.Request;
import com.is.issystem.service.ClaimService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = {"/api/claim_request"})
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    //get and add request
    @PostMapping(value = "/get_detail_claim")
    public ResponseEntity<?> getDetailRequest(@RequestBody Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(claimService.getDetailClaim(id));
    }

    @PostMapping(value = "/add_one_claim")
    public ResponseEntity<?> addOneRequest(@RequestBody Request request) {
        return ResponseEntity.status(HttpStatus.OK).body(claimService.addOneClaim(request));
    }

    //claim request
    @PostMapping(value = "/get_all_claim")
    List<Request> getAllClaimRequest() {
        return claimService.getAllUncheckClaim();
    }

    @PostMapping(value = "/search_all_claim")
    List<Request> searchAllClaimRequest(@RequestBody String data) {
        JSONObject requestObject = new JSONObject(data);
        return claimService.searchAllUncheckClaim(requestObject.getString("dateFrom"), requestObject.getString("dateTo"), requestObject.getString("searchValue"));
    }

    @PostMapping(value = "/get_all_claim_approval")
    List<Request> getAllClaimRequestApproval() {
        return claimService.getAllClaimApproval();
    }

    @PostMapping(value = "/search_all_claim_approval")
    List<Request> searchAllClaimRequestApproval(@RequestBody String data) {
        JSONObject requestObject = new JSONObject(data);
        return claimService.searchAllClaimApproval(requestObject.getString("dateFrom"), requestObject.getString("dateTo"), requestObject.getString("searchValue"));
    }

}
