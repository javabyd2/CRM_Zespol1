package com.example.crm_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EntityScan(
		basePackageClasses = { CrmSystemApplication.class, Jsr310JpaConverters.class }
)

@SpringBootApplication
public class CrmSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmSystemApplication.class, args);
	}
}
