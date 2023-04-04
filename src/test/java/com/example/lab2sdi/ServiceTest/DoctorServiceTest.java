package com.example.lab2sdi.ServiceTest;

import com.example.lab2sdi.entity.Doctor;
import com.example.lab2sdi.entity.DoctorPatient;
import com.example.lab2sdi.entity.Patient;
import com.example.lab2sdi.repository.DoctorRepository;
import com.example.lab2sdi.service.DoctorService;
import com.example.lab2sdi.entity.SimpleDoctorDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.util.Pair;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DoctorServiceTest {

    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private DoctorService doctorService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testFindDoctorBySalaryGreaterThan() {
        List<Doctor> doctors = Arrays.asList(
                new Doctor("Doe", "Jane", "Cardiology", 55000, "555-1234")
        );

        when(doctorRepository.findDoctorBySalaryGreaterThan(anyInt())).thenReturn(doctors);

        List<SimpleDoctorDTO> result = doctorService.findDoctorBySalaryGreaterThan(50000);

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getId()).isEqualTo(doctors.get(0).getId());
        assertThat(result.get(0).getFirstName()).isEqualTo(doctors.get(0).getFirstName());
        assertThat(result.get(0).getLastName()).isEqualTo(doctors.get(0).getLastName());
        assertThat(result.get(0).getSpecialization()).isEqualTo(doctors.get(0).getSpecialization());
        assertThat(result.get(0).getSalary()).isEqualTo(doctors.get(0).getSalary());
        assertThat(result.get(0).getContactNumber()).isEqualTo(doctors.get(0).getContactNumber());
    }
    @Test
    void testOrderDoctorsByNumberOfPatients() {
        Doctor doctor1 = new Doctor("Doe", "John", "Cardiology", 50000, "555-1234");
        Doctor doctor2 = new Doctor("Doe", "Jane", "Neurology", 55000, "555-5678");

        Patient patient1 = new Patient("Alice", "Smith", "Fever", "123-456", 1);
        Patient patient2 = new Patient("Bob", "Johnson", "Cold", "789-123", 2);
        Patient patient3 = new Patient("Charlie", "Brown", "Flu", "456-789", 3);
        Patient patient4 = new Patient("David", "Miller", "Migraine", "987-654", 4);

        DoctorPatient doctorPatient1 = new DoctorPatient(null, doctor1, patient1, "Med1", "2023-04-01");
        DoctorPatient doctorPatient2 = new DoctorPatient(null, doctor1, patient2, "Med2", "2023-04-02");
        DoctorPatient doctorPatient3 = new DoctorPatient(null, doctor2, patient3, "Med3", "2023-04-03");
        DoctorPatient doctorPatient4 = new DoctorPatient(null, doctor2, patient4, "Med4", "2023-04-04");

        doctor1.setPatientRelation(Arrays.asList(doctorPatient1, doctorPatient2));
        doctor2.setPatientRelation(Arrays.asList(doctorPatient3, doctorPatient4));

        List<Doctor> doctors = Arrays.asList(doctor1, doctor2);

        when(doctorRepository.findAll()).thenReturn(doctors);

        List<Pair<Doctor, Integer>> result = doctorService.orderDoctorsByNumberOfPatients();

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getFirst()).isEqualTo(doctor2);
        assertThat(result.get(0).getSecond()).isEqualTo(2);
        assertThat(result.get(1).getFirst()).isEqualTo(doctor1);
        assertThat(result.get(1).getSecond()).isEqualTo(2);
    }
}
