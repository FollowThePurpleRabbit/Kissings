package dating.project.Kissings.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dating.project.Kissings.Services.AdvService;
import dating.project.Kissings.Services.UserService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
	
	private final UserService userService;
	private final AdvService advService;
	
	@GetMapping("/") 
	public String getUserPage() {
		
		return "userPage";
		
	}
	
	@GetMapping("/list")
	public String getAllUsers(Model model) {
		
		model.addAttribute("users", userService.getAllUsers());
		
		System.out.println(userService.getAllUsers());
		
		return "usersListPage";
				
	}
	
	
	
	
	

}
