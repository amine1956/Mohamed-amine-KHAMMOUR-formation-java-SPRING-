package com.example.demo.Service;

import com.example.demo.Repositories.ConsulationRepository;
import com.example.demo.Repositories.MedcinRepository;
import com.example.demo.Repositories.PatiantRepository;
import com.example.demo.Repositories.RendezVousRepository;
import com.example.demo.entities.Consultation;
import com.example.demo.entities.Medcin;
import com.example.demo.entities.Patient;
import com.example.demo.entities.RendezVous;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class HospitaleServiceImpl implements HospitaleService {
    private PatiantRepository patiantRepository;
    private MedcinRepository medcinRepository;
    private ConsulationRepository consulationRepositor;
    private RendezVousRepository rendezVousRepository;

    public HospitaleServiceImpl(PatiantRepository patiantRepository, MedcinRepository medcinRepository, ConsulationRepository consulationRepositor, RendezVousRepository rendezVousRepository) {
        this.patiantRepository = patiantRepository;
        this.medcinRepository = medcinRepository;
        this.consulationRepositor = consulationRepositor;
        this.rendezVousRepository = rendezVousRepository;
    }

    @Override

    public Patient savePtiant(Patient patient) {
        return patiantRepository.save(patient);
    }

    @Override
    public Medcin saveMedcin(Medcin medcin) {
        return medcinRepository.save(medcin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
       // rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }


    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consulationRepositor.save(consultation);
    }

    @Override
    public Patient recherchparNom(String n) {
        return patiantRepository.findByNom(n);
    }

    @Override
    public Medcin rechercerParnom(String m) {
        return medcinRepository.findByNom(m);
    }

    @Override
    public RendezVous RecherchRDVbyID(Long l) {
        return rendezVousRepository.findById(l).orElse(null);
    }


}
