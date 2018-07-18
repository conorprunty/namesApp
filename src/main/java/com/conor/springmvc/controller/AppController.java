package com.conor.springmvc.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.conor.springmvc.model.Comments;
import com.conor.springmvc.model.Teams;
import com.conor.springmvc.model.User;
import com.conor.springmvc.service.CommentsService;
import com.conor.springmvc.service.TeamsService;
import com.conor.springmvc.service.UserProfileService;
import com.conor.springmvc.service.UserService;
import com.conor.springmvc.model.UserProfile;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {

	@Autowired
	TeamsService service;

	@Autowired
	CommentsService cService;

	@Autowired
	MessageSource messageSource;
	
	@Autowired
    UserService userService;
	
	@Autowired
    UserProfileService userProfileService;

	@Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
     
    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;


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
	
	@RequestMapping(value = { "/admin" }, method = RequestMethod.GET)
	public String admin() {
		// TODO - sort admin page
		return "admin";
	}
	
	@RequestMapping(value = { "/admin/allcomments" }, method = RequestMethod.GET)
	public String allComments(ModelMap model) {

		List<Comments> comments = cService.findAllModComments();
		model.addAttribute("allcomments", comments);
		return "allcomments";
	}
	
	/**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = {"/admin/userslist" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {

		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		model.addAttribute("loggedinuser", getPrincipal());
		return "userslist";
	}

	
	  /**
     * This method will provide the medium to add a new user.
     */
    @RequestMapping(value = { "/admin/newuser" }, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "registration";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * saving user in database. It also validates the user input
     */
    @RequestMapping(value = { "/admin/newuser" }, method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "registration";
        }
 
        /*
         * Preferred way to achieve uniqueness of field [sso] should be implementing custom @Unique annotation 
         * and applying it on field [sso] of Model class [User].
         * 
         * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
         * framework as well while still using internationalized messages.
         * 
         */
        if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
            FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
            result.addError(ssoError);
            return "registration";
        }
         
        userService.saveUser(user);
 
        model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " registered successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        //return "success";
        return "registrationsuccess";
    }
    
	/**
	 * This method will provide the medium to update an existing comment.
	 */
	@RequestMapping(value = { "/admin/edit-comments-{id}" }, method = RequestMethod.GET)
	public String editComment(@PathVariable int id, ModelMap model) {
		Comments comments = cService.findById(id);
		model.addAttribute("comments", comments);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "submitModComments";
	}
	
	/**
	 * This method will be called on form submission, handling POST request for
	 * updating comment in database.
	 */
	@RequestMapping(value = { "/admin/edit-comments-{id}" }, method = RequestMethod.POST)
	public String updateComment(@Valid Comments comments, BindingResult result,
			ModelMap model, @PathVariable int id) {

		if (result.hasErrors()) {
			return "submitModComments";
		}


		cService.updateComments(comments);

		model.addAttribute("success", "Comment: \"" + comments.getComments() + "\"\nby "+ comments.getName() + "\nadded successfully to the public.");
		model.addAttribute("loggedinuser", getPrincipal());
		return "allcommentssuccess";
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
	
	 @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	    public String accessDeniedPage(ModelMap model) {
	        model.addAttribute("loggedinuser", getPrincipal());
	        return "accessDenied";
	    }
	 
	  /**
	     * This method handles login GET requests.
	     * If users is already logged-in and tries to goto login page again, will be redirected to admin page.
	     */
	    @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String loginPage() {
	        if (isCurrentAuthenticationAnonymous()) {
	            return "login";
	        } else {
	            return "redirect:/admin";  
	        }
	    }
	    
	    /**
		 * This method will provide UserProfile list to views
		 */
		@ModelAttribute("roles")
		public List<UserProfile> initializeProfiles() {
			return userProfileService.findAll();
		}
	 
	    /**
	     * This method handles logout requests.
	     * Toggle the handlers if your RememberMe functionality is useless in your app.
	     */
	    @RequestMapping(value="/logout", method = RequestMethod.GET)
	    public String logoutPage (HttpServletRequest request, HttpServletResponse response){
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null){    
	            //new SecurityContextLogoutHandler().logout(request, response, auth);
	            persistentTokenBasedRememberMeServices.logout(request, response, auth);
	            SecurityContextHolder.getContext().setAuthentication(null);
	        }
	        return "redirect:/login?logout";
	    }


	    /**
	     * This method returns the principal[user-name] of logged-in user.
	     */
	    private String getPrincipal(){
	        String userName = null;
	        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 
	        if (principal instanceof UserDetails) {
	            userName = ((UserDetails)principal).getUsername();
	        } else {
	            userName = principal.toString();
	        }
	        return userName;
	    }
	     
	    /**
	     * This method returns true if users is already authenticated [logged-in], else false.
	     */
	    private boolean isCurrentAuthenticationAnonymous() {
	        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        return authenticationTrustResolver.isAnonymous(authentication);
	    }


}
