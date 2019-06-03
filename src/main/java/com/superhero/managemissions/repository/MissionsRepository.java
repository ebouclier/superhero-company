package com.superhero.managemissions.repository;

import com.superhero.managemissions.model.Missions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionsRepository extends JpaRepository<Missions, Long> {}