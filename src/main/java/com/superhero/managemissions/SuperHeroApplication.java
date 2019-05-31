package com.superhero.managemissions;

import java.util.Arrays;
import java.util.HashSet;

import com.superhero.managemissions.model.Missions;
import com.superhero.managemissions.model.SuperHero;
import com.superhero.managemissions.repository.SuperHeroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SuperHeroApplication implements CommandLineRunner {
	@Autowired
	private SuperHeroRepository superHeroRepository;

	public static void main(String[] args) {
		SpringApplication.run(SuperHeroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Missions mission1 = new Missions("Save The World");
		Missions mission2 = new Missions("Kill Thanos");

		SuperHero superHero1 = new SuperHero("Iron Man", new HashSet<>(Arrays.asList(mission1, mission2)));
		SuperHero superHero2 = new SuperHero("Captain America", new HashSet<>(Arrays.asList(mission2)));
		
		superHeroRepository.saveAll(Arrays.asList(superHero1, superHero2));
	}

}
