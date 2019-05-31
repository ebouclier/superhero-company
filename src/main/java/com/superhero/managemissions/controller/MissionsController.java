package com.superhero.managemissions.controller;

import java.util.List;

import com.superhero.managemissions.model.Missions;
import com.superhero.managemissions.service.IMissionsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@Data
@RestController
public class MissionsController {

    @Autowired
    IMissionsService missionsService;

    @GetMapping("/missions")
    public List<Missions> GetMissions(){
        return (List<Missions>) missionsService.findAll();
    }

}