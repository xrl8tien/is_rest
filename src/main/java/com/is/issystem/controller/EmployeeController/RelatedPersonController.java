package com.is.issystem.controller.EmployeeController;

import com.is.issystem.entities.RelatedPerson;
import com.is.issystem.service.RelatedPersonService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping(value = "/api/related_person")
public class RelatedPersonController {

    @Autowired
    RelatedPersonService relatedPersonService;

    @PostMapping(value = "/add_related_person")
    public ResponseEntity addRelatedPerson(@RequestBody String relatedPerson) throws ParseException {
        return ResponseEntity.status(HttpStatus.OK).body(relatedPersonService.addRelatedPerson(new JSONObject(relatedPerson)).getId());
    }
}
