package com.example.demo11.Securite.Service;

import com.example.demo11.Securite.Entite.AppRole;
import com.example.demo11.Securite.Entite.AppUser;
import com.example.demo11.Securite.Reposetory.AppRoleReposetory;
import com.example.demo11.Securite.Reposetory.AppUserReposetory;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Slf4j

@Transactional
public class SecuriteServiceImpl implements SecuriteService {
    @Autowired
    private AppRoleReposetory appRoleReposetory;
    @Autowired
    private AppUserReposetory appUserReposetory;
private PasswordEncoder passwordEncoder;
    @Override
    public AppUser saveNewUser(String username, String password, String verifyPasswor) {
        if(!password.equals(verifyPasswor)) throw new RuntimeException("ERORE PASSWORD");
        String HachPasword=passwordEncoder.encode(password);
        AppUser appUser=new AppUser();
        appUser.setUserId(UUID.randomUUID().toString());
        appUser.setUsername(username);
        appUser.setPassword(HachPasword);
        appUser.setActive(true);
        AppUser savedAppUser=appUserReposetory.save(appUser);
        return savedAppUser;
    }

    @Override
    public AppRole savaNewRole(String roleName, String description) {
        AppRole appRole=appRoleReposetory.findByRole(roleName);
        if (appRole!=null) throw new RuntimeException(roleName+"Allready exist");
        appRole =new AppRole();
        appRole.setRole(roleName);
        appRole.setDescription(description);
       AppRole savedApprole= appRoleReposetory.save(appRole);



        return savedApprole;
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser=appUserReposetory.findByUsername(username);
        if (appUser==null) throw new RuntimeException(username+"not  exist");

        AppRole appRole=appRoleReposetory.findByRole(roleName);
        if (appRole==null) throw new RuntimeException(roleName+"not  exist");

        appUser.getAppRoles().add(appRole);


    }

    @Override
    public void removeRoleToUser(String username, String roleName) {
        AppUser appUser=appUserReposetory.findByUsername(username);
        if (appUser==null) throw new RuntimeException(username+"not  exist");

        AppRole appRole=appRoleReposetory.findByRole(roleName);
        if (appRole==null) throw new RuntimeException(roleName+"not  exist");

        appUser.getAppRoles().remove(appRole);

    }

    @Override
    public AppUser loadUserBYUsername(String usrname) {
        AppUser appUser=new AppUser();
        appUser= appUserReposetory.findByUsername(usrname);
        return appUser;
    }
}
