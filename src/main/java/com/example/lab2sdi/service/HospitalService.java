package com.example.lab2sdi.service;

import org.springframework.data.util.Pair;
import com.example.lab2sdi.entity.Doctor;
import com.example.lab2sdi.entity.Hospital;
import com.example.lab2sdi.entity.HospitalDTO;
import com.example.lab2sdi.exceptions.HospitalNotFoundException;
import com.example.lab2sdi.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HospitalService implements IHospitalService {
    private final HospitalRepository repository;

    public HospitalService(HospitalRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<HospitalDTO> all() {
        return repository.findAll().stream().map(HospitalDTO::new).collect(Collectors.toList());

    }

    @Override
    public Hospital newHospital(Hospital newHospital) {
        return repository.save(newHospital);
    }

    @Override
    public Hospital one(Long id) {
        return repository.findById(id).orElseThrow(() -> new HospitalNotFoundException(id));
    }

    @Override
    public Hospital replaceHospital(Hospital newHospital, Long id) {
        return repository.findById(id).map(hospital -> {
            hospital.setName(newHospital.getName());
            hospital.setAddress(newHospital.getAddress());
            hospital.setPhoneNumber(newHospital.getPhoneNumber());
            hospital.setNumberOfBeds(newHospital.getNumberOfBeds());
            return repository.save(hospital);
        }).orElseGet(() -> {
            newHospital.setId(id);
            return repository.save(newHospital);
        });
    }

    @Override
    public void deleteHospital(Long id) {
        repository.deleteById(id);
    }

    public List<Pair<Hospital, Doctor>> orderHospitalsByHighestDoctorSalary() {
        List<Pair<Hospital, Doctor>> result = new ArrayList<>();
        List<Hospital> hospitals = repository.findAll();
        hospitals.forEach(hospital -> hospital.getDoctors().stream().max(Comparator.comparingInt(Doctor::getSalary))
                .ifPresent(doctor -> result.add(Pair.of(hospital,doctor))));
        result.sort(Comparator.comparing(h->h.getSecond().getSalary()));
        return result;
    }
}
