package com.example.demo11.Securite.Reposetory;

import com.example.demo11.Securite.Entite.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleReposetory extends JpaRepository<AppRole,Long> {
    AppRole findByRole(String roleName);


}
