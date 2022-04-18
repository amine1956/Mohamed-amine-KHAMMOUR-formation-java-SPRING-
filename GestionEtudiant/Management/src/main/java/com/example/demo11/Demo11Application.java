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
            etudiantReposetory.save(new Etudiant(null,"amine","khammour",new Date(),false, StatueGenre.F)) ;
            etudiantReposetory.save(new Etudiant(null,"khalid","prenom",new Date(),true,StatueGenre.F)) ;
            etudiantReposetory.save(new Etudiant(null,"hatim","prenom",new Date(),false,StatueGenre.M)) ;
            etudiantReposetory.save(new Etudiant(null,"rafik","prenom",new Date(),true,StatueGenre.M)) ;

            etudiantReposetory.findAll().forEach(etudiant -> {
                System.out.println(etudiant.getNom());
            });

        };
}
//@Bean
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
