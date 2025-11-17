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
import com.hr.repository.EmployeeRepo;
import com.hr.service.HrService;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;

@Controller
public class HrController {

	@Autowired
	private HrService service;
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	

	@GetMapping("/login")
	public String login() {

		return "login";

	}

	@GetMapping("/forgot-password")

	public String forgotPassword() {

		return "forgot-password";
	}

	@GetMapping("/home")
	public String home(@RequestParam("username") String username,
	                   @RequestParam("password") String password,
	                   Model model,
	                   HttpSession session) {

	    System.out.println("User ID: " + username + " | Password(DOB): " + password);

	    try {
	        int empId = Integer.parseInt(username);
	        Employee employee = employeeRepo.findByIdAndPassword(empId, password);

	        if (employee != null) {
	        	
	        	session.setAttribute("userId", empId);
	        	session.setAttribute("desg", employee.getDesignation());
	        	session.setAttribute("name", employee.getEmployeeName());
	            session.setAttribute("employee", employee);
	            model.addAttribute("error", false);
	            System.out.println("Login successful for employee ID: " + empId);
	            return "dash-board";
	        } else {
	            model.addAttribute("error", true);
	            System.out.println("Invalid credentials for employee ID: " + empId);
	            return "login";
	        }
	    } catch (NumberFormatException e) {
	        model.addAttribute("error", true);
	        System.out.println("Invalid employee ID format");
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

//	@GetMapping("/my-profile")
//	public String myProfile(HttpSession session, Model model ) {
//                   
//	     Object attribute =	session.getAttribute("userId");
//	     
//	    int empId =  Integer.parseInt(attribute.toString());
//	    
//	     Employee employee = employeeRepo.findById(empId).get();
//	     
//	     model.addAttribute("employee", employee);
//	     
//	    System.out.println("object:-" +attribute);
//		return "my-profile";
//	}
	
	
	@GetMapping("/my-profile")
	public String myProfile(HttpSession session, Model model) {

	    Object attribute = session.getAttribute("userId");

	    // 🔥 FIX: Handle null session attribute
	    if (attribute == null) {
	        System.out.println("Session expired or user not logged in.");
	        return "redirect:/login";
	    }

	    int empId = Integer.parseInt(attribute.toString());

	    Employee employee = employeeRepo.findById(empId).orElse(null);

	    if (employee == null) {
	        model.addAttribute("error", "Employee not found");
	        return "error";
	    }

	    model.addAttribute("employee", employee);

	    return "my-profile";
	}

	
	
	
	

	@GetMapping("/setting")
	public String setting() {

		return "setting";

	}

	@PostMapping("/save-employee")
	public String saveEmployee(@ModelAttribute Employee employee) {
		
		employee.setPassword(employee.getDateOfBirth());
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
	
	
	@PostMapping("/update-password")
    public String updatePassword(@RequestParam("password") String password, @RequestParam("newPassword1") String newPassword1, @RequestParam("newPassword2") String newPassword2, HttpSession session, Model model){
    	 
		
		  Object attribute = session.getAttribute("userId");

		    // 🔥 FIX: Handle null session attribute
			
		    int userId = Integer.parseInt(attribute.toString());

		    Employee employee = employeeRepo.findByIdAndPassword(userId, password);
		    
            if(employee != null && newPassword1.equals(newPassword2)){
				
            	employee.setPassword(newPassword2);
            	
            	employeeRepo.save(employee);
            	
            	model.addAttribute("error", false);
            
			}
            else {
            	
            	model.addAttribute("error", true);
            	return "setting";
            }
    	
            return "redirect:/login";
  
    }
	
	
	
	
	
	

  }





