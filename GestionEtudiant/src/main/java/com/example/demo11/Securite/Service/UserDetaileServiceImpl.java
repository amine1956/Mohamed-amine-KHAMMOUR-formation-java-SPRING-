package com.example.demo11.Securite.Service;

import com.example.demo11.Securite.Entite.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class UserDetaileServiceImpl implements UserDetailsService {
    private  SecuriteService securiteService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser=securiteService.loadUserBYUsername(username);
       /* Collection<GrantedAuthority>  authorities=new ArrayList();
        appUser.getAppRoles().forEach(role -> {
            SimpleGrantedAuthority authority=new SimpleGrantedAuthority((role.getRole()));
            authorities.add(authority);
        });*/
        Collection<GrantedAuthority> authorities1=
                appUser.getAppRoles()
                        .stream()
                        .map(role->new SimpleGrantedAuthority(role.getRole()))
                        .collect(Collectors.toList());
        User user= new User(appUser.getUsername(),appUser.getPassword(),authorities1);
        return user;
    }
}
