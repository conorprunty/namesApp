package com.conor.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.conor.springmvc.model.Comments;
import com.conor.springmvc.model.Teams;
import com.conor.springmvc.service.CommentsService;
import com.conor.springmvc.service.TeamsService;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	TeamsService service;

	@Autowired
	CommentsService cService;

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

	@RequestMapping(value = { "/comments" }, method = RequestMethod.GET)
	public String comments(ModelMap model) {

		List<Comments> comments = cService.findAllComments();
		model.addAttribute("comments", comments);
		return "comments";
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newEmployee(ModelMap model) {
		Comments comments = new Comments();
		model.addAttribute("comments", comments);
		return "submitComments";
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveComments(@Valid Comments comments, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "submitComments";
		}

		cService.saveComments(comments);

		model.addAttribute("success",
				comments.getName() + ", thanks for the comment!\nYour comment will be publicly visible once reviewed by the admin");
		return "success";
	}

}
