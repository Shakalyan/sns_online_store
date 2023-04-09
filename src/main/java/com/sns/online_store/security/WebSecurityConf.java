package com.sns.online_store.security;

import com.sns.online_store.repo.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConf {

    private final EmployeeRepository employeeRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/auth/login/**").permitAll()
                .anyRequest().authenticated()
            .and()
                .formLogin()
                .loginPage("/auth/login")
                .defaultSuccessUrl("/")
                .permitAll()
            .and()
                .logout()
                .logoutUrl("/auth/logout")
                .logoutSuccessUrl("/auth/login?logout")
                .invalidateHttpSession(true);
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl(employeeRepository);
    }

}
