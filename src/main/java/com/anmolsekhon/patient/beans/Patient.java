package com.anmolsekhon.patient.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient implements Serializable {
    @NonNull
    private Long ID;
    private String name;
    private Long systole;
    private Long diastole;
    private Float temperatureInFahrenheit;
    private Boolean hasCovid;
}
