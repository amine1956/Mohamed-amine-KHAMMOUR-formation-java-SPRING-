package com.example.demo11.Securite;

import com.example.demo11.Securite.Service.UserDetaileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class securiteConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserDetaileServiceImpl userDetaileService2;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetaileService2) ;
        /*
        String encodedPC=passwordEncoder.encode("1234");
        System.out.println(encodedPC);
      auth.inMemoryAuthentication()
              .withUser("user1").password(encodedPC).roles("USER")
              .and()
              .withUser("admin").password(passwordEncoder.encode("1234")).roles("ADMIN","USER");
/*
                 auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username as principal,password as credentials,active from users where username=?")
                .authoritiesByUsernameQuery("select username as principal,role as role from users_roles where username=?")
                .rolePrefix("ROLE_")
                .passwordEncoder(passwordEncoder);



*/
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login").permitAll(); // default login page
        http.csrf().disable();

        http.authorizeRequests().antMatchers("/Admin/**").hasAuthority("ADMIN");
        http.authorizeRequests().antMatchers("/user/**").hasAuthority("USER");
        http.authorizeRequests().antMatchers("/webjars/**", "/js/**", "/css/**", "/images/**","/resources/**", "/static/**", "/css/**").permitAll(); // permit static resources
    http.authorizeRequests().antMatchers("/").permitAll();


        http.exceptionHandling().accessDeniedPage("/403");



    }
    @Bean
    PasswordEncoder passwordEncoder(){
      return new BCryptPasswordEncoder();
    }

}