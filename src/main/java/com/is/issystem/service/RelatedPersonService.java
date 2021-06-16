package com.is.issystem.service;

import com.is.issystem.entities.RelatedPerson;
import com.is.issystem.repository.entity_repository.RelatedPersonRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class RelatedPersonService {
    @Autowired
    RelatedPersonRepository relatedPersonRepository;

    public RelatedPerson addRelatedPerson(JSONObject relatedPerson) throws ParseException {
        RelatedPerson relatePer = new RelatedPerson();
        relatePer.setName(relatedPerson.getString("full_name"));
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(relatedPerson.getString("date_of_birth"));
        relatePer.setDate_of_birth(date);
        relatePer.setGender(relatedPerson.getBoolean("gender"));
        relatePer.setCarreer_group(relatedPerson.getInt("carreer_group"));
        relatePer.setRelation(relatedPerson.getString("relation"));
        relatePer.setId_illustration(relatedPerson.getInt("id_illustration"));
        relatePer.setAddress("");
        relatePer.setPhone("");
        relatePer.setID_card("");
        relatePer.setJob("");
        return relatedPersonRepository.save(relatePer);
    }
}
