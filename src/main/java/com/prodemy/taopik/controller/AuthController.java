package com.prodemy.taopik.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prodemy.taopik.models.Admin;
import com.prodemy.taopik.models.Customer;
import com.prodemy.taopik.services.AdminService;
import com.prodemy.taopik.services.CustomerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AuthController {
	@Autowired CustomerService cs;
	@Autowired
	AdminService as;
	@GetMapping("/display")
	public String show() throws IOException {
		return "view";
	}

	@GetMapping("/")
	public String loginPage() {
		return "login";
	}

	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}

	@PostMapping("/login_action")
	public void checkCreds(@RequestParam("username") String unm, @RequestParam("password") String pwd,
			HttpServletRequest req, HttpServletResponse res) throws IOException { 
			Admin admin= as.getAdmin(unm);

		if (unm.equals(admin.getUsername()) && pwd.equals(admin.getPassword())) {
			req.getSession().setAttribute("username", unm);
			res.sendRedirect("display");
		} else {
			res.sendRedirect("login");
		}

	}

	@GetMapping("/guest")
	public void guest(HttpServletResponse res) throws IOException {
		res.sendRedirect("display");
	}

	@GetMapping("/logout")
	public void logoutAdminUser(HttpServletRequest req, HttpServletResponse res) throws IOException {
		req.getSession().invalidate();
		res.sendRedirect("login");
	}
	@GetMapping("/search")
	public String search(Model m, @RequestParam("keyword") String keyword) {
		String title = "Search Result for " +'"'+keyword+'"';
		List<Customer> customerList = cs.search(keyword);
		m.addAttribute("customers", customerList);
		m.addAttribute("title", title);
		return "display";
	} 
}
