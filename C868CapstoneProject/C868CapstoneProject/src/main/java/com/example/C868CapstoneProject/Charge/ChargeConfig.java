package com.example.C868CapstoneProject.Charge;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChargeConfig {
	
	@Bean
	CommandLineRunner command(ChargeRepository repository) {
		return args -> {

			Charge charge = new Charge(
							"Overdue", 
							2.10, 
							"Overdue Book.");
				repository.save(charge);
		};
	}
}