package com.example.lab2sdi.repository;

import com.example.lab2sdi.entity.Hospital;
import com.example.lab2sdi.entity.HospitalDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital,Long> {
}
