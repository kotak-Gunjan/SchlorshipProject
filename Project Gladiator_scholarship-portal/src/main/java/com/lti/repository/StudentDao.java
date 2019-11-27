package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Institute;
import com.lti.entity.Scheme;
import com.lti.entity.ScholarshipApplication;
import com.lti.entity.Status;
import com.lti.entity.StudentReg;

@Repository
public class StudentDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public Long readLogin(String studentEmail, String studentPassword) {
		Query q = entityManager.createQuery(
				"Select count(s) from StudentReg s where s.studentEmail = :studentEmail and s.studentPassword=:password");
		q.setParameter("studentEmail", studentEmail);
		q.setParameter("password", studentPassword);
		Long count = (Long) q.getSingleResult();
		return count;
	}

	@Transactional
	public StudentReg readStudentDetails(String studentEmail) {
		Query q = entityManager.createQuery(
				"Select s from StudentReg s left join fetch s.studentAcademic left join fetch s.studentBankDetails left join fetch s.studentBasicDetails left join fetch s.studentDocumentDetails where s.studentEmail=:studentEmail");
		q.setParameter("studentEmail", studentEmail);
		StudentReg student = (StudentReg) q.getSingleResult();
		return student;
	}
	
	@Transactional
	public ScholarshipApplication readScholarshipDetails(int studentId) {
		Query q = entityManager.createQuery("select s from ScholarshipApplication s where s.student.studentId = :id");
		q.setParameter("id", studentId);
		ScholarshipApplication app = (ScholarshipApplication) q.getSingleResult();
		return app;
	}

	@Transactional
	public List<Scheme> readScheme() {

		String ql = "select s from Scheme s";
		Query q = entityManager.createQuery(ql);
		List<Scheme> obj = q.getResultList();
		return obj;
	}

	@Transactional
	public Status readDefaultStatus() {

		String ql = "Select s from Status s where s.statusDescription='Pending'";
		Query q = entityManager.createQuery(ql);
		Status stat = (Status) q.getSingleResult();
		return stat;
	}

}
