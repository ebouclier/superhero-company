package com.superhero.managemissions.repository;

import com.superhero.managemissions.model.Missions;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionsRepository extends CrudRepository<Missions, Long> {}