package com.example.lab2sdi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SimpleDoctorDTO {
    private Long id;

    private String lastName;

    private String firstName;

    private String specialization;
    private String contactNumber;
    private int salary;

    public SimpleDoctorDTO(Doctor doctor){
        id= doctor.getId();
        lastName=doctor.getLastName();
        firstName=doctor.getFirstName();
        specialization= doctor.getSpecialization();
        salary=doctor.getSalary();
        contactNumber= doctor.getContactNumber();

    }
    public SimpleDoctorDTO(Long _id,String _lastName,String _firstName,String _specialization,int _salary,String _contactNumber){
        id=_id;
        lastName=_lastName;
        firstName=_firstName;
        specialization=_specialization;
        salary=_salary;
        contactNumber=_contactNumber;
    }
}
