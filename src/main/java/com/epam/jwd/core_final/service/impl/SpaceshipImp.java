package com.epam.jwd.core_final.service.impl;

import com.epam.jwd.core_final.criteria.Criteria;
import com.epam.jwd.core_final.criteria.SpaceshipCriteria;
import com.epam.jwd.core_final.domain.Spaceship;
import com.epam.jwd.core_final.service.SpaceshipService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SpaceshipImp implements SpaceshipService {

    private static SpaceshipImp instance;
    private List<Spaceship> allSpaceship;

    SpaceshipImp(){
        allSpaceship= new ArrayList<>();
    }

    static SpaceshipImp getInstance() {
        if (instance == null) {
            instance = new SpaceshipImp();
        }
        return instance;
    }

    @Override
    public List<Spaceship> findAllSpaceships() {
        return allSpaceship;
    }

    @Override
    public List<Spaceship> findAllSpaceshipsByCriteria(Criteria<? extends Spaceship> criteria) {
        SpaceshipCriteria spaceshipCriteria = (SpaceshipCriteria) criteria;
        return allSpaceship.stream().filter(x->spaceshipCriteria.isIdFit(x)&&
                spaceshipCriteria.isNameFit(x)&&
                spaceshipCriteria.isCrewFit(x)&&
                spaceshipCriteria.isReadyForNextMissionsFit(x)&&
                spaceshipCriteria.isFlightDistanceFit(x)).collect(Collectors.toList());
    }

    @Override
    public Optional<Spaceship> findSpaceshipByCriteria(Criteria<? extends Spaceship> criteria) {
        return Optional.empty();
    }

    @Override
    public Spaceship updateSpaceshipDetails(Spaceship spaceship) {
        return null;
    }

    @Override
    public void assignSpaceshipOnMission(Spaceship crewMember) throws RuntimeException {

    }

    @Override
    public Spaceship createSpaceship(Spaceship spaceship) throws RuntimeException {
        return null;
    }
}
