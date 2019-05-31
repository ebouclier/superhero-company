package com.superhero.managemissions.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Missions {

    @Id
    @GeneratedValue
    private Long id;

    private @NonNull String missionName;
    private @NonNull Boolean isCompleted;
    private @NonNull Boolean isDeleted;
    // @Column
    @ManyToMany(mappedBy = "missions")
    @JsonIgnoreProperties("missions")
    private Set<SuperHero> heroes;

    public Missions(String missionName) {
        this.missionName = missionName;
    }
}