package com.example.lab2sdi.entity;

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
public class DoctorWithAllDataDTO {
    private Long id;

    private String lastName;

    private String firstName;

    private String specialization;
    private String contactNumber;
    private int salary;
    private HospitalDTO hospitalId;
    private List<PatientDTO> patient;
    public DoctorWithAllDataDTO(Doctor doctor){
        id= doctor.getId();
        lastName=doctor.getLastName();
        firstName=doctor.getFirstName();
        specialization= doctor.getSpecialization();
        salary=doctor.getSalary();
        contactNumber= doctor.getContactNumber();
        hospitalId= new HospitalDTO(doctor.getHospital());
        patient=doctor.getPatientRelation().stream().map(DoctorPatient::getPatient).map(PatientDTO::new).collect(Collectors.toList());
    }
}
