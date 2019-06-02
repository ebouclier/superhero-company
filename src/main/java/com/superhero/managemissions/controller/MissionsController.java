package com.superhero.managemissions.controller;

import java.util.List;

import com.superhero.managemissions.model.Missions;
import com.superhero.managemissions.service.IMissionsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

@Data
@RestController
@Api(value = "Operations for managing missions for SuperHeroes")
public class MissionsController {

    @Autowired
    IMissionsService missionsService;

    @GetMapping("/missions")
    @ApiOperation(value = "Get all the missions available")
    public List<Missions> GetMissions(){
        return (List<Missions>) missionsService.findAll();
    }

    @PostMapping("/missions")
    @ApiOperation(value = "Create a new mission")
    public void CreateMissions(@RequestBody Missions mission){
        missionsService.addMission(mission);
    }

    @PutMapping("/missions")
    @ApiOperation(value = "Updating a mission")
    public void UpdateMissions(@RequestBody Missions mission) {
        missionsService.updateMissions(mission);
    }

    @DeleteMapping("/missions")
    @ApiOperation(value = "Deleting a mission")
    public void DeleteMissions(@RequestBody Missions mission){
        missionsService.deleteMissions(mission);
    }

}