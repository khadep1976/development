package com.wk.wellnessdev.development.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.wk.wellnessdev.development.model.User;
import com.wk.wellnessdev.development.repository.UserRegistrationRepository;
@Controller
public class UserRegistrationController {
    
	@Autowired
	UserRegistrationRepository userRepository;//controller interact with the DB for user registration operations
	
	@GetMapping("/registration")// mapping to /registration endpoint. 
	public String getRegPage(@ModelAttribute("user") User user) {//bind user obj to model attribute
		return "register";	// returns the name of the view register 
	}
	
	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") User user, Model model) {
		userRepository.save(user);
		model.addAttribute("message", "Submitted Successfully");
		return "redirect:login";
	}
	
	@GetMapping("/display")//path .html action
	public String usersPage(Model model) {//The Model object is provided by Spring and is used to pass data to the view layer (HTML template).
		List<User> listOfUsers = userRepository.findAll();
		model.addAttribute("user", listOfUsers);
		return "user";//html file name
	}
}