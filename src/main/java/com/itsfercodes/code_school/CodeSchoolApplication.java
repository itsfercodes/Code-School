package com.itsfercodes.code_school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.itsfercodes.code_school.repository.*")
// @EntityScan("com.itfercodes.code_school.model.*")
public class CodeSchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeSchoolApplication.class, args);
	}

}
