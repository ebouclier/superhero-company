package com.superhero.managemissions.service;

import java.util.List;

import com.superhero.managemissions.model.SuperHero;
import com.superhero.managemissions.repository.SuperHeroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuperHeroService implements ISuperHeroService {

    @Autowired
    SuperHeroRepository superherorepository;

    @Override
    public List<SuperHero> findAll() {
        return (List<SuperHero>) superherorepository.findAll();
    }

    @Override
    public SuperHero findbyNameSuperHero(String superheroname) {
        return null;
    }

}