package com.magnumopus.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserManagementApplication.class, args);
    }

    // configuring CORS support
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedMethods("*")
//                        .allowedHeaders("*")
//                        .allowedOrigins("http://localhost:8080");
//            }
//        };
//    }

}


//String SERVER_PORT = "8080";
//SpringApplication app = new SpringApplication(UserManagementApplication.class);
//
//if (System.getenv("SERVER_PORT") != null) {
//SERVER_PORT = System.getenv("SERVER_PORT");
//}
//
//app.setDefaultProperties(Collections.singletonMap("server.port", SERVER_PORT));
//app.run(args);
//
//SpringApplication.run(UserManagementApplication.class, args);