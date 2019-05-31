package com.superhero.managemissions.repository;

import com.superhero.managemissions.model.SuperHero;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperHeroRepository extends CrudRepository<SuperHero, Long> {}