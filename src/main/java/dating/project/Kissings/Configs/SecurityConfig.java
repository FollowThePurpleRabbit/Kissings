package dating.project.Kissings.Configs;

import java.text.Normalizer.Form;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@RequiredArgsConstructor
@Configuration
public class SecurityConfig {
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		return http.
				csrf(c -> c.disable())
				.authorizeHttpRequests(request -> request.requestMatchers("/")
			    .permitAll()
			    .requestMatchers("/login")
			    .permitAll()
			    .requestMatchers("/register")
			    .permitAll()
			    .requestMatchers("/user/**")
			    .permitAll()
			    .requestMatchers("/advertisments/**")
			    .permitAll()
			    .anyRequest().authenticated())
				.build();
			
                    
	}
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(8);
	}
	
	

}

