package com.example.kuzatuv.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");  // Hamma domenlardan so‘rovlar qabul qilinadi
        config.addAllowedMethod("*");  // Barcha HTTP metodlariga ruxsat beriladi
        config.addAllowedHeader("*");  // Barcha so‘rovlar uchun headerlar qabul qilinadi

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);  // Barcha endpointlarga CORSni qo‘llash
        return new CorsFilter(source);
    }
}
