package com.hyupmin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")  // API 경로에 대해
                .allowedOrigins(
                        "http://localhost:3000",  // React 개발 서버
                        "http://localhost:5173",  // Vite 개발 서버
                        "https://your-frontend-domain.com"  // 프론트엔드 배포 도메인 (실제 도메인으로 변경)
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);  // 1시간 동안 preflight 요청 캐시
    }
}
