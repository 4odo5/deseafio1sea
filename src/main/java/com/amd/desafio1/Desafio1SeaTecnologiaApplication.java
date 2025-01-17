package com.amd.desafio1;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Desafio1SeaTecnologiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Desafio1SeaTecnologiaApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
