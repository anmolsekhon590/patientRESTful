package com.anmolsekhon.patient.controllers;

import com.anmolsekhon.patient.beans.Patient;
import com.anmolsekhon.patient.database.DatabaseAccess;
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

        String json  = "{";

        int count = 1;
        for (Patient p: patientList) {
            if (patientList.size() > 1)
                json += "{";

            json += ("\"id\":" + p.getID());
            json += (",\"name\":\"" + p.getName() + "\"");
            json += (",\"systole\":" + p.getSystole());
            json += (",\"diastole\":" + p.getDiastole());
            json += (",\"temp\":" + p.getTemperatureInFahrenheit());
            json += (",\"hasCovid\":" + p.getHasCovid());

            if(patientList.size() > 1) {
                json += "}";
            }
            if (patientList.size() > 1 && count != patientList.size()) {
                json += ",";
            }
            count++;
        }

        json += "}";

        return json;
    }
}
