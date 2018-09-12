package com.witty.persistence;

import javax.persistence.EntityManager;

import com.witty.entity.Conexion;
import com.witty.entity.ConfigMessage;

public class ConfigMessagePersistence extends CrudPersistence<ConfigMessage> {

	// @PersistenceContext(unitName="FastPos")
	protected EntityManager em;

	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		// em=JPAUtility.getEntityManager();
		return em;
	}

	@Override
	public Class<Conexion> getEntityClass() {
		// TODO Auto-generated method stub
		return Conexion.class;
	}

	public ConfigMessagePersistence() {
		em = JPAUtility.getEntityManager();

	}

}
