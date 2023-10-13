package dating.project.Kissings.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dating.project.Kissings.Models.Adv;

@Repository
public interface AdvRepo extends JpaRepository<Adv, Long>{
	
	Adv findByUserId(int userId);
	Adv findByNameAndDescription(String name, String description);

}
