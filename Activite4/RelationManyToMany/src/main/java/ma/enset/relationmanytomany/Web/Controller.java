package ma.enset.relationmanytomany.Web;

import lombok.AllArgsConstructor;
import ma.enset.relationmanytomany.Entity.User;
import ma.enset.relationmanytomany.Service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@AllArgsConstructor
@RestController
public class Controller {
    private UserService userService;
    @GetMapping("/users/{username}")
    public User user(@PathVariable String username){
        User user=userService.FindUserByUserName(username);
        return  user;
    }

}
