package com.anmolsekhon.patient.controllers;

import com.anmolsekhon.patient.beans.Patient;
import com.anmolsekhon.patient.database.DatabaseAccess;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class patientController {

    @Autowired
    public DatabaseAccess da;

    @GetMapping("/")
    public String fetchAll() {

        List<Patient> patientList = da.getAllPatients();
        ObjectMapper mapper = new ObjectMapper();
        String json;
        try {
            json = mapper.writeValueAsString(patientList);
        } catch (Exception e) {
            json = "{}";
            System.out.println(e.toString());
        }

        return json;
    }
}
