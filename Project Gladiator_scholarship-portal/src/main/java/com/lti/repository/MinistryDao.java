package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Institute;
import com.lti.entity.Ministry;
import com.lti.entity.StudentReg;

@Repository
public class MinistryDao {
		
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public Ministry readLogin(String username, String password){
		Query q = entityManager.createQuery("Select m from Ministry m where m.userName=:username and m.password=:password");
		q.setParameter("username", username);
		q.setParameter("password", password);
		Ministry ministry = (Ministry) q.getSingleResult();
		
		return ministry;
		
		
		
	}
	
	@Transactional
	public List<StudentReg> readApplications1(Ministry m) //to view student id and name 
	{
		String mcode= m.getUserName();
		String sql="select s from StudentReg s inner join fetch s.scholarshipApplication sa where sa.status.statusId=:'2' " ;
		Query query=entityManager.createQuery(sql);
		query.setParameter("instCode", mcode);  
		List<StudentReg> mlist = query.getResultList();
		return mlist; 
	}
	

	public StudentReg readStudentByStudentId(int studentId){
		String sql="Select s from StudentReg s left join fetch s.studentAcademic left join fetch s.studentBankDetails left join fetch s.studentBasicDetails left join fetch s.studentDocumentDetails  where (s.studentId=:studId AND s.ScholarshipApplication.status=2)";
		Query query=entityManager.createQuery(sql);
		query.setParameter("studId", studentId);
		StudentReg student = (StudentReg) query.getSingleResult();
		
		//StudentReg studentReg = entityManager.find(StudentReg.class, studentId);
		return student;
	}
}
