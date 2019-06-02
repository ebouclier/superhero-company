package com.superhero.managemissions.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
// @JsonIgnoreProperties("heroes")
public class SuperHero implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private @NonNull String firstName;
    private @NonNull String lastName;
    private @NonNull String superHeroName;
    // @Column
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinTable(name = "superhero_missions",
    joinColumns = @JoinColumn(name = "superhero_id"),
    inverseJoinColumns = @JoinColumn(name = "missions_id")
    )
    @JsonIgnoreProperties("heroes")
    private Set<Missions> missions = new HashSet<Missions>();
    
    public SuperHero(String superHeroName, Set<Missions> missions) {
        this.superHeroName = superHeroName;
        this.missions = missions;
    }
}