package com.test;

import com.entities.Account;
import com.entities.AccountPK;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AccountTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction et = null;
		boolean flag = false;

		try {
			emf = Persistence.createEntityManagerFactory("jpa4");
			em = emf.createEntityManager();
			et = em.getTransaction();
			et.begin();

			AccountPK pk = new AccountPK();
			pk.setAccountNumber("12346734233");
			pk.setIfscCode("SBI01367");

			Account account = em.find(Account.class, pk);
			System.out.println(account);

			flag = true;
		} finally {
			if (et != null) {
				if (flag) {
					et.commit();
				} else {
					et.rollback();
				}
			}
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}
	}
}
