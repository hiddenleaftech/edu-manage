package com.hiddenleaf.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
//--import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hiddenleaf.endpoints.JwtAuthenticationEntryPoint;
import com.hiddenleaf.filter.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true , securedEnabled = true, proxyTargetClass = true) 
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Logger log = LogManager.getLogger();

	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;	
	
    
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception {
		return new JwtAuthenticationFilter();
	}

	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Note that the CSRf token is disabled for all requests
		log.info("Disabling CSRF, enabling basic authentication...");

		http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
		
		http.cors().and().csrf().disable().authorizeRequests()
				.antMatchers(
						"/api/woc/v2/api-docs", 
						"/api/swagger.json", 
						"/**/v2/api-docs", 
						"/configuration/ui",
						"/swagger-resources", 
						"/configuration/security",
						"/swagger-ui.html", 
						"/webjars/**",
						"/swagger-resources/configuration/ui", 
						"/swagge‌​r-ui.html",
						"/swagger-resources/configuration/security") 
				//--TODO remove after checked
				.permitAll().anyRequest().authenticated().and().exceptionHandling()
				.authenticationEntryPoint(unauthorizedHandler).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

}
