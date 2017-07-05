package com.softserve.edu.service_center_new.dao.impl;

import com.softserve.edu.service_center_new.dao.TeamDAO;
import com.softserve.edu.service_center_new.dao.util.HibernateUtil;
import com.softserve.edu.service_center_new.entity.State;
import com.softserve.edu.service_center_new.entity.Team;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamDAOImpl extends ElementDAOImpl<Team> implements TeamDAO {

    public TeamDAOImpl() {
        super(Team.class);
    }

    @Override
    public Team getTeamByName(String name) {
        Team team = null;
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {
            Query query =
                    session.createQuery("from Team where name = :teamName");
            query.setParameter("teamName", name);
            List teams = query.list();
            if (!teams.isEmpty()) {
                team = (Team) teams.get(0);
            }
        }
        return team;
    }
}
