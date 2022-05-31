package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.Login;
import com.service.ServiceDelegate;

@Controller
public class ClientController {

	@Autowired
	ServiceDelegate serviceDelegate;

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/register")
	public String getRegister(Model model) {
		model.addAttribute("login", new Login());
		return "register";
	}

	@PostMapping("/register")
	public String postRegister(@ModelAttribute("login") Login login) {
		serviceDelegate.register(login);
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String getLogin(Model model) {
		model.addAttribute("login", new Login());
		return "login";
	}

	@PostMapping("/login")
	public String postlogin(@ModelAttribute("login") Login login) {
		
		String message = serviceDelegate.verify(login);
		System.out.println("postlogin" + message);
		if (message == "Successful") {
			return "redirect:/products";
		}
		return "redirect:/products";
	}
	
	@GetMapping("/products")
	public String getProducts(Model model) {
		model.addAttribute("products", serviceDelegate.listAllProduct());
		return "products";
		
	}
	
	@GetMapping("/addToCart")
	public String getaddToCart() {
		return "cart";
		
	}

}
