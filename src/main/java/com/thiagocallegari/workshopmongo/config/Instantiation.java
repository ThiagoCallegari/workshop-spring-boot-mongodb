package com.thiagocallegari.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.thiagocallegari.workshopmongo.domain.Post;
import com.thiagocallegari.workshopmongo.domain.User;
import com.thiagocallegari.workshopmongo.dto.AuthorDTO;
import com.thiagocallegari.workshopmongo.repository.PostRepository;
import com.thiagocallegari.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User ellis = new User(null, "Ellis Callegari", "ellis@gmail.com");
		User anaBeatriz = new User(null, "Ana Beatriz", "ana@gmail.com");
		User diego = new User(null, "Diego Callegari", "diego@gmail.com");
		
		userRepository.saveAll(Arrays.asList(ellis, anaBeatriz, diego));
	
		Post post1 = new Post(null, new AuthorDTO(anaBeatriz), sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para NY, abraços!");
		Post post2 = new Post(null, new AuthorDTO(anaBeatriz), sdf.parse("23/03/2018"), "Bom dia!", "Tenham um ótimo dia!");
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		anaBeatriz.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(anaBeatriz);
	}
}
