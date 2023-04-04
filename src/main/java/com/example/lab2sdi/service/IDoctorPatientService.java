package com.example.lab2sdi.service;

import com.example.lab2sdi.entity.DoctorPatient;

import java.util.List;
import java.util.Optional;

public interface IDoctorPatientService {
    List<DoctorPatient> all();
    DoctorPatient newDoctorPatient(DoctorPatient newDoctorPatient);
    Optional<DoctorPatient> one(Long id);
    DoctorPatient replaceDoctorPatient(DoctorPatient newDoctorPatient,Long id);
    void deleteDoctorPatient(Long id);
}
