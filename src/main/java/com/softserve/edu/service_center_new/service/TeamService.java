package com.softserve.edu.service_center_new.service;

import com.softserve.edu.service_center_new.entity.Team;

import java.util.List;

public interface TeamService {

    void addTeam(Team team);

    void updateTeam(Team team);

    Team getTeamById(int id);

    List<Team> getAllTeams();

    void deleteTeam(Team team);
}
