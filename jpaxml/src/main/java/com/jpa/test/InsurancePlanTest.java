package com.jpa.test;

import com.jpa.dao.InsurancePlanDao;
import com.jpa.entities.InsurancePlan;
import com.jpa.helper.EMFRegistry;

public class InsurancePlanTest {

	public static void main(String[] args) {
		try {
			InsurancePlanDao dao = new InsurancePlanDao();
			InsurancePlan insurancePlan = dao.getInsurancePlan(101);
			System.out.println(insurancePlan);
//			InsurancePlan insurancePlan = new InsurancePlan();
//			insurancePlan.setPlanNo(1002);
//			insurancePlan.setPlanName("Retirement Plan");
//			insurancePlan.setPlanType("Retirement Benefits");
//			insurancePlan.setMinAge(5);
//			insurancePlan.setMinTenure(36);
//			insurancePlan.setMinInsurredAmount(50000);
//			insurancePlan.setMaturityBonusPercentage(10);
//
//			dao.saveInsurancePlan(insurancePlan);

		} finally {
			EMFRegistry.closeEmf();
		}

	}

}
