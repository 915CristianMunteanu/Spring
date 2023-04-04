package com.example.lab2sdi.service;

import com.example.lab2sdi.entity.*;
import com.example.lab2sdi.exceptions.DoctorNotFoundException;
import com.example.lab2sdi.exceptions.HospitalNotFoundException;
import com.example.lab2sdi.exceptions.PatientNotFoundException;
import com.example.lab2sdi.repository.DoctorRepository;
import com.example.lab2sdi.repository.HospitalRepository;
import com.example.lab2sdi.repository.PatientRepository;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DoctorService implements IDoctorService{
    private final DoctorRepository doctorRepository;
    private final HospitalRepository hospitalRepository;
    private final PatientRepository patientRepository;
    public DoctorService(DoctorRepository doctorRepository, HospitalRepository hospitalRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.hospitalRepository = hospitalRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public List<SimpleDoctorDTO> all() {
        return doctorRepository.findAll()
                .stream()
                .map(SimpleDoctorDTO::new)
                .collect(Collectors.toList());
    }
    @Override
    public Doctor newDoctor(Doctor newDoctor,Long id) {
        Optional<Hospital> hospitalOptional = hospitalRepository.findById(id);
        if(hospitalOptional.isPresent()){
            newDoctor.setHospital(hospitalOptional.get());
            return doctorRepository.save(newDoctor);
        }else{
            throw new HospitalNotFoundException(id);
        }
    }
    @Override
    public Doctor one(Long id) {
        return doctorRepository.findById(id).orElseThrow(() -> new DoctorNotFoundException(id));
    }
    @Override
    public Doctor replaceDoctor(Doctor newDoctor,Long id) {
        return doctorRepository.findById(id).map(doctor -> {doctor.setFirstName(newDoctor.getFirstName());
            doctor.setLastName(newDoctor.getLastName());
            doctor.setSpecialization(newDoctor.getSpecialization());
            doctor.setContactNumber(newDoctor.getContactNumber());
            doctor.setSalary(newDoctor.getSalary());
            return doctorRepository.save(doctor);
        }).orElseGet(() -> {newDoctor.setId(id);
            return doctorRepository.save(newDoctor);
        });
    }
    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public List<SimpleDoctorDTO> findDoctorBySalaryGreaterThan(int salary) {
        return doctorRepository.findDoctorBySalaryGreaterThan(salary)
                .stream()
                .map(SimpleDoctorDTO::new)
                .collect(Collectors.toList());
    }
    public List<Pair<Doctor, Integer>> orderDoctorsByNumberOfPatients() {
        List<Pair<Doctor, Integer>> result = new ArrayList<>();
        List<Doctor> doctors = doctorRepository.findAll();
        for (Doctor d: doctors) {
            result.add(Pair.of(d,d.getPatientRelation().size()));

        }
        result.sort(Comparator.comparing(Pair::getSecond));
        Collections.reverse(result);
        return result;
    }

    public Doctor newDoctorWithoutHospitalAssigned(Doctor newDoctor) {
        return doctorRepository.save(newDoctor);
    }
}
