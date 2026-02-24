package com.test;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entities.Coach;
import com.entities.Player;
import com.helper.SFRegistry;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		Coach coach = null;
		Player player1 = null;
		Player player2 = null;
		Set<Player> players = null;

		try {
			sessionFactory = SFRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			coach = new Coach();
			coach.setCoachName("Rahul Dravid");
			coach.setAge(38);
			coach.setGender("Male");
			coach.setExperience(20);
			coach.setMobileNo("93874948");
			coach.setEmailAddress("rahul@gmail.com");
			session.persist(coach);

			player1 = new Player();
			player1.setPlayerName("iti");
			player1.setAge(25);
			player1.setGender("Female");
			player1.setMobileNo("984567899");
			player1.setEmailAddress("iti@gmail.com");
			player1.setWeight(50);
			player1.setHeight(5);
			player1.setSportType("Cricket");

			player1.setCoach(coach);
			session.persist(player1);

			coach = session.get(Coach.class, 1);

			player2 = new Player();
			player2.setPlayerName("shree");
			player2.setAge(27);
			player2.setGender("Female");
			player2.setMobileNo("43456788");
			player2.setEmailAddress("shree@gmail.com");
			player2.setWeight(45);
			player2.setHeight(5);
			player2.setSportType("Cricket");

//			coach.getPlayers().add(player2);
//			session.merge(coach);
//
//			coach = session.get(Coach.class, 1);
//			session.remove(coach);

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
