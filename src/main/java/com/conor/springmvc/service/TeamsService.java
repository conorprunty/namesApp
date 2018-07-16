package com.conor.springmvc.service;

import java.util.List;

import com.conor.springmvc.model.Teams;

public interface TeamsService {

	List<Teams> findAllWorldCupTeams(); 
	
	List<Teams> findAllPremTeams(); 
	
}
