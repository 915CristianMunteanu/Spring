package com.example.lab2sdi.repository;

import com.example.lab2sdi.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    List<Doctor> findDoctorBySalaryGreaterThan(int salary);
}
