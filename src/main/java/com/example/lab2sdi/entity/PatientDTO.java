package com.example.lab2sdi.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String illness;
    private String phoneNumber;
    private int roomNumber;
    public PatientDTO(Patient patient){
        id= patient.getId();
        firstName= patient.getFirstName();
        lastName= patient.getLastName();
        illness= patient.getIllness();
        phoneNumber= patient.getPhoneNumber();
        roomNumber= patient.getRoomNumber();

    }
}
