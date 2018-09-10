package com.witty.persistence;

import javax.persistence.EntityManager;

import org.jpos.q2.iso.QMUX;
import org.jpos.util.NameRegistrar;

import com.witty.entity.CasosPrueba;
import com.witty.entity.Conexion;

public class SimulatorPersistence extends CrudPersistence<CasosPrueba>{
	
	

    //@PersistenceContext(unitName="FastPos")
    protected EntityManager em;
	
	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

	@Override
	public Class<CasosPrueba> getEntityClass() {
		// TODO Auto-generated method stub
		return CasosPrueba.class;
	}
	
	
	 public SimulatorPersistence() {
		em=JPAUtility.getEntityManager();

	 }
	 
	 
	 public void commandSimulator(int command, long id) {
	 	 
		 System.out.print("eror");
		 try {
	            //QServer mux = (QServer) NameRegistrar.get("HostQServer501");
	            final QMUX mux = (QMUX) NameRegistrar.get("mux.host-mux-1");
	            switch (command) {
	            case 1:
	            	mux.startService(); break;
	            case 2:
	            	mux.stopService(); break;
	            case 3:
	            	mux.stopService(); break;
	            }
	            
	            mux.stopService();
	        } catch (NameRegistrar.NotFoundException e) {
	        	 System.out.print((e.toString()));
	            
	        }
		  
		 
		 
	 }	

	

}
