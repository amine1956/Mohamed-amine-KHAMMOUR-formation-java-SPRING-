package com.example.demo11.Reposetories;

import com.example.demo11.Entite.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantReposetory extends JpaRepository<Etudiant,Long> {
    Page<Etudiant> findByNomContains(String nom, Pageable pageable);
}
