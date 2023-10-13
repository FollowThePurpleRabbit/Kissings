package dating.project.Kissings.Services;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dating.project.Kissings.Models.User;
import dating.project.Kissings.Repos.UserRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepo userRepo;
	private final PasswordEncoder passwordEncoder;
	
	public Boolean saveUser(User user) {
		if(userRepo.findByEmail(user.getEmail()) != null 
				|| userRepo.findByUsername(user.getUsername()) != null) {
			return false;
		}
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(User.UserRoles.USER);
		user.setRegisteredAt(new Timestamp(new java.util.Date().getDate()));
		userRepo.save(user);
		return true;
	}
	
	public User getUser(User user) {
		
		User userTestUser = userRepo.findByEmail(user.getEmail());
		
		if(userTestUser == null) {
			return null;
		}
		
		if(!passwordEncoder.matches(user.getPassword(), userTestUser.getPassword())) {
			return null;
		}
		
		return userTestUser;
	}
	
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	

}
