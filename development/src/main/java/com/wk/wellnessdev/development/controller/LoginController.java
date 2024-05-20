package com.wk.wellnessdev.development.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.wk.wellnessdev.development.model.User;
import com.wk.wellnessdev.development.repository.LoginRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
   
    
    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") User user, Model model, HttpSession session) {
        User existingUser = loginRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (existingUser != null) {
            session.setAttribute("userId", existingUser.getId());	// Save userId in session obj-> method (String name, Object value) fetch the value only when we can have it in the session/	cooki use insted of session
            session.getAttribute("userId");
            model.addAttribute("message", "Login Successful!");
            model.addAttribute("userId", existingUser.getId());
            System.out.println("loginUserId is : "+existingUser.getId());          

            model.addAttribute("userId", existingUser.getRole());
            System.out.println("loginUser Role is : "+existingUser.getRole());      
     
            if ("Admin".equals(existingUser.getRole())) {
            	 return "redirect:selectexercise";    
            } else if ("User".equals(existingUser.getRole())) {
            	return "redirect:selectgoal";  
            }
                   
            return "";    
        } else {
            model.addAttribute("error", "Invalid username or password!");
            return "login";
        }
    }

}
