package com.softserve.edu.service_center_new.service.impl;

import com.softserve.edu.service_center_new.dao.TeamDAO;
import com.softserve.edu.service_center_new.entity.Team;
import com.softserve.edu.service_center_new.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private TeamDAO teamDAO;

    @Autowired
    public void setTeamDAO(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    @Override
    public void addTeam(Team team) {
        teamDAO.addElement(team);
    }

    @Override
    public void updateTeam(Team team) {
        teamDAO.updateElement(team);
    }

    @Override
    public Team getTeamById(int id) {
        return teamDAO.getElementById(id);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamDAO.getAllElements();
    }

    @Override
    public void deleteTeam(Team team) {
        teamDAO.deleteElement(team);
    }

    @Override
    public Team getTeamByName(String name) {
        return teamDAO.getTeamByName(name);
    }
}
