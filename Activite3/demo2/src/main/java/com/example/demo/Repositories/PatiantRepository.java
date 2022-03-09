package com.example.demo.Repositories;

import com.example.demo.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatiantRepository extends JpaRepository<Patient,Long> {
    Patient findByNom(String a);
}
