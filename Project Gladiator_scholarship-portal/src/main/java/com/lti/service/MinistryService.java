package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Ministry;
import com.lti.repository.MinistryDao;


@Service
public class MinistryService {

	
	@Autowired
	private MinistryDao ministryDao;
	
	public Ministry checkLogin(String username, String password) {
		
		 Ministry ministry=ministryDao.readLogin(username, password);
		return ministry;

	}
}
