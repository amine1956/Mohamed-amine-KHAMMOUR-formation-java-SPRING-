package com.example.demo.WEB;

import com.example.demo.Repositories.PatiantRepository;
import com.example.demo.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatiantRepository patiantRepository;
    @GetMapping("/patients")
    public List<Patient> patientliste(){
        return patiantRepository.findAll();
    }
}
