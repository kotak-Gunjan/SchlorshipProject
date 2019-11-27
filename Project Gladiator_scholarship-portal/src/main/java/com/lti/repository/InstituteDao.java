package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Institute;
import com.lti.entity.ScholarshipApplication;
import com.lti.entity.Status;
import com.lti.entity.StudentReg;

@Repository
public class InstituteDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public List<StudentReg> fetchStudentByInstituteCode(int i) {

		String ql = "select s from StudentReg as s where s.institute=:inst";
		Query q = entityManager.createQuery(ql);
		q.setParameter("inst", i);
		List<StudentReg> students = q.getResultList();
		return students;
	}

	@Transactional
	public List<Institute> getinsdetail() { 

		String ql = "select i from Institute i";
		Query q = entityManager.createQuery(ql);

		List<Institute> obj = q.getResultList();
		return obj;
	}

	@Transactional
	public Institute readLogin(int instituteCode, String password) {
		Query q = entityManager.createQuery(
				"Select i from Institute i where i.instituteCode=:instituteCode and i.institutePass=:password");
		q.setParameter("instituteCode", instituteCode);
		q.setParameter("password", password);
		Institute institute = (Institute) q.getSingleResult();

		return institute;
	}

	@Transactional
	public List<StudentReg> readApplications(Institute i) // to view student id
															// and name
	{
		int icode = i.getInstituteCode();
		String sql = "Select s from StudentReg s left join fetch s.studentAcademic left join fetch s.studentBankDetails left join fetch s.studentBasicDetails left join fetch s.studentDocumentDetails  where s.institute.instituteCode=:instCode";
		Query query = entityManager.createQuery(sql);
		query.setParameter("instCode", icode);
		List<StudentReg> slist = query.getResultList();
		return slist;
	}

	@Transactional
	public StudentReg readStudentByStudentId(int studentId) {
		String sql = "Select s from StudentReg s left join fetch s.studentAcademic left join fetch s.studentBankDetails left join fetch s.studentBasicDetails left join fetch s.studentDocumentDetails  where s.studentId=:studId";
		Query query = entityManager.createQuery(sql);
		query.setParameter("studId", studentId);
		StudentReg student = (StudentReg) query.getSingleResult();
		return student;
	}

	@Transactional
	public ScholarshipApplication readScholarshipDetails(int studentId) {
		Query q = entityManager.createQuery("select s from ScholarshipApplication s join fetch s.student sr join fetch sr.studentBankDetails b where s.student.studentId = :id");
		q.setParameter("id", studentId);
		ScholarshipApplication app = (ScholarshipApplication) q.getSingleResult();
		return app;
	}
	
	@Transactional
	public void add(ScholarshipApplication scholarshipApplication) {
		entityManager.merge(scholarshipApplication);
	}
	
	@Transactional
	public void approve(int studentId) {
		entityManager
			.createQuery("update ScholarshipApplication s set s.status.statusId = :st where s.student.studentId = :s")
			.setParameter("st", 2)
			.setParameter("s", studentId)
			.executeUpdate();
	}
	
	@Transactional
	public void reject(int studentId) {
		entityManager
			.createQuery("update ScholarshipApplication s set s.status.statusId = :st where s.student.studentId = :s")
			.setParameter("st", 3)
			.setParameter("s", studentId)
			.executeUpdate();
	}



	@Transactional
	public Status readApproveStatus() {

		String ql = "Select s from Status s where s.statusDescription='Approved by Institute'";
		Query q = entityManager.createQuery(ql);
		Status stat = (Status) q.getSingleResult();
		return stat;
	}

	@Transactional
	public Status readRejectStatus() {

		String ql = "Select s from Status s where s.statusDescription='Rejected by Institute'";
		Query q = entityManager.createQuery(ql);
		Status stat = (Status) q.getSingleResult();
		return stat;
	}

}