package com.auth.auth_app.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Configuration
    public static class SecurityConfig {

    //    @Bean
    //   public UserDetailsService user(){
    //    User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
    //      UserDetails user = userBuilder
    //              .username("Ayaan")
    //              .password("ayaan")
    //              .roles("ADMIN")
    //              .build();
    //
    //        UserDetails admin = userBuilder
    //                .username("admin")
    //                .password("password")
    //                .roles("USER", "ADMIN")
    //                .build();




    }
}
