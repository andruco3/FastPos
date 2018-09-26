package com.witty.persistence;

import javax.persistence.EntityManager;

import com.witty.entity.CamposModel;
import com.witty.entity.Conexion;
import com.witty.entity.TramaModel;

public class CamposModelPersistence extends CrudPersistence<CamposModel> {

	// @PersistenceContext(unitName="FastPos")
	protected EntityManager em;

	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		// em=JPAUtility.getEntityManager();
		return em;
	}

	public Class<CamposModel> getEntityClass() {
		// TODO Auto-generated method stub
		return CamposModel.class;
	}

	public CamposModelPersistence() {
		em = JPAUtility.getEntityManager();

	}

}
