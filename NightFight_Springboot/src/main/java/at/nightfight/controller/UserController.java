package at.nightfight.controller;

import at.nightfight.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
//@PreAuthorize("hasAuthority('NewsUserRole')")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping
	public String getAllNews(Model model) {
		model.addAttribute("userList", userRepository.findAll());
		return "index";
	}
}