package dating.project.Kissings.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import dating.project.Kissings.Models.User;

public interface UserRepo extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
	User findByUsername(String username);

}
