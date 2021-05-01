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


}
