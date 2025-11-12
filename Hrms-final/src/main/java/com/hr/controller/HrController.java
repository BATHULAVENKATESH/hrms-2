package com.hr.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hr.entity.CreatePost;
import com.hr.entity.Employee;
import com.hr.service.HrService;

import org.springframework.ui.Model;

@Controller
public class HrController {

	@Autowired
	private HrService service;

	@GetMapping("/login")
	public String login() {

		return "login";

	}

	@GetMapping("/forgot-password")

	public String forgotPassword() {

		return "forgot-password";
	}

	@GetMapping("/home")
	public String home(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) {

		System.out.println("Username: " + username + ", Password: " + password + " => login attempt");

		if (username.equals("123456") && password.equals("abcd")) {
			return "dash-board";
		} else {
			model.addAttribute("error", "Invalid username or password");
			return "login";
		}
	}

	@GetMapping("/dash-board")
	public String dashBoard() {

		return "dash-board";
	}

	@GetMapping("/add-employee")
	public String addEmployee(Model model) {

		model.addAttribute("employee", new Employee());

		return "add-employee";
	}

	@GetMapping("/all-employee")
	public String allEmployee() {

		return "all-employee";
	}

	@GetMapping("/status")
	public String status() {

		return "status";
	}

	@GetMapping("/my-profile")
	public String myProfile() {

		return "my-profile";
	}

	@GetMapping("/setting")
	public String setting() {

		return "setting";

	}

	@PostMapping("/save-employee")
	public String saveEmployee(@ModelAttribute Employee employee) {
		Employee emp = service.addEmployee(employee);

		return "redirect:/all-employee";

	}

	@PostMapping("/save-post")
	public String savePost(@ModelAttribute CreatePost createpost) {

		createpost.setAddedDate(new Date(System.currentTimeMillis()).toString());

		CreatePost addPost = service.addPost(createpost);

		return "redirect:/create-post";
	}

	@GetMapping("/create-post")
	public String createPost(Model model) {

		model.addAttribute("post", service.getAllPosts());

		return "create-post";
	}

}
