package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lti.entity.Institute;
import com.lti.entity.Ministry;
import com.lti.service.MinistryService;

@Controller
@SessionAttributes("minister")
public class MinistryController {
	
	@Autowired
	MinistryService ministryService;
	
	
	@RequestMapping(path="ministrylogin.lti",method=RequestMethod.POST)
	public String instituteLogin(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			ModelMap model){
		
		try{
			
			 Ministry ministry=ministryService.checkLogin(username, password);
			 model.put("ministry", ministry);
			 return "ministryhome.jsp";

		}
		catch (Exception e){
			
			model.put("message", "Invalid code/password");
			return "ministrylogin.jsp";	
		}
}
}
