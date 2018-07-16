package com.conor.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.conor.springmvc.model.Teams;

@Repository("teamsDao")
public class TeamsDaoImpl extends AbstractDao<Integer, Teams> implements TeamsDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Teams> findAllWorldCupTeams() {
		Criteria criteria = createEntityCriteria().add(Restrictions.eq("teamType", "worldcup"))
				.addOrder(Order.asc("name"));
		return (List<Teams>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teams> findAllPremTeams() {
		Criteria criteria = createEntityCriteria().add(Restrictions.eq("teamType", "prem")).addOrder(Order.asc("name"));
		return (List<Teams>) criteria.list();
	}

}
