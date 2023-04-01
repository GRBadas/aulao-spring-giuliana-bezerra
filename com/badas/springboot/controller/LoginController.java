package com.badas.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.badas.springboot.DTO.UserLoginDTO;
import com.badas.springboot.repository.UserModelRepository;
import com.badas.springboot.service.DefaultUserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private DefaultUserService userService;
	
	@Autowired
	UserModelRepository userRepo;
    
    @ModelAttribute("user")
    public UserLoginDTO userLoginDTO() {
        return new UserLoginDTO();
    }
    
	@GetMapping
	public String login() {
		return "login";
	}
	
	@PostMapping
	public void loginUser(@ModelAttribute("user") 
	UserLoginDTO userLoginDTO) {
		System.out.println("UserDTO"+userLoginDTO);
		 userService.loadUserByUsername(userLoginDTO.getUsername());
	}
}
