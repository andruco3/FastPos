package com.witty.persistence;

import javax.persistence.EntityManager;

import com.witty.entity.Conexion;
import com.witty.entity.TramaModel;

public class TramaModelPersistence extends CrudPersistence<TramaModel> {

	// @PersistenceContext(unitName="FastPos")
	protected EntityManager em;

	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		// em=JPAUtility.getEntityManager();
		return em;
	}

	public Class<TramaModel> getEntityClass() {
		// TODO Auto-generated method stub
		return TramaModel.class;
	}

	public TramaModelPersistence() {
		em = JPAUtility.getEntityManager();

	}

}
