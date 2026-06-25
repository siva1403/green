package com.Nother.No.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.context.support.ServletContextResourcePatternResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.boot.autoconfigure.thymeleaf.*;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
		 System.out.println("In security controller");
		
		 System.out.println( http.getSharedObjects());
	        http.csrf().disable()
	                .authorizeRequests(authorize -> authorize.mvcMatchers("/").permitAll().anyRequest().authenticated())
	                .oauth2Login().and().logout().logoutSuccessUrl("/login");
	        //http.httpBasic().authenticationDetailsSource(hs -> hs.getAttributeNames().asIterator().next().toString());	
	    
	 //.httpBasic().authenticationDetailsSource(hs -> hs.getAttributeNames().asIterator().next().toString()).and()
	 }   
	 
	
		
}