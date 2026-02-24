package com.test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entities.Project;
import com.entities.Vendor;
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

			Project project = new Project();
			project.setDescription("Road contract");
			project.setWorkType("civil");
			project.setEstimatedDays(2);
			project.setEstimatedAmount(100000);
			session.persist(project);
			System.out.println("project no : " + project.getProjectNo());

			Project project2 = new Project();
			project2.setDescription("LED Lighting");
			project2.setWorkType("civil");
			project2.setEstimatedDays(25);
			project2.setEstimatedAmount(2500000);
			session.persist(project2);
			System.out.println("project no : " + project2.getProjectNo());

			Map<String, Project> allocatedProjects = new HashMap<>();
			allocatedProjects.put("C001", project2);
			allocatedProjects.put("C00028", project);

			Vendor vendor = new Vendor();
			vendor.setVendorName("L&T");
			vendor.setContactNo("93847944");
			vendor.setEmailAddress("contactus@lt.com");
			vendor.setEstablishedDate(LocalDate.now());

			vendor.setAllocatedProjects(allocatedProjects);
			session.persist(vendor);

			System.out.println("vendor no : " + vendor.getVendorNo());

			Vendor vendor2 = session.get(Vendor.class, 2);
			Map<String, Project> allocatedProjects2 = vendor2.getAllocatedProjects();
			Project project3 = allocatedProjects2.get("C001");
			System.out.println(project3);

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
