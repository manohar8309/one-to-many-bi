package com.ty;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveOrder {
	public static void main(String[] args) {
		
		FoodOrder foodOrder=new FoodOrder();
		foodOrder.setName("manu");
		foodOrder.setStatus("cook");
		
		Itom itom=new Itom();
		itom.setName("chicken");
		itom.setQuantity(2);
		itom.setCost(300);
		itom.setFoodOrder(foodOrder);
		
		Itom itom1=new Itom();
		itom1.setName("mutton");
		itom1.setQuantity(1);
		itom1.setCost(450);
		itom1.setFoodOrder(foodOrder);
		
		List<Itom> itoms=new ArrayList<Itom>();
		itoms.add(itom);
		itoms.add(itom1);
		
		foodOrder.setItoms(itoms);
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(foodOrder);
		entityManager.persist(itom);
		entityManager.persist(itom1);
		entityTransaction.commit();
		
		
	}

}
