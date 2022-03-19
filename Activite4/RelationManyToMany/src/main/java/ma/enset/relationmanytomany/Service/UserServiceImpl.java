package ma.enset.relationmanytomany.Service;

import lombok.AllArgsConstructor;
import ma.enset.relationmanytomany.Entity.Role;
import ma.enset.relationmanytomany.Entity.User;
import ma.enset.relationmanytomany.Reposetories.RoleReposetories;
import ma.enset.relationmanytomany.Reposetories.UserReposetories;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.transaction.Transactional;
import java.security.Key;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserReposetories userReposetories;
    private RoleReposetories roleReposetories;
    public Key generateKey() throws Exception {
        byte[] keyAsBytes;
        keyAsBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
        Key key = new SecretKeySpec(keyAsBytes, ALGORITHM);
        return key;
    }
    private static final String ALGORITHM       = "AES";
    private static final String myEncryptionKey = "ThisIsFoundation";
    private static final String UNICODE_FORMAT  = "UTF8";

    public String encrypt(String valueToEnc) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encValue = c.doFinal(valueToEnc.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encValue);
        return encryptedValue;
    }

    public String decrypt(String encryptedValue) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedValue);
        byte[] decValue = c.doFinal(decordedValue);//////////LINE 50
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }


    @Override

    public User AddNewUser(User user) throws Exception {
        user.setPassword(encrypt(user.getPassword()));
    user.setUserId(UUID.randomUUID().toString());
        return userReposetories.save(user);
    }

    public Role AddNewRole(Role role) {
        return roleReposetories.save(role);
    }

    @Override
    public User FindUserByUserName(String NameUser) {
        return userReposetories.findByUserName(NameUser);
    }


    @Override
    public Role FindRoleByRoleName(String RoleName) {
        return roleReposetories.findByRoleName(RoleName);
    }

    @Override
    public void AddRoleToUser(String UseName, String RoleName) {

        Role role = FindRoleByRoleName(RoleName);
        User user = FindUserByUserName(UseName);
        user.getRoles().add(role);
        role.getUsers().add(user);

    }

    @Override
    public User authenticate(String username, String password) throws Exception {
        User user=FindUserByUserName(username);
        if(user==null) throw new RuntimeException("user name or password incorect");
        if(decrypt(user.getPassword()).equals(password)){
            return  user;
        }
        throw new RuntimeException("user name or password incorect");
    }
}
