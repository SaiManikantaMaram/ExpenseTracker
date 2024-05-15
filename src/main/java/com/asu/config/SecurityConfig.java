
/*package com.asu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.asu.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        @Autowired
        private CustomUserDetailsService userDetailService;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

                http.cors().and().csrf().disable().authorizeRequests()
                                .requestMatchers("/api/auth/login", "/api/auth/hello").permitAll()
                                .requestMatchers("/api/auth/register").permitAll()
                                .requestMatchers("/api/expense/update/{id}").hasRole("admin")
                                .anyRequest().authenticated()
                                .and().httpBasic();
                return http.build();

        }

        @Bean
        public InMemoryUserDetailsManager inMemoryUserDetails() {
                /*
                 * UserDetails user1 =
                 * User.withDefaultPasswordEncoder().username("admin").password("admin").roles(
                 * "admin")
                 * .build();
                 * 
                 * UserDetails user2 = User.withDefaultPasswordEncoder()
                 * .username("Mani")
                 * .password("mani123")
                 * .roles("USER")
                 * .build();
                 * return new InMemoryUserDetailsManager(user1, user2);
                 
        }

}
*/
package com.asu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.asu.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        @Autowired
        private CustomUserDetailsService customUserDetailsService;

        @Autowired
        private BCryptPasswordEncoder passwordEncoder;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

                http.cors().and().csrf().disable().authorizeRequests()
                                .requestMatchers("/api/auth/hello").permitAll()
                                .requestMatchers("/api/auth/register").permitAll()
                                .anyRequest().authenticated()
                                .and().httpBasic();
                return http.build();

        }

        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
                auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder);
        }

}
