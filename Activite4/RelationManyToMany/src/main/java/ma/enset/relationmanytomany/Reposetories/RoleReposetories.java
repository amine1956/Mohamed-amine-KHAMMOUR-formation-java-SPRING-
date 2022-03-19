package ma.enset.relationmanytomany.Reposetories;

import ma.enset.relationmanytomany.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleReposetories extends JpaRepository<Role,Long>
{
    Role findByRoleName(String UserName);
}
