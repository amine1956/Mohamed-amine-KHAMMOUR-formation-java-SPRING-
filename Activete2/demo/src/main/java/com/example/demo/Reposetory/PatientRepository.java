package com.example.demo.Reposetory;

import com.example.demo.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
public List<Patient>findAllByScoreBetween(int a,int b);
}
