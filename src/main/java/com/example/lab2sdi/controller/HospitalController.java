package com.example.lab2sdi.controller;

import com.example.lab2sdi.entity.*;
import com.example.lab2sdi.service.IHospitalService;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/hospitals")
public class HospitalController {
    private final IHospitalService service;

    public HospitalController(IHospitalService service) {
        this.service = service;

    }
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping
    List<HospitalDTO> all(){
        return service.all();
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/filter")
    List<HospitalWithDoctorSalaryDTO> orderHospitalsByLowestDoctorSalary(){
        List<Pair<Hospital, Doctor>> result=service.orderHospitalsByHighestDoctorSalary();
        List<HospitalWithDoctorSalaryDTO> toReturn=new ArrayList<>();
        for (Pair<Hospital, Doctor> res:result) {
            toReturn.add(new HospitalWithDoctorSalaryDTO(res.getFirst(), res.getSecond().getSalary()));
        }
        return toReturn;
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping
    Hospital newHospital(@RequestBody Hospital newHospital){
        return service.newHospital(newHospital);
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/{id}")
    HospitalDTOWithAllData one(@PathVariable Long id){
        Hospital h= service.one(id);
        return new HospitalDTOWithAllData(h);

    }
    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping("/{id}")
   Hospital replaceHospital(@RequestBody Hospital newHospital,@PathVariable Long id){
        return service.replaceHospital(newHospital,id);
   }
    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping("/{id}")
    void deleteHospital(@PathVariable Long id){
        service.deleteHospital(id);
   }
}
