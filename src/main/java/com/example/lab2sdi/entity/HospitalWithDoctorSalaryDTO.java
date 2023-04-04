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
public class HospitalWithDoctorSalaryDTO {
    private Long id;
    private String name;

    private String address;

    private String phoneNumber;

    private int numberOfBeds;
    private int highestDoctorSalary;
    public HospitalWithDoctorSalaryDTO(Hospital hospital,int salary){
        id=hospital.getId();
        name=hospital.getName();
        address=hospital.getAddress();
        phoneNumber=hospital.getPhoneNumber();
        numberOfBeds=hospital.getNumberOfBeds();
        highestDoctorSalary=salary;

    }
}
