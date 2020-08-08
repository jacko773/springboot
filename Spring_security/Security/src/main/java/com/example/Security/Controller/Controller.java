package com.example.Security.Controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("security")
public class Controller {

	@Secured("ROLE_USER")
	@RequestMapping("get")
	public String get() {
		return "vinay";
	} 
	
	@Secured("ROLE_ADMIN")
	@RequestMapping("get1")
	public String getAdmin() {
		return "vinay";
	} 
	
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@RequestMapping("get2")
	public String getBOTH() {
		return "vinay";
	} 
}
