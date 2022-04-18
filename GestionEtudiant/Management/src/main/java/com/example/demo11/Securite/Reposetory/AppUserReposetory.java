package com.example.demo11.Securite.Reposetory;

import com.example.demo11.Securite.Entite.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserReposetory extends JpaRepository<AppUser,String> {
    AppUser findByUsername(String username);


}
