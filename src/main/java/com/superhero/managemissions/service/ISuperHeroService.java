package com.superhero.managemissions.service;

import java.util.List;

import com.superhero.managemissions.model.SuperHero;

public interface ISuperHeroService {
    public List<SuperHero> findAll();
    public SuperHero findbyNameSuperHero(String superheroname);
	public void addSuperHero(SuperHero superhero);
	public void updateSuperHero(SuperHero superHero);
	public void deleteSuperHero(SuperHero superhero);
}