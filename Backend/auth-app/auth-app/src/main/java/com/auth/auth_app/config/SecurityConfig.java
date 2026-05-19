package com.auth.auth_app.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
   public UserDetailsService user(){
    User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
      UserDetails user = userBuilder
              .username("Ayaan")
              .password("ayaan")
              .roles("ADMIN")
              .build();

        UserDetails admin = userBuilder
                .username("admin")
                .password("password")
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

}
