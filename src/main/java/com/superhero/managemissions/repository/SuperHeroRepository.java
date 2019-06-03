package com.superhero.managemissions.repository;

import com.superhero.managemissions.model.SuperHero;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperHeroRepository extends JpaRepository<SuperHero, Long> {}