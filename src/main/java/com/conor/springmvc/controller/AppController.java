package com.conor.springmvc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.conor.springmvc.model.Teams;
import com.conor.springmvc.service.TeamsService;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	TeamsService service;
	
	@Autowired
	MessageSource messageSource;

	
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String homePage() {
		// this returns the .jsp page to open when going to 
		// @RequestMapping(value = { "/", "/index" }
		return "index";
	}
	
	@RequestMapping(value = { "/worldcup" }, method = RequestMethod.GET)
	public String worldCupTeams(ModelMap model) {

		List<Teams> teams = service.findAllWorldCupTeams();
		// the first argument is used in the 
		// .jsp file (worldcup.jsp here) and is 
		// how the .jsp accesses the values in the 
		// map
		model.addAttribute("teams", teams);
		return "worldcup";
	}
	
	@RequestMapping(value = { "/premteams" }, method = RequestMethod.GET)
	public String premTeams(ModelMap model) {

		List<Teams> teams = service.findAllPremTeams();
		model.addAttribute("teams", teams);
		return "premteams";
	}

}
