package com.ty;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetMobileById {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Mobile mobile = entityManager.find(Mobile.class, 2);

		System.out.println("----details of mobile-----");
		System.out.println("id=" + mobile.getId());
		System.out.println("name=" + mobile.getName());
		System.out.println("cost=" + mobile.getCost());
		System.out.println("++++++++++++++++++++++++++++++++++++");
		List<Sim> list = mobile.getSims();
		if (list != null) {
			System.out.println("-----sims-----");
			for (Sim sim : list) {
				System.out.println("id=" + sim.getId());
				System.out.println("name=" + sim.getName());
				System.out.println("provider=" + sim.getProvider());
				System.out.println("=========================================");
			}

		}

	}

}
