package com.example.demo.Repositories;

import com.example.demo.entities.Consultation;
import com.example.demo.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsulationRepository extends JpaRepository<Consultation,Long> {
}
