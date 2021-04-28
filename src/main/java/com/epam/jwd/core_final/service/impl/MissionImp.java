package com.epam.jwd.core_final.service.impl;

import com.epam.jwd.core_final.criteria.Criteria;
import com.epam.jwd.core_final.criteria.FlightMissionCriteria;
import com.epam.jwd.core_final.domain.FlightMission;
import com.epam.jwd.core_final.service.MissionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MissionImp implements MissionService {

    private static MissionImp instance;
    private List<FlightMission> allMissions;

    MissionImp() {
        allMissions = new ArrayList<>();
    }

    static MissionImp getInstance() {
        if (instance == null) {
            instance = new MissionImp();
        }
        return instance;
    }

    @Override
    public List<FlightMission> findAllMissions() {
        return allMissions;
    }

    @Override
    public List<FlightMission> findAllMissionsByCriteria(Criteria<? extends FlightMission> criteria) {
        FlightMissionCriteria flightMissionCriteria = (FlightMissionCriteria) criteria;
        return allMissions.stream().filter(x -> flightMissionCriteria.isIdFit(x) &&
                flightMissionCriteria.isNameFit(x) &&
                flightMissionCriteria.isMissionsNameFit(x) &&
                flightMissionCriteria.isStartDateFit(x) &&
                flightMissionCriteria.isEndDateFit(x) &&
                flightMissionCriteria.isDistanceFit(x) &&
                flightMissionCriteria.isAssignedSpaceshipFit(x) &&
                flightMissionCriteria.isAssignedCrewFit(x) &&
                flightMissionCriteria.isMissionResultFit(x) &&
                flightMissionCriteria.isFromFit(x) &&
                flightMissionCriteria.isToFit(x)).collect(Collectors.toList());
    }

    @Override
    public Optional<FlightMission> findMissionByCriteria(Criteria<? extends FlightMission> criteria) {
        return Optional.empty();
    }

    @Override
    public FlightMission updateSpaceshipDetails(FlightMission flightMission) {
        return null;
    }

    @Override
    public FlightMission createMission(FlightMission flightMission) {
        return null;
    }
}
