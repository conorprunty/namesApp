package com.conor.springmvc.dao;

import java.util.List;

import com.conor.springmvc.model.Teams;

public interface TeamsDao {
	
	List<Teams> findAllWorldCupTeams();
	
	List<Teams> findAllPremTeams();
}
