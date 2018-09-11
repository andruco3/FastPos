package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.witty.entity.CamposConexion;
import com.witty.entity.CamposModel;
import com.witty.entity.Conexion;
import com.witty.persistence.ConexionController;



public class Main2 {

	private static final String PERSISTENCE_UNIT_NAME = "FastPos";
	private static EntityManagerFactory factory;

	public static void main(String[] args) {

		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		System.out.println (System.getProperty("user.dir"));
		System.out.println (System.getProperty("user.dir")+System.getProperty("file.separator")+"deploy"+System.getProperty("file.separator"));
		CamposConexion campos=new CamposConexion();
		campos.setIdCampo(25);
		campos.setOpcion("K");
		
		CamposConexion campos1=new CamposConexion();
		campos1.setIdCampo(30);
		campos1.setOpcion("K");
		
		Collection<CamposConexion> campio= new ArrayList<CamposConexion>();
		
		
		Conexion xonection=new Conexion();
		xonection.setDireccionIp("321654");
		xonection.setMessage("321654");
		xonection.setPuerto("321654");
		xonection.setNombreConexion("321654");
		xonection.setTipo("MasterCard");
		campos.setIdConexion(xonection);
		campos1.setIdConexion(xonection);
		campio.add(campos);
		campio.add(campos1);
		
		xonection.setCamposConexion(campio);
		
		
		em.getTransaction().begin();
		em.persist(xonection);
		em.getTransaction().commit();
		em.close();
		

//		em.getTransaction().begin();
//		em.remove(xonection);
//		em.getTransaction().commit();
//		em.close();
		
	//	miscelanea.Miscelanea.cargarArchivoMasters("");
//		miscelanea.Miscelanea.cargarArchivoMasters("810");

		// TramaModel tramaP=new TramaModel();
		// CamposModel trama = new CamposBase24();
		// trama.setNombre("Tramita2");
		// trama.setDescription("Trama Go");
		// CamposModel campTra = new CamposBase24();
		// campTra.setNombre("Casa25");
		// campTra.setDescription("Primer Campos");
		// campTra.setVariable(true);
		// campTra.setCampos(null);
		// List<CamposModel> campos = new ArrayList<>();
		// campos.add(campTra);
		// CamposModel campTra2 = new CamposModel();
		// campTra2.setNombre("Renuion");
		// campTra2.setDescription("resultado Des");
		// campTra2.setCampos(campos);
		// campTra2.setVariable(true);
		// List<CamposModel> _campos2 = new ArrayList<>();
		// _campos2.add(campTra2);

		// em.persist(campTra);
		// em.persist(trama);
		// em.getTransaction().commit();
		//
		// tramaP.setHeader(trama);
		// tramaP.setMti(campTra);
		//
		// em.getTransaction().begin();
		// em.persist(tramaP);
		// em.getTransaction().commit();
		// read the existing entries and write to console
		// Query q = em.createQuery("select t from CamposTramaModel t");
		// List<CamposModel> tramaModelM = q.getResultList();
		// for (CamposTramaModel todo : tramaModelM) {
		// for(int x=0;x<todo.getCampos().size();x++)
		// System.out.println("campos: " +
		// ((CamposTramaModel)tramaModelM.get(1).getCampos().get(0)).getNombre());

		// }
		// System.out.println("Size: " + tramaModelM.size());

		/*
		 * List<CamposTramaModel> _campos = new ArrayList<>();
		 * 
		 * 
		 * _campos.add(campTra); CamposTramaModel campTra2 = new
		 * CamposTramaModel(); campTra2.setNombre("Casa");
		 * campTra2.setDescripcion("Primer Campo"); _campos.add(campTra2);
		 * trama.setCampos(_campos);
		 */

		// read the existing entries and write to console
/*		Query q = em.createQuery("select t from CamposModel t");
		List<CamposModel> tramaModelM = q.getResultList();
		for (CamposModel todo : tramaModelM) {
			System.out.println("\n campos5: " + ((CamposModel)todo.getCampos().get(90)).getNombre());
			//if (todo.getNombre().contains("MasterCard"))
				// for(int x=0;x<todo.getCampos().size();x++)
				//System.out.println("\n campos: " + ((CamposModel)todo.getCampos().get(5)).getNombre());

		}
		System.out.println("Size: " + tramaModelM.size());
*/
		/*
		 * /* // create new todo em.getTransaction().begin(); Todo todo = new
		 * Todo(); todo.setSummary("This is a test");
		 * todo.setDescription("This is a test"); em.persist(todo);
		 * em.getTransaction().commit();
		 * 
		 * em.close();
		 */

	}
}
