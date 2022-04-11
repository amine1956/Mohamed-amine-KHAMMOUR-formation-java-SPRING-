package com.example.demo11;

import com.example.demo11.Entite.Etudiant;

import com.example.demo11.Entite.StatueGenre;
import com.example.demo11.Reposetories.EtudiantReposetory;


import com.example.demo11.Securite.Service.SecuriteService;
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
    CommandLineRunner commandLineRunner(EtudiantReposetory etudiantReposetory){
        return args -> {
            etudiantReposetory.save(new Etudiant(null,"Khamour","amine",new Date(),"amineklm983@gmail.com",false, StatueGenre.F)) ;
            etudiantReposetory.save(new Etudiant(null,"Khamour","amine",new Date(),"amineklm983@gmail.com",false, StatueGenre.F)) ;
            etudiantReposetory.save(new Etudiant(null,"Khamour","amine",new Date(),"amineklm983@gmail.com",false, StatueGenre.F)) ;
            etudiantReposetory.save(new Etudiant(null,"Khamour","amine",new Date(),"amineklm983@gmail.com",false, StatueGenre.F)) ;

            etudiantReposetory.findAll().forEach(etudiant -> {
                System.out.println(etudiant.getNom());
            });

        };
}

@Bean
CommandLineRunner SaveUser(SecuriteService securiteService){
        return args -> {
          securiteService.saveNewUser("mohamed","1234","1234");
          securiteService.saveNewUser("yassmin","1234","1234");
          securiteService.saveNewUser("hassan","1234","1234");
          securiteService.savaNewRole("USER","");
          securiteService.savaNewRole("ADMIN","");
          securiteService.addRoleToUser("mohamed","USER");
            securiteService.addRoleToUser("mohamed","Admin");
        };

}

}
