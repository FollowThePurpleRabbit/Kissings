package dating.project.Kissings.Services;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.CurrentTimestamp;
import org.springframework.stereotype.Service;

import dating.project.Kissings.Models.Adv;
import dating.project.Kissings.Repos.AdvRepo;
import dating.project.Kissings.Repos.UserRepo;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdvService {
	
	private final AdvRepo advRepo;
	
	public Boolean saveAdv(Adv adv) {
		adv.setActive(true);
		adv.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		if(advRepo.findByNameAndDescription(adv.getName(), adv.getDescription()) != null) {
			System.out.println("test");
			return false;
		}
		System.out.println("hhaha");
		advRepo.save(adv);
		return true;
	}
	
	
	public List<Adv> getAllAdvs() {
		return advRepo.findAll();
	}
	
	
	public Adv getAdvById(Long id) {
		Optional<Adv> advOpt = advRepo.findById(id);
		if(advOpt.isPresent()) {
			return advOpt.get();
		}
		return null;
	}
	
	

}
