package com.jpa.dao;

import com.jpa.entities.InsurancePlan;
import com.jpa.helper.EMFRegistry;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class InsurancePlanDao {
	public InsurancePlan getInsurancePlan(int planNo) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		InsurancePlan insurancePlan = null;
		try {
			entityManagerFactory = EMFRegistry.getEmf();
			entityManager = entityManagerFactory.createEntityManager();
			insurancePlan = entityManager.find(InsurancePlan.class, planNo);
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		return insurancePlan;
	}

	public void saveInsurancePlan(InsurancePlan insurancePlan) {
		EntityManagerFactory entityManagerFactory = null;
		EntityTransaction entityTransaction = null;
		EntityManager entityManager = null;
		boolean flag = false;

		try {
			entityManagerFactory = EMFRegistry.getEmf();
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();

			entityManager.persist(insurancePlan);
			flag = true;
		} finally {
			if (entityManager != null) {
				if (entityTransaction != null) {
					if (flag) {
						entityTransaction.commit();
					} else {
						entityTransaction.rollback();
					}
				}
				entityManager.close();
			}
		}
	}

}
