package com.example.demo;


import com.example.demo.Repositories.ConsulationRepository;
import com.example.demo.Repositories.MedcinRepository;
import com.example.demo.Repositories.PatiantRepository;
import com.example.demo.Repositories.RendezVousRepository;
import com.example.demo.Service.HospitaleService;
import com.example.demo.entities.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication  {
    public static void main(String[] args)  {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Bean // la methode start execute en premier
    CommandLineRunner Start(HospitaleService hospitaleService){

        return args->{
            Stream.of("amine","khalid","asmaaa").forEach(name->{
                Patient patient=new Patient();
                patient.setNom(name);
                patient.setDateNaissnace(new Date());
                patient.setMalade(true);
                patient.setScore(140);
                hospitaleService.savePtiant(patient);

            });
                Stream.of("amine","khalid","asmaaa").forEach(name->{
                    Medcin medcin=new Medcin();
                    medcin.setNom(name);
                    medcin.setEmail(name+"@gmail.com");
                    medcin.setSpecialete(Math.random()>0.5?"dentiste":"cardio");
                    hospitaleService.saveMedcin(medcin);
                });
                Patient p1=hospitaleService.recherchparNom("amine");
                Medcin m=hospitaleService.rechercerParnom("asmaaa");
                RendezVous r=new RendezVous();
                r.setAnnule(StatueRNDV.PENDING);
                r.setPatient(p1);
                r.setMedcin(m);
                hospitaleService.saveRendezVous(r);
               RendezVous r11=hospitaleService.RecherchRDVbyID(1L);
                Consultation C1=new Consultation();
                C1.setDatecondultation(new Date());
                C1.setRendezVous(r11);
                C1.setRapport("rapport..................");
                hospitaleService.saveConsultation(C1);


        };

    }


}

