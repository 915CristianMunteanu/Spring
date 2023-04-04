package com.example.lab2sdi.repository;

import com.example.lab2sdi.entity.DoctorPatient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorPatientRepository extends JpaRepository<DoctorPatient,Long> {
}
