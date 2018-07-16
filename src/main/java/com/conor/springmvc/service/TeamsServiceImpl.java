package com.conor.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.conor.springmvc.dao.TeamsDao;
import com.conor.springmvc.model.Teams;

@Service("TeamsService")
@Transactional
public class TeamsServiceImpl implements TeamsService {

	@Autowired
	private TeamsDao dao;

	@Override
	public List<Teams> findAllWorldCupTeams() {
		return dao.findAllWorldCupTeams();
	}

	@Override
	public List<Teams> findAllPremTeams() {
		return dao.findAllPremTeams();
	}
	
}
