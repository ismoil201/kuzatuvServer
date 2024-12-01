package com.example.kuzatuv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // CSRF ni o‘chirish
                .csrf(csrf -> csrf.disable())

                // CORS ni sozlash
                .cors(cors -> cors.configurationSource(request -> new org.springframework.web.cors.CorsConfiguration().applyPermitDefaultValues()))

                // URL'larni autentifikatsiya qilish
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/api/sms/**", "/api/location/**", "/api/browser/**").permitAll()  // Ba'zi endpointlarga ruxsat berish
                        .anyRequest().authenticated()  // Boshqa barcha so'rovlar uchun autentifikatsiya talab etiladi
                )

                // JWT autentifikatsiyasi uchun filter qo‘shish
                .addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
