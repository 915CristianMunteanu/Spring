package com.example.lab2sdi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientWithDoctorDataDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String illness;
    private String phoneNumber;
    private int roomNumber;
    private List<DoctorWithAllDataButNoPatientDTO> doctors;
    public PatientWithDoctorDataDTO(Patient patient){
        id= patient.getId();
        firstName= patient.getFirstName();
        lastName= patient.getLastName();
        illness= patient.getIllness();
        phoneNumber= patient.getPhoneNumber();
        roomNumber= patient.getRoomNumber();
        doctors=patient.getDoctorRelation().stream().map(DoctorPatient::getDoctor).map(DoctorWithAllDataButNoPatientDTO::new).collect(Collectors.toList());

    }
}
