package com.test;

import java.util.HashSet;
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

			player1 = new Player();
			player1.setPlayerName("VK");
			player1.setAge(27);
			player1.setGender("Male");
			player1.setEmailAddress("vk@gmail.com");
			player1.setHeight(6);
			player1.setMobileNo("98764567");
			player1.setWeight(70);
			player1.setSportType("cricket");
			session.persist(player1);

			player2 = new Player();
			player2.setPlayerName("GG");
			player2.setAge(31);
			player2.setGender("Male");
			player2.setMobileNo("65432456");
			player2.setEmailAddress("gg@gmail.com");
			player2.setHeight(5);
			player2.setWeight(76);
			player2.setSportType("cricket");
			session.persist(player2);

			players = new HashSet<>();
			players.add(player1);
			players.add(player2);

			coach = new Coach();
			coach.setCoachName("Rahul Dravid");
			coach.setAge(38);
			coach.setGender("Male");
			coach.setExperience(20);
			coach.setMobileNo("93874948");
			coach.setEmailAddress("rahul@gmail.com");
			coach.setPlayers(players);

			session.persist(coach);

			coach = session.get(Coach.class, 1);
			System.out.println("coach name : " + coach.getCoachName());

			players = coach.getPlayers();
			players.forEach(System.out::println);

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
