package com.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.bankapp.filter.AfterLoginFilter;

@Configuration
@EnableWebSecurity(debug = true) // Spring sec aop
public class SecConfig {

	@Autowired
	private AfterLoginFilter afterLoginFilter;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	//1- db for getting user deteails -> DaoAuthenticationProvider --> this guy need -->userDetailsService
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
	        return authenticationProvider;
	}
	
	

	// encoding base64 vs de-ecrptation SHA256
//	@Bean
//	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//		UserDetails raj = User.withUsername("raj")
//				.password(passwordEncoder.encode("raj123"))
//				.roles("ADMIN").build();
//
//		UserDetails ekta = User.withUsername("ekta")
//				.password(passwordEncoder.encode("ekta123"))
//				.roles("MGR").build();
//
//		UserDetails gun = User.withUsername("gun")
//				.password(passwordEncoder.encode("gun123"))
//				.roles("CLERK").build();
//		
//		return new InMemoryUserDetailsManager(raj, ekta, gun);
//
//	}
//	
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                		reg-> reg.requestMatchers("/admin/**").hasAnyRole("ADMIN")
                		         .requestMatchers("/mgr/**").hasAnyRole("ADMIN","MGR")
                		         .requestMatchers("/clerk/**").hasAnyRole("ADMIN","MGR","CLERK")
                		         .requestMatchers("/register/**").permitAll()
                		         .anyRequest().authenticated()
                		         )
                .httpBasic(Customizer.withDefaults())
                .addFilterAfter(afterLoginFilter,UsernamePasswordAuthenticationFilter.class)
                .sessionManagement(httpSecuritySessionManagementConfigurer ->
                        httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
  

}
