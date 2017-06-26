package com.softserve.edu.service_center_new.dao.impl;

import com.softserve.edu.service_center_new.dao.TeamDAO;
import com.softserve.edu.service_center_new.entity.Team;
import org.springframework.stereotype.Repository;

@Repository
public class TeamDAOImpl extends ElementDAOImpl<Team> implements TeamDAO {

    public TeamDAOImpl() {
        super(Team.class);
    }
}
