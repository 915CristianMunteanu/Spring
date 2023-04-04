package com.example.lab2sdi.repository;

import com.example.lab2sdi.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
