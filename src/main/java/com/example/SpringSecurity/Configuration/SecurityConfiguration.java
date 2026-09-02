package com.example.SpringSecurity.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity// authorizing that user is doing this process.
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        //1. CSRF DISABLE
        //      ->SAME SITE STRICT
        //      ->SESSION - stateless
        return http.csrf(customizer->customizer.disable())
        //1.
        .authorizeHttpRequests(request-> request.anyRequest().authenticated())
        //http.formLogin(Customizer.withDefaults());
        .httpBasic(Customizer.withDefaults())
        //2.
        .sessionManagement(session->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
       .build();
    }
    @Bean
    public UserDetailsService userDetailsService(){
        List<UserDetails> users = new ArrayList<>();
        UserDetails user1 = User
                .withDefaultPasswordEncoder()
                .username("rohit")
                .password("1357")
                .roles("USER")
                .build();
        UserDetails user2 = User
                .withDefaultPasswordEncoder()
                .username("dhoni")
                .password("0007")
                .roles("USER")
                .build();
        UserDetails user3 = User
                .withDefaultPasswordEncoder()
                .username("kohli")
                .password("1800")
                .roles("USER")
                .build();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        return new InMemoryUserDetailsManager(users);
     //varargs =>   return new InMemoryUserDetailsManager(user1,user2,user3);
    }
}
