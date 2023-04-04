package com.example.lab2sdi.service;

import com.example.lab2sdi.entity.Doctor;
import com.example.lab2sdi.entity.DoctorPatient;
import com.example.lab2sdi.entity.Patient;
import com.example.lab2sdi.exceptions.DoctorNotFoundException;
import com.example.lab2sdi.exceptions.PatientNotFoundException;
import com.example.lab2sdi.repository.DoctorPatientRepository;
import com.example.lab2sdi.repository.DoctorRepository;
import com.example.lab2sdi.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DoctorPatientService implements IDoctorPatientService{
    private DoctorPatientRepository doctorPatientRepository;
    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;

    public DoctorPatientService(DoctorPatientRepository doctorPatientRepository, DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.doctorPatientRepository = doctorPatientRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public List<DoctorPatient> all() {
        return doctorPatientRepository.findAll();
    }

    @Override
    public DoctorPatient newDoctorPatient(DoctorPatient newDoctorPatient) {
        return doctorPatientRepository.save(newDoctorPatient);
    }

    @Override
    public Optional<DoctorPatient> one(Long id) {
        return doctorPatientRepository.findById(id);
    }

    @Override
    public DoctorPatient replaceDoctorPatient(DoctorPatient newDoctorPatient, Long id) {
        return null;
    }

    @Override
    public void deleteDoctorPatient(Long id) {

    }
    public void addRelationship(DoctorPatient newDoctorPatient,Long doctorId, Long patientId){
        Optional<Doctor> d=this.doctorRepository.findById(doctorId);
        Optional<Patient> p=this.patientRepository.findById(patientId);
        if(d.isPresent()) {
            if (p.isPresent()) {
                newDoctorPatient.setDoctor(d.get());
                newDoctorPatient.setPatient(p.get());
                doctorPatientRepository.save(newDoctorPatient);
            }
            else throw new PatientNotFoundException(patientId);
        }
        else throw new DoctorNotFoundException(doctorId);
    }
}
