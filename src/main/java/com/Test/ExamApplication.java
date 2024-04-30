package com.Test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


// starting point 

@SpringBootApplication
@ComponentScan("com.Test")
@EntityScan("com.Test.model")
@EnableJpaRepositories("com.Test.repository")
public class ExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamApplication.class, args);
		System.out.println("Exam Okk.. Application Started..");
		}

}
