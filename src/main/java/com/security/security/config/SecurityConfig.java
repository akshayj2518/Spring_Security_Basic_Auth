package com.security.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        BASIC-----------------------------------------------------------------------------------------------
//    http://localhost:8080/public/hello should be accessible without authentication.
//    http://localhost:8080/user/hello should prompt for authentication and require user credentials.
//    http://localhost:8080/admin/hello should prompt for authentication and require admin credentials.
//        http.
//                authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/public/**").permitAll() //skip authentication for /public request
//                        .requestMatchers("/admin/**").hasRole("ADMIN") //for admin/ requests user should have ADMIN role
//                        .requestMatchers("/user/**").hasRole("USER")   //for user/ requests user should have USER role
//                        .anyRequest().authenticated())
//                .httpBasic();
//        BASIC-----------------------------------------------------------------------------------------------

//        BASIC AUTHENTICATION FOR LOGIN & LOGOUT
//        ======================================================================================================

        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/login", "/public").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/", true) // redirect to homepage after login
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")                          // default logout endpoint (POST)
                        .logoutSuccessUrl("/login?logout")             // where to redirect after logout
                        .invalidateHttpSession(true)                   // invalidate session
                        .clearAuthentication(true)                     // clear user auth
                        .permitAll()
                );
        return http.build();
//        BASIC AUTHENTICATION FOR LOGIN & LOGOUT
//        =====================================================================================================
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("userpass"))
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("adminpass"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(admin,user);
    }
}
