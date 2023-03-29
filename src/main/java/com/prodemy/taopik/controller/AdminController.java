package com.prodemy.taopik.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prodemy.taopik.models.Admin;
import com.prodemy.taopik.services.AdminService;
@Controller
public class AdminController {
	@Autowired
	AdminService as;
	@PostMapping("/new_admin_action")
	public String newAdminAction(@ModelAttribute("customer") Admin admin, @RequestParam("pin") int pin, Model m){
		if (pin == 1234) {
			as.save(admin);
			return "login";
		} else {
			m.addAttribute("fail", "PIN yang anda masukan tidak sesuai !");
			return "new_admin_form";
		}
		
	}
	@GetMapping("/new_admin")
	public String newAdmin(Model m) {
		m.addAttribute("fail", null);
		return "new_admin_form";
	}

}
