package com.mystockcheck.mystockcheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	
    private UserDetailsServiceImpl userDetailsService;

	@Autowired
	public WebSecurityConfig(UserDetailsServiceImpl userDetailsService) {
		this.userDetailsService = userDetailsService;
	}



	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http

			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/title", "/register", "/login?logout").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll())
			.userDetailsService(userDetailsService);
			
			http.csrf(AbstractHttpConfigurer::disable);

			

		return http.build();
	}

	@Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
	}


	//@Bean UserDetailsServiceImpl userDetailsService() {
		//return userDetailsService;
	//}




// @SuppressWarnings("deprecation")
    // @Bean
	// public UserDetailsService userDetailsService() {

	// 	UserDetails user =
	// 		 User.withDefaultPasswordEncoder()
	// 			.username("user")
	// 			.password("password")
	// 			.roles("USER")
	// 			.build();

	// 	return new InMemoryUserDetailsManager(user);
	// }