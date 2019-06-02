package com.superhero.managemissions.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties("heroes")
@SQLDelete(sql = "UPDATE Missions set COMPLETED = true where id=?", check = ResultCheckStyle.COUNT)
@Where(clause = "DELETED = false")
public class Missions implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private @NonNull String missionName;
    @Column(name = "COMPLETED")
    private @NonNull Boolean isCompleted = false;
    @Column(name = "DELETED")
    private @NonNull Boolean isDeleted = false;
    // @Column
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<SuperHero> heroes = new HashSet<SuperHero>();

    public Missions(String missionName) {
        this.missionName = missionName;
    }
    
    public Missions(String missionName, Set<SuperHero> superheroes) {
        this.missionName = missionName;
        this.heroes = superheroes;
    }
    
}