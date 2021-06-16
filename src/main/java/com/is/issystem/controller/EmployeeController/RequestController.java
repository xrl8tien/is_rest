package com.is.issystem.controller.EmployeeController;
import com.is.issystem.entities.Request;
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

    @PostMapping(value = "/get_detail_request")
    public ResponseEntity<?> getdetailRequest(@RequestBody Integer id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(requestService.getDetailRequest(id));
    }

    @PostMapping(value = "/add_one_request")
    public ResponseEntity<?> addOneRequest(@RequestBody Request request){
        return ResponseEntity.status(HttpStatus.OK).body(requestService.addOneReq(request));
    }
}
