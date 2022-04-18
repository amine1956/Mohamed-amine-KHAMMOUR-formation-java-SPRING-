package com.example.demo11.Securite.Service;

import com.example.demo11.Securite.Entite.AppRole;
import com.example.demo11.Securite.Entite.AppUser;

public interface SecuriteService {
    AppUser saveNewUser(String username ,String password ,String verifyPasswor);
    AppRole savaNewRole(String roleName,String description);
    void addRoleToUser(String  username,String roleName);
    void removeRoleToUser(String  username,String roleName);
    AppUser loadUserBYUsername(String  usrname);


}
