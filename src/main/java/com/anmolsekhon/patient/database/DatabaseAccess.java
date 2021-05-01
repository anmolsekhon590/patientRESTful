package com.anmolsekhon.patient.database;

import com.anmolsekhon.patient.beans.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class DatabaseAccess {
    @Autowired
    protected NamedParameterJdbcTemplate jdbc;

    public List<Patient> getAllPatients() {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "SELECT * From Patient";

        return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Patient>(Patient.class));
    }

    public void addPatient(Patient patient) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "INSERT INTO PATIENT VALUES(NULL, :name, :sys, :dia, :temp, :hasCovid)";
        namedParameters.addValue("name", patient.getName());
        namedParameters.addValue("sys", patient.getSystole());
        namedParameters.addValue("dia", patient.getDiastole());
        namedParameters.addValue("temp", patient.getTemperatureInFahrenheit());
        namedParameters.addValue("hasCovid", patient.getHasCovid());

        jdbc.update(query,namedParameters);
    }


    public void updatePatient(Patient patient) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "UPDATE PATIENT SET name = :name, systole = :sys,diastole = :dia, temperatureInFahrenheit = :temp, hasCovid = :hasCovid WHERE id = :id";
        namedParameters.addValue("id", patient.getID());
        namedParameters.addValue("name", patient.getName());
        namedParameters.addValue("sys", patient.getSystole());
        namedParameters.addValue("dia", patient.getDiastole());
        namedParameters.addValue("temp", patient.getTemperatureInFahrenheit());
        namedParameters.addValue("hasCovid", patient.getHasCovid());

        jdbc.update(query,namedParameters);
    }

    public void deletePatient(Long id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "DELETE FROM Patient WHERE id=:id";

        namedParameters.addValue("id", id);
        jdbc.update(query,namedParameters);
    }
}
