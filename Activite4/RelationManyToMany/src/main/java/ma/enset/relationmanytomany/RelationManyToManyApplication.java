package ma.enset.relationmanytomany;

import ma.enset.relationmanytomany.Entity.Role;
import ma.enset.relationmanytomany.Entity.User;
import ma.enset.relationmanytomany.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class RelationManyToManyApplication {

    public static void main(String[] args) {
        SpringApplication.run(RelationManyToManyApplication.class, args);
    }
@Bean
    CommandLineRunner Start(UserService userService){
        return args -> {
            User u1=new User();
            u1.setUserName("amine1");
            u1.setPassword("1425");
            userService.AddNewUser(u1);
            User u2=new User();
            u2.setUserName("Ayoub");
            u2.setPassword("1425fff");
            userService.AddNewUser(u2);
            Stream.of("Student","USER","ADMIN").forEach(r->{
                Role role =new Role();
                role.setRoleName(r);
                role.setDescri("my role is"+r);
                userService.AddNewRole(role);

            });
            Role role1=userService.FindRoleByRoleName("Student");
            Role role21 =userService.FindRoleByRoleName(("USER"));
            userService.AddRoleToUser("amine1", role1.getRoleName());
            userService.AddRoleToUser("amine1", role21.getRoleName());
            User user=userService.authenticate("amine1","1425");
            System.out.println("===============================================");
            System.out.println(user.getUserName());
            for (Role role2: user.getRoles()) {
                System.out.println("role=====>"+role2.getRoleName());
            }
            System.out.println("===============================================");

        };
}
}
