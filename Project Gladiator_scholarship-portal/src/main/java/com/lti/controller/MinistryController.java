package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lti.entity.Institute;
import com.lti.entity.Ministry;
import com.lti.entity.StudentReg;
import com.lti.service.MinistryService;

@Controller
@SessionAttributes("minister")
public class MinistryController {
	
	@Autowired
	private MinistryService ministryService;
	
	
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
	
	@RequestMapping(path="view1.lti", method=RequestMethod.GET)
	public String viewApplications(ModelMap model)
	{
		Ministry m=(Ministry) model.get("ministry");
		List<StudentReg> mlist=ministryService.viewApplicationsService(m);
		model.addAttribute("mlist", mlist);
		return "viewApplicationMinistry.jsp";
	}
	
	
	@RequestMapping(path="viewStudentDetailsMin.lti",method=RequestMethod.GET)
	public String viewFullDetails(@RequestParam("studentId") int studentId,Model model){
		
		StudentReg studentReg = ministryService.findStudentByStudentId(studentId);
		
		model.addAttribute("student", studentReg);
		return "fulldetailsFormMinistry.jsp";
	}
}
