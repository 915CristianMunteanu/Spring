package com.example.lab2sdi.service;

import com.example.lab2sdi.entity.Doctor;
import com.example.lab2sdi.entity.DoctorWithIdDTO;
import com.example.lab2sdi.entity.SimpleDoctorDTO;

import java.util.List;

public interface IDoctorService {
    List<SimpleDoctorDTO> all();
    Doctor newDoctor(Doctor newDoctor,Long id);
    Doctor one(Long id);
    Doctor replaceDoctor(Doctor newDoctor,Long id);
    void deleteDoctor(Long id);
    List<SimpleDoctorDTO> findDoctorBySalaryGreaterThan(int salary);
}
