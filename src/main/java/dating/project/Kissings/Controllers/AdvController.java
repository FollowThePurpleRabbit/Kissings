package dating.project.Kissings.Controllers;

import java.security.Principal;

import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dating.project.Kissings.Models.Adv;
import dating.project.Kissings.Services.AdvService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/advertisments")
@RequiredArgsConstructor
public class AdvController {
	
	private final AdvService advService;
	
	@GetMapping("/")
	public String advsPage(Model model) {
		model.addAttribute("advs", advService.getAllAdvs());
		return "advsListPage.html";
	}
	
	@GetMapping("/add")
	public String addAdv() {
		return "addAdv.html";
	}
	
	@PostMapping("/add")
	public String addingAdv(Adv adv) {
		
		if(advService.saveAdv(adv)) {
			return "redirect:/advertisments/";
		}
		
		return "redirect:/advertisments/add";
		
	}

}
