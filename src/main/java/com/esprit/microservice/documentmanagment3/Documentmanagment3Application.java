package com.esprit.microservice.documentmanagment3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.util.RouteMatcher;

@EnableDiscoveryClient
@SpringBootApplication
public class Documentmanagment3Application {

    public static void main(String[] args) {
        SpringApplication.run(Documentmanagment3Application.class, args);
    }

}
