package com.epam.jwd.core_final.service.impl;

import com.epam.jwd.core_final.criteria.CrewMemberCriteria;
import com.epam.jwd.core_final.criteria.Criteria;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.service.CrewService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CrewImp implements CrewService {

    private static CrewImp instance;
    private List<CrewMember> allCrewMembers;

    CrewImp(){
        allCrewMembers= new ArrayList<>();
    }

    static CrewImp getInstance() {
        if (instance == null) {
            instance = new CrewImp();
        }
        return instance;
    }

    @Override
    public List<CrewMember> findAllCrewMembers() {
        return allCrewMembers;
    }

    @Override
    public List<CrewMember> findAllCrewMembersByCriteria(Criteria<? extends CrewMember> criteria) {
        CrewMemberCriteria crewMemberCriteria = (CrewMemberCriteria) criteria;
        return allCrewMembers.stream().filter(x->crewMemberCriteria.isRankFit(x) &&
                crewMemberCriteria.isRoleFit(x)&&
                crewMemberCriteria.isReadyForNextMissionsFit(x)&&
                crewMemberCriteria.isIdFit(x)&&
                crewMemberCriteria.isNameFit(x)).collect(Collectors.toList());
    }

    @Override
    public Optional<CrewMember> findCrewMemberByCriteria(Criteria<? extends CrewMember> criteria) {
        return Optional.empty();
    }

    @Override
    public CrewMember updateCrewMemberDetails(CrewMember crewMember) {
        return null;
    }

    @Override
    public void assignCrewMemberOnMission(CrewMember crewMember) throws RuntimeException {

    }

    @Override
    public CrewMember createCrewMember(CrewMember spaceship) throws RuntimeException {
        return null;
    }
}
