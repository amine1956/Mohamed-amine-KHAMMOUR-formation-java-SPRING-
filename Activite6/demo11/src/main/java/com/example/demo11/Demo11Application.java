package com.example.demo11;

import com.example.demo11.Entite.Patient;
import com.example.demo11.Reposetories.PaitientReposetory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Demo11Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo11Application.class, args);
    }
//@Bean
    CommandLineRunner commandLineRunner(PaitientReposetory paitientReposetory){
        return args -> {
            paitientReposetory.save(new Patient(null,"amine",new Date(),false,140)) ;
            paitientReposetory.save(new Patient(null,"khalid",new Date(),true,90)) ;
            paitientReposetory.save(new Patient(null,"hatim",new Date(),false,50)) ;
            paitientReposetory.save(new Patient(null,"rafik",new Date(),true,410)) ;

            paitientReposetory.findAll().forEach(patient -> {
                System.out.println(patient.getNom());
            });

        };
}


}
