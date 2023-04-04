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
public class DoctorWithAllDataButNoPatientDTO {
    private Long id;

    private String lastName;

    private String firstName;

    private String specialization;
    private String contactNumber;
    private int salary;

    public DoctorWithAllDataButNoPatientDTO(Doctor doctor){
        id= doctor.getId();
        lastName=doctor.getLastName();
        firstName=doctor.getFirstName();
        specialization= doctor.getSpecialization();
        salary=doctor.getSalary();
        contactNumber= doctor.getContactNumber();


    }
}
