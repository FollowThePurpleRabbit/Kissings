package dating.project.Kissings.Controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import dating.project.Kissings.Models.User;
import dating.project.Kissings.Services.UserService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	
	private final UserService userService;
	
	@GetMapping("/")
	public String mainPage(Model model) {
		model.addAttribute("serverTime", new Date(System.currentTimeMillis()));
		return "mainPage";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "loginPage";
	}
	
	@PostMapping("/login")
	public String userPage(User user) {
		if(userService.getUser(user) == null) {
			System.out.println("Пользователь не прошел проверку");
			return "redirect:/login";
		}
		System.out.println("Юзер успшено прошел проверку, перенаправляем на его страницу /user");
		return "redirect:/user/";
	}
	
	@PostMapping("/register")
	public String registerUser(User user, Model model) {
		if(userService.saveUser(user)) {
			System.out.println("Юзер успшено прошел проверку, перенаправляем на его страницу /user");
			return "redirect:/user/";
		}
		model.addAttribute("errorMessage", "This user ia already registered");
		System.out.println("Юзер уже есть такой");
		return "redirect:/register";
	}
	
	@GetMapping("/register")
	public String registerPage() {
		return "registerPage";
	}
}
