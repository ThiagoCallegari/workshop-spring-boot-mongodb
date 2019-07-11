package com.thiagocallegari.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.thiagocallegari.workshopmongo.domain.User;
import com.thiagocallegari.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User ellis = new User(null, "Ellis Callegari", "ellis@gmail.com");
		User anaBeatriz = new User(null, "Ana Beatriz", "ana@gmail.com");
		User diego = new User(null, "Diego Callegari", "diego@gmail.com");
	
		userRepository.saveAll(Arrays.asList(ellis, anaBeatriz, diego));
	}
}
