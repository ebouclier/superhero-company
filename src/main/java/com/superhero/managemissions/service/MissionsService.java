package com.superhero.managemissions.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.superhero.managemissions.model.Missions;
import com.superhero.managemissions.repository.MissionsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MissionsService implements IMissionsService {

    @Autowired
    MissionsRepository missionsrepository;

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Missions> findAll() {
        return (List<Missions>) missionsrepository.findAll();
    }

    @Override
    public void addMission(Missions mission) {
        missionsrepository.save(mission);
    }

    @Transactional
    @Override
    public void updateMissions(Missions mission) {
        em.merge(mission);

    }

    @Override
    public void deleteMissions(Missions mission) {
        missionsrepository.delete(mission);
    }

}