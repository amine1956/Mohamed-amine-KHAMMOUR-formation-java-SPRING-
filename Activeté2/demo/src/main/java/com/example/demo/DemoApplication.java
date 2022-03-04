package com.example.demo;

import com.example.demo.Reposetory.PatientRepository;
import com.example.demo.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
private PatientRepository patientRepository;
    public static void main(String[] args)  {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for(int i=0;i<100;i++){
        patientRepository.save(new Patient(null,"khalid",new Date(),i%2!=0?true:false,(int)(Math.random()*100)));

        patientRepository.save(new Patient(null,"hassana",new Date(),i%2!=0?true:false,(int)(Math.random()*100)));}
        List<Patient> patients=patientRepository.findAll();
        patients.forEach(p->{
            System.out.println("=====================================");
            System.out.println(p.getId());
            System.out.println(p.getDate());
            System.out.println(p.getNom());
            Patient patient=patientRepository.findById(1L).get();
            System.out.println(patient);
             });
        patientRepository.deleteById(1L);
    }
}
