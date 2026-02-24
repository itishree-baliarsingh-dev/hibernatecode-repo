package com.test;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entities.Project;
import com.entities.Task;
import com.helper.SFRegistry;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		Project project = null;
		Task task = null;

		try {
			sessionFactory = SFRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			project = Project.of().title("Health Services").estimatedDuration(32).startedDate(LocalDate.now())
					.clientName("Athena").build();

			session.persist(project);

			System.out.println("project no : " + project.getProjectNo());

			task = Task.of().taskName("Login Module").storyPoints(5).assignedTo("Jim").project(project).build();

			session.persist(task);

			System.out.println("task no  :" + task.getTaskNo());

			task = session.get(Task.class, 1);
			System.out.println(task);

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
