package com.example.lab2sdi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorPatientDTO {
    private Long id;
    private String med;
    private String date;
    private Long doctorId;
    private Long patientId;
    public DoctorPatientDTO(DoctorPatient doctorPatient){
        id=doctorPatient.getId();
        med=doctorPatient.getMed();
        date=doctorPatient.getDate();
        doctorId=doctorPatient.getDoctor().getId();
        patientId=doctorPatient.getPatient().getId();
    }
}
