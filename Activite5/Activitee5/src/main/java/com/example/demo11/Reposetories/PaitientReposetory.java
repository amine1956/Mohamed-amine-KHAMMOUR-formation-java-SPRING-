package com.example.demo11.Reposetories;

import com.example.demo11.Entite.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface   PaitientReposetory extends JpaRepository<Patient,Long> {
    Page<Patient> findByNomContainsAndScoreEquals(String nom,int scor, Pageable pageable);
}
