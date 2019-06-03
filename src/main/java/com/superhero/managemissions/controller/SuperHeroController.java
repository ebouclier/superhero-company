package com.superhero.managemissions.controller;

import java.util.List;

import com.superhero.managemissions.model.SuperHero;
import com.superhero.managemissions.service.ISuperHeroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

@Data
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Api(value = "superhero", description = "Operations to manage a SuperHero")
public class SuperHeroController {

    @Autowired
    ISuperHeroService superheroservice;

    
    @GetMapping("/superheroes")
    @ApiOperation(value = "List all the SuperHeroes that are inside the company", response = SuperHero.class)
    public List<SuperHero> getSuperHeroes(){
        return (List<SuperHero>) superheroservice.findAll();
    }

    @GetMapping("/superheroes/{superheroname}")
    @ApiOperation(value = "Retrieve informations related to a specific SuperHero from his SuperHero name", response = SuperHero.class)
    public SuperHero getSuperHero(@PathVariable String superheroname){
        return superheroservice.findbyNameSuperHero(superheroname);

    }

    @PostMapping("/superheroes")
    @ApiOperation(value = "Add a new SuperHero to the company")
    public void addSuperHero(@RequestBody SuperHero superhero) {
        superheroservice.addSuperHero(superhero);
    }

    @PutMapping("/superheroes")
    @ApiOperation(value = "Update a SuperHero along with his affected missions")
    public void updateSuperHero(@RequestBody SuperHero superHero){
        superheroservice.updateSuperHero(superHero);
    }

    @DeleteMapping("/superheroes")
    @ApiOperation(value = "Delete a specific SuperHero")
    public void deleteSuperHero(@RequestBody SuperHero superhero){
        superheroservice.deleteSuperHero(superhero);
    }
}