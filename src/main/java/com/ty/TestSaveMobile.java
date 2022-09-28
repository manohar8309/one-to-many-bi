package com.ty;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveMobile {
	public static void main(String[] args) {
		Mobile mobile = new Mobile();
		mobile.setName("nokia");
		mobile.setCost(400);

		Sim sim = new Sim();
		sim.setName("Airtel sim");
		sim.setProvider("Airtel");
		sim.setMobile(mobile);

		Sim sim1 = new Sim();
		sim1.setName("idea sim");
		sim1.setProvider("idea");
		sim1.setMobile(mobile);

		List<Sim> list = new ArrayList<Sim>();
		list.add(sim);
		list.add(sim1);

		mobile.setSims(list);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(mobile);
		entityManager.persist(sim);
		entityManager.persist(sim1);
		entityTransaction.commit();

	}

}
