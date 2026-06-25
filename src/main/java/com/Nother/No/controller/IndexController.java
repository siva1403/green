package com.Nother.No.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

import org.springframework.security.oauth2.core.oidc.user.*;

@Controller
public class IndexController {
 
  @GetMapping(value="/")
  public String getIndexPage(Model model, Authentication authentication) {
	  System.out.println("Helo");
	  
    if (authentication != null && authentication.isAuthenticated()) {
    	  this.getUser();
    	  model.addAttribute(authentication);
    	  model.addAttribute("Name",authentication.getName());
      if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
        model.addAttribute("secretMessage", "Admin message is s3crEt");
      } else {
        model.addAttribute("secretMessage", "Lorem ipsum dolor sit amet");
      }
     
      return "index";
    }
    
    else {
    model.addAttribute("message", "AWS Cognito with Spring Security");
    return "index";
    }
}
  
  
  @PostMapping(value="/invalidate")
  public String logout(@ModelAttribute HttpServletRequest request,@ModelAttribute Authentication authentication) {
	  System.out.println("logout method");
	  if(authentication.isAuthenticated()) {
		  if(request!=null&&request.getSession()!=null) {
			  request.getSession().invalidate();
			  return "login";
		  }
	  }
	  return "index";
  }
  
  public void getUser() {
	  Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 Object authentication = SecurityContextHolder.getContext().getAuthentication().getCredentials();
	  if (principal instanceof UserDetails) {
	    String username = ((UserDetails)principal).getUsername();
	  String password =  ((UserDetails)principal).getPassword();
	  System.out.println(username + " : " + password);
	    
	  } else {
		  DefaultOidcUser p=((DefaultOidcUser)principal);
		  System.out.println(p.getName());
		  System.out.println(p.getAccessTokenHash());
	  //  System.out.println(p.getIdToken().getAccessTokenHash());
	   // System.out.println(p.getAuthorizationCodeHash());
	   
	  }
  }
}
