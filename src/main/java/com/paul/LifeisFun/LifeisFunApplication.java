package com.paul.LifeisFun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class LifeisFunApplication {
 
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(LifeisFunApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(LifeisFunApplication.class, args);
	}
}
