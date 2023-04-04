package com.example.lab2sdi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorWithIdDTO {
    private Long id;

    private String lastName;

    private String firstName;

    private String specialization;
    private String contactNumber;
    private int salary;
    private Long hospitalId;
    public DoctorWithIdDTO(Doctor doctor){
        id= doctor.getId();
        lastName=doctor.getLastName();
        firstName=doctor.getFirstName();
        specialization= doctor.getSpecialization();
        salary=doctor.getSalary();
        contactNumber= doctor.getContactNumber();
        hospitalId=doctor.getHospital().getId();
    }

}
