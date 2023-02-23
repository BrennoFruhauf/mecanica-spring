package com.brenno.mecanica;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.brenno.mecanica.model.Person;
import com.brenno.mecanica.model.enums.PersonRole;
import com.brenno.mecanica.repository.PersonRepository;

@SpringBootApplication
public class MecanicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MecanicaApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(PersonRepository personRepository) {

		return args -> {
			personRepository.deleteAll();

			Person p = new Person();
			p.setPersonRole(PersonRole.ADMIN);
			p.setName("Brenno Augusto");
			p.setCpf("05898506101");
			p.setEmail("brennofruhauf@outlook.com");
			p.setPhone("64992204846");
			personRepository.save(p);
		};
	}
}
