package com.superhero.managemissions.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
public class SuperHero {
    @Id
    @GeneratedValue
    private Long id;

    private @NonNull String firstName;
    private @NonNull String lastName;
    private @NonNull String superHeroName;
    // @Column
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "superhero_missions",
    joinColumns = @JoinColumn(name = "superhero_id"),
    inverseJoinColumns = @JoinColumn(name = "missions_id")
    )
    @JsonIgnoreProperties("heroes")
    private Set<Missions> missions;
    
    public SuperHero(String superHeroName, Set<Missions> missions) {
        this.superHeroName = superHeroName;
        this.missions = missions;
    }
}