package com.example.lab2sdi.service;

import com.example.lab2sdi.entity.Doctor;
import com.example.lab2sdi.entity.Patient;

import java.util.List;

public interface IPatientService {
    List<Patient> all();
    Patient newPatient(Patient newPatient);
    Patient one(Long id);
    Patient replacePatient(Patient newPatient,Long id);
    void deletePatient(Long id);
}
