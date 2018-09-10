package com.witty.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class JPAUtility {
 	private static EntityManagerFactory emFactory;
 	private static final String PERSISTENCE_UNIT_NAME = "FastPos";
	static {
		   emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}
	public static EntityManager getEntityManager(){
		emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		return emFactory.createEntityManager();
	}
	public static void close(){
		emFactory.close();
	}
} 