package com.witty.persistence;

import javax.persistence.EntityManager;

import com.witty.entity.Casos;


public class CasosPersistence extends CrudPersistence<Casos>{

    protected EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<Casos> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

}
