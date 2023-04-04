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
public class HospitalDTOWithAllData {
    private Long id;
    private String name;

    private String address;

    private String phoneNumber;

    private int numberOfBeds;
    private List<DoctorWithIdDTO> doctors;
    public HospitalDTOWithAllData(Hospital hospital){
        id=hospital.getId();
        name=hospital.getName();
        address=hospital.getAddress();
        phoneNumber=hospital.getPhoneNumber();
        numberOfBeds=hospital.getNumberOfBeds();
        doctors = hospital.getDoctors().stream()
             .map(DoctorWithIdDTO::new).collect(Collectors.toList());

    }
}
