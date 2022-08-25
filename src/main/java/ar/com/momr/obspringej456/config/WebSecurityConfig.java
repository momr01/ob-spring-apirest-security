package ar.com.momr.obspringej456.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

		@Bean
		public BCryptPasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}

		@Bean
		public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			http.authorizeRequests()
				.antMatchers("/api/laptops").permitAll()
				.antMatchers("/saludo").permitAll()
				.antMatchers("/api/laptops/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.and()
				.httpBasic();
			return http.build();
		}
		
		@Bean
		public InMemoryUserDetailsManager userDetailsService() {
			UserDetails user1 = User.withUsername("admin")
					.password(passwordEncoder().encode("password"))
					.roles("ADMIN", "USER")
					.build();
			UserDetails user2 = User.withUsername("user")
					.password(passwordEncoder().encode("password"))
					.roles("USER")
					.build();
			return new InMemoryUserDetailsManager(user1, user2);
					
		}

	}


