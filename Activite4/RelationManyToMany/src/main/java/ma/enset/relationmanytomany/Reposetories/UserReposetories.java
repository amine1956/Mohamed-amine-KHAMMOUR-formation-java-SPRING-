package ma.enset.relationmanytomany.Reposetories;

import ma.enset.relationmanytomany.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReposetories extends JpaRepository<User,String> {
    User findByUserName(String username);

}
