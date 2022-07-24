package com.codejava;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Controller
public class AppController {
	
	@Autowired
	private UserRepository repo;

	//this is for home
		@RequestMapping("/dashboard")
		public String home(Model model) {
			
			model.addAttribute("title", "Dashboard | MedTech");
			return "home";
		}
		
		
		//this is for about
		@RequestMapping("/about-hospital")
		public String about(Model model) {
			
			model.addAttribute("title", "About | MedTech");
			return "about";
		}
		
		//this is for about
			@RequestMapping("/services")
			public String services(Model model) {
				
				model.addAttribute("title", "Services | MedTech");
				return "services";
			}
		
		//this is for home
			@RequestMapping("/departments")
			public String departments(Model model) {
				
				model.addAttribute("title", "Departments | MedTech");
				return "departments";
			}
			
			
		
		//this is for login
		@RequestMapping("/login")
		public String login(Model model) {
			
			model.addAttribute("title", "Login | MedTech");
			return "login";
		}

			
			
			//this is for login doctor
					@RequestMapping("/doctor")
					public String doctor(Model model) {
						
						model.addAttribute("title", "Login | MedTech");
						return "doctor";
					}
		
					
			//this is for login patient
					@RequestMapping("/patient")
					public String patient(Model model) {
						
						model.addAttribute("title", "Login | MedTech");
						return "patient";
					}

		//this is for contactus
			@RequestMapping("/contactus")
			public String contactus(Model model) {
				
				model.addAttribute("title", "Contact us | MedTech");
				return "contactus";
			}
		
		//this is for gallery
		@RequestMapping("/doctorlist")
		public String doctorlist(Model model) {
			
			model.addAttribute("title", "Doctorlist | MedTech");
			return "doctorlist";
		}
		
		//cardiology
		@RequestMapping("/Cardiology")
		public String cardiology(Model model) {
			
			model.addAttribute("title", "Cardiology | MedTech");
			return "Cardiology";
		}
		
		// doc1
				@RequestMapping("/doc")
				public String doc1(Model model) {
					
					model.addAttribute("title", "Doctorlist | MedTech");
					return "doc";
				}
		
		//this is for signup
		@RequestMapping("/signup")
		public String signup(Model model) {
			
			model.addAttribute("title", "Signup | MedTech");                
			model.addAttribute("user", new User());
			return "signup";
		}


	@GetMapping("/register")
	public String showSignUpForm(Model model) {
	    model.addAttribute("user", new User());
	     
	    return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegistration(User user) {
	     
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
	    repo.save(user);
	     
	    return "register_success";
	}
	
	@GetMapping("/list_users")
	public String listUsers(Model model) {
	    
		List<User> listUsers = repo.findAll();
		model.addAttribute("listUsers", listUsers);
	    
	    return "users";
	}
	
	@GetMapping("/patient")
	public String listUsers1(Model model) {
	    
		List<User> listUsers = repo.findAll();
		model.addAttribute("listUsers", listUsers);
	    
	    return "patientdetail";
	}
}
