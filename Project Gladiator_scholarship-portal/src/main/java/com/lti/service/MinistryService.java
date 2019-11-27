package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Institute;
import com.lti.entity.Ministry;
import com.lti.entity.StudentReg;
import com.lti.repository.MinistryDao;


@Service
public class MinistryService {

	
	@Autowired
	private MinistryDao ministryDao;
	
	public Ministry checkLogin(String username, String password) {
		
		 Ministry ministry=ministryDao.readLogin(username, password);
		return ministry;

	}
	public List <StudentReg> viewApplicationsService(Ministry m)
	{
		List<StudentReg> mlist = ministryDao.readApplications1(m);
		return mlist;
	}
	
	public StudentReg findStudentByStudentId(int studentId){
		return ministryDao.readStudentByStudentId(studentId);
	}

}
