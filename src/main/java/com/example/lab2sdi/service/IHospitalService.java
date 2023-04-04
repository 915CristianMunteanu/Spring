package com.example.lab2sdi.service;

import com.example.lab2sdi.entity.Doctor;
import com.example.lab2sdi.entity.Hospital;
import com.example.lab2sdi.entity.HospitalDTO;
import org.springframework.data.util.Pair;

import java.util.List;

public interface IHospitalService {
    List<HospitalDTO> all();
    Hospital newHospital(Hospital newHospital);
    Hospital one(Long id);
    Hospital replaceHospital(Hospital newHospital,Long id);
    void deleteHospital(Long id);

    List<Pair<Hospital, Doctor>> orderHospitalsByHighestDoctorSalary();
}
