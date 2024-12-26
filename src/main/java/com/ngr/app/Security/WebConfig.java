//package com.ngr.app.Security;
//
//import java.util.List;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**") // Allow all paths
//                .allowedOrigins("http://localhost:3000") // Allow the frontend URL
//                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow methods
//                .allowedHeaders("*") // Allow all headers
//                .allowCredentials(true) // Allow cookies, etc.
//                .maxAge(3600); // Cache preflight responses for 1 hour
//    }
//    
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(new MappingJackson2HttpMessageConverter());
//    }
//}
