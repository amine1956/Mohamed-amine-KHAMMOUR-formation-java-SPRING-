package com.example.demo.Service;

import com.example.demo.entities.Consultation;
import com.example.demo.entities.Medcin;
import com.example.demo.entities.Patient;
import com.example.demo.entities.RendezVous;

import java.util.Optional;

public interface HospitaleService {
    Patient savePtiant(Patient patient);
    Medcin saveMedcin(Medcin medcin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
    Patient recherchparNom(String n);
    Medcin rechercerParnom(String m);
    RendezVous RecherchRDVbyID(Long l);





}
