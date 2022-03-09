package com.example.demo.Repositories;

import com.example.demo.entities.Patient;
import com.example.demo.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.xml.crypto.Data;
import java.sql.Date;

public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {

}
