package com.superhero.managemissions.service;

import java.util.List;

import com.superhero.managemissions.model.Missions;

public interface IMissionsService {
    public List<Missions> findAll();

}