package com.witty.persistence;

import javax.persistence.EntityManager;

import com.witty.entity.CasosPrueba;


public class CasosPersistence extends CrudPersistence<CasosPrueba>{

	
    protected EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

	@Override
	protected Class<CasosPrueba> getEntityClass() {
		// TODO Auto-generated method stub
		return CasosPrueba.class;
	}
	
	public CasosPersistence() {
		em = JPAUtility.getEntityManager();

	}
	
	
	

}
