package com.superhero.managemissions.service;

import java.util.List;

import com.superhero.managemissions.model.Missions;

public interface IMissionsService {
    public List<Missions> findAll();

	public void addMission(Missions mission);

	public void updateMissions(Missions mission);

	public void deleteMissions(Missions mission);

}