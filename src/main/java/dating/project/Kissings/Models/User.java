package dating.project.Kissings.Models;


import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Long id;
	private String username;
	private String email;
	private String password;
	private UserRoles role;
	private Timestamp registeredAt;
	
	public static enum UserRoles {
		
		GUEST, USER, ADMIN, VLADIK

	}
	
	public String toString() {
		return "ID: " + id
				+ " | username: " + username
				+ " | email: " + email
				+ " | password: " + password
				+ " | role: " + role.toString()
				+ " | date of registration: " + registeredAt;
	}


}

   
