package com.is.issystem.controller.EmployeeController;
import com.is.issystem.entities.Request;
import com.is.issystem.entities.RequestClaimApprove;
import com.is.issystem.service.RequestService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/api/request"})
public class RequestController {
    @Autowired
    private RequestService requestService;

    //contract request
    @PostMapping(value = "/get_all_request")
    List<Request> getAllContractRequest(@RequestBody String code_appraiser){
        return requestService.getAllUncheckReq(code_appraiser);
    }
    @PostMapping(value = "/search_all_request")
    List<Request> searchAllContractRequest(@RequestBody String data){
        JSONObject requestObject = new JSONObject(data);
        return requestService.searchAllUncheckReq(requestObject.getString("code_appraiser"),requestObject.getString("dateFrom"),requestObject.getString("dateTo"),requestObject.getString("searchValue"));
    }

    @PostMapping(value = "/get_all_request_approval")
    List<Request> getAllContractRequestApproval(@RequestBody String code_appraiser){
        return requestService.getAllContractRequestApproval(code_appraiser);
    }

    @PostMapping(value = "/search_all_request_approval")
    List<Request> searchAllContractRequestApproval(@RequestBody String data){
        JSONObject requestObject = new JSONObject(data);
        return requestService.searchAllContractRequestApproval(requestObject.getString("code_appraiser"),requestObject.getString("dateFrom"),requestObject.getString("dateTo"),requestObject.getString("searchValue"));
    }

    //get and add request
    @PostMapping(value = "/get_detail_request")
    public ResponseEntity<?> getDetailRequest(@RequestBody Integer id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(requestService.getDetailRequest(id));
    }

    @PostMapping(value = "/add_one_request")
    public ResponseEntity<?> addOneRequest(@RequestBody Request request){
        return ResponseEntity.status(HttpStatus.OK).body(requestService.addOneReq(request));
    }

    @PostMapping(value = "/add_claim_request")
    public ResponseEntity<?> addClaimRequest(@RequestBody RequestClaimApprove requestClaimApprove){
        return ResponseEntity.status(HttpStatus.OK).body(requestService.addClaimReq(requestClaimApprove));
    }

    @PostMapping(value = "/set_status_request")
    public ResponseEntity<?> setStatusRequest(@RequestBody String data1){
        JSONObject data = new JSONObject(data1);
        requestService.setUpdateRequest(Integer.parseInt(data.get("id_request").toString()),data.get("description").toString(),data.get("approval_status").toString());
        return ResponseEntity.status(HttpStatus.OK).body(data1);
    }

    //claim request
    @PostMapping(value = "/get_all_claim_request")
    List<Request> getAllClaimRequest(@RequestBody String code_appraiser){
        return requestService.getAllUncheckClaimReq(code_appraiser);
    }
    @PostMapping(value = "/search_all_claim_request")
    List<Request> searchAllClaimRequest(@RequestBody String data){
        JSONObject requestObject = new JSONObject(data);
        return requestService.searchAllUncheckClaimReq(requestObject.getString("code_appraiser"),requestObject.getString("dateFrom"),requestObject.getString("dateTo"),requestObject.getString("searchValue"));
    }

    @PostMapping(value = "/get_all_claim_request_approval")
    List<Request> getAllClaimRequestApproval(@RequestBody String code_appraiser){
        return requestService.getAllClaimRequestApproval(code_appraiser);
    }

    @PostMapping(value = "/search_all_claim_request_approval")
    List<Request> searchAllClaimRequestApproval(@RequestBody String data){
        JSONObject requestObject = new JSONObject(data);
        return requestService.searchAllClaimRequestApproval(requestObject.getString("code_appraiser"),requestObject.getString("dateFrom"),requestObject.getString("dateTo"),requestObject.getString("searchValue"));
    }

}
