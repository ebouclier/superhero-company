package com.superhero.managemissions.service;

import java.util.List;
import java.util.Set;

import com.superhero.managemissions.model.SuperHero;

public interface ISuperHeroService {
    public List<SuperHero> findAll();
    public SuperHero findbyNameSuperHero(String superheroname);
}