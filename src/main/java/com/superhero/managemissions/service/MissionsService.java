package com.superhero.managemissions.service;

import java.util.List;

import com.superhero.managemissions.model.Missions;
import com.superhero.managemissions.repository.MissionsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MissionsService implements IMissionsService {

    @Autowired
    MissionsRepository missionsrepository;

    @Override
    public List<Missions> findAll() {
        return (List<Missions>) missionsrepository.findAll();
    }

}