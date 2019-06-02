package com.superhero.managemissions.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.superhero.managemissions.model.Missions;
import com.superhero.managemissions.model.SuperHero;
import com.superhero.managemissions.repository.SuperHeroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuperHeroService implements ISuperHeroService {

    @Autowired
    SuperHeroRepository superherorepository;

    @PersistenceContext
    EntityManager em;

    @Override
    public List<SuperHero> findAll() {
        return (List<SuperHero>) superherorepository.findAll();
    }

    @Override
    public SuperHero findbyNameSuperHero(String superheroname) {
        TypedQuery<SuperHero> sp = em.createQuery("SELECT sp FROM SuperHero sp WHERE sp.superHeroName = :name", SuperHero.class);
        sp.setParameter("name", superheroname);
        return sp.getSingleResult();
    }

    @Override
    public void addSuperHero(SuperHero superhero) {
        superherorepository.save(superhero);
    }

    @Transactional
    @Override
    public void updateSuperHero(SuperHero superHero) {
        em.merge(superHero);
    }

    @Override
    public void deleteSuperHero(SuperHero superhero) {
        SuperHero sp = em.find(SuperHero.class, 1);

        for (Missions missions : sp.getMissions()){
            if (!missions.getIsCompleted()){
                em.remove(missions);
            }
        }
        em.remove(sp);
        // superherorepository.delete(superhero);
    }

}