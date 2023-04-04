package com.example.lab2sdi.entity;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HospitalDTO {
    private Long id;
    private String name;

    private String address;

    private String phoneNumber;

    private int numberOfBeds;
    //private List<SimpleDoctorDTO> doctors;
    public HospitalDTO(Hospital hospital){
        id=hospital.getId();
        name=hospital.getName();
        address=hospital.getAddress();
        phoneNumber=hospital.getPhoneNumber();
        numberOfBeds=hospital.getNumberOfBeds();
        //doctors = hospital.getDoctors().stream()
           //     .map(SimpleDoctorDTO::new).collect(Collectors.toList());

    }

}
