package com.witty.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.witty.entity.Conexion;

public class ConexionPersistence extends CrudPersistence<Conexion>{

    //@PersistenceContext(unitName="FastPos")
    protected EntityManager em;
	
	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

	@Override
	public Class<Conexion> getEntityClass() {
		// TODO Auto-generated method stub
		return Conexion.class;
	}
	
	
	 public ConexionPersistence() {
		em=JPAUtility.getEntityManager();

	 }

	
	
//	
//    public static ConexionPersistence getConexion() {
//        if (conexionMe == null){
//        	conexionMe = new ConexionPersistence();
//        }
//       
//        return conexionMe;
//    }
	
	

}
