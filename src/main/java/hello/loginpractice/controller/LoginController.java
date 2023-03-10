package hello.loginpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.ConfigurationPropertyName.Form;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hello.loginpractice.model.User;
//import org.springframework.web.bind.annotation.RequestParam;
import hello.loginpractice.repository.UserRepository;

@Controller
public class LoginController {

	@Autowired
	UserRepository repository;
	
	@Autowired
	User user;
	
	@GetMapping("/auth")
	public String login() {
		return "login";
	}
	
	@GetMapping("/signup")
	public String signup() {
		
		return "signup";
	}
	
	@RequestMapping("/register")
	public String loginSuccess(@ModelAttribute User form) {
								
		user.setName(form.getName());
		String rawPw = form.getPassword();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		user.setPassword(passwordEncoder.encode(rawPw));
		user.setUserid(form.getUserid());
		
		try {
			repository.save(user);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return "redirect:/auth";
	}
	
	@GetMapping("/accessDenied")
	public String loginFailed() {
		return "accessDenied";
	}
//	System.out.println(userid + ", " + username + ", " + password);
//	@RequestParam("userid") String userid,
//	@RequestParam("username") String username,
//	@RequestParam("password") String password
}
