package com.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entities.Applicant;
import com.entities.Job;
import com.helper.SFRegistry;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			sessionFactory = SFRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			Job job1 = Job.of().jobTitle("Senior Java Developer").company("Oracle India Pvt Ltd")
					.description("Java Specialist with > 8 years").qualification("Masters").experience(8).build();

			session.persist(job1);
			System.out.println("job no : " + job1.getJobNo());

			Job job2 = Job.of().jobTitle("Devops Engineer").company("IBM").description("Devops Engineer with pipelines")
					.qualification("Masters").experience(4).build();

			session.persist(job2);
			System.out.println("job no : " + job2.getJobNo());

			Job job3 = Job.of().jobTitle("Fullstack Java Developer").company("Amazon")
					.description("Fullstack specialist").qualification("Masters").experience(6).build();

			session.persist(job3);
			System.out.println("job no : " + job3.getJobNo());

			Set<Job> andyAppliedJobs = new HashSet<>();
			andyAppliedJobs.add(job1);
			andyAppliedJobs.add(job3);

			Applicant applicant1 = Applicant.of().applicantName("Andy").age(25).gender("Female").experience(9)
					.qualification("Masters").appliedJobs(andyAppliedJobs).build();

			session.persist(applicant1);
			System.out.println("applicant no : " + applicant1.getApplicantNo());

			Set<Job> markAppliedJobs = new HashSet<>();
			markAppliedJobs.add(job2);

			Applicant applicant2 = Applicant.of().applicantName("Mark").age(27).gender("Male").experience(10)
					.qualification("Masters").appliedJobs(markAppliedJobs).build();

			session.persist(applicant2);
			System.out.println("applicant no : " + applicant2.getApplicantNo());

			Applicant applicant = session.get(Applicant.class, 1);
			System.out.println(applicant);

			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
			if (session != null) {
				session.close();
			}
			SFRegistry.closeSessionFactory();
		}
	}
}
