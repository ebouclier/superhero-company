package com.superhero.managemissions.controller;

import java.util.List;
import java.util.List;

import com.superhero.managemissions.model.SuperHero;
import com.superhero.managemissions.repository.SuperHeroRepository;
import com.superhero.managemissions.service.ISuperHeroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@Data
@RestController
public class SuperHeroController {

    @Autowired
    ISuperHeroService superheroservice;

    
    @GetMapping("/superheroes")
    public List<SuperHero> getSuperHeroes(){
        return (List<SuperHero>) superheroservice.findAll();
    }

    @GetMapping("/superheroes/{superheroname}")
    public SuperHero getSuperHero(@PathVariable String superheroname){
        return superheroservice.findbyNameSuperHero(superheroname);

    }

}