package ma.enset.relationmanytomany.Service;

import ma.enset.relationmanytomany.Entity.Role;
import ma.enset.relationmanytomany.Entity.User;

import java.security.Key;
import java.security.SecureRandom;

public interface UserService {
    User AddNewUser(User user) throws Exception;
    Role AddNewRole(Role role);
    User FindUserByUserName(String NameUser);
    Role FindRoleByRoleName(String NameRole);
    void AddRoleToUser(String UseName,String RoleName);
    User authenticate(String username, String password) throws Exception;
     Key generateKey() throws Exception;
    String decrypt(String encryptedValue) throws Exception;
   String  encrypt(String valueToEnc) throws Exception;
}
