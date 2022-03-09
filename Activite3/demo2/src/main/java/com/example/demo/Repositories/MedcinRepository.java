package com.example.demo.Repositories;

import com.example.demo.entities.Medcin;
import com.example.demo.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface MedcinRepository extends JpaRepository<Medcin,Long> {
        Medcin findByNom(String nom);
}
