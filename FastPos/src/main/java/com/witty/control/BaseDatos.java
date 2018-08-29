/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.witty.control;

import java.util.List;
import javafx.collections.ObservableList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.witty.entity.CamposModel;
import com.witty.entity.TramaModel;



/**
 *
 * @author root
 */

public class BaseDatos {
	private static volatile BaseDatos instance = new BaseDatos();

	private static final String PERSISTENCE_UNIT_NAME = "FastPos";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	private static EntityManager em = factory.createEntityManager();

	public static List<CamposModel> leerTodaBD() {
		if (!em.isOpen())
			abrirConexion();
		Query q = em.createQuery("select t from CamposModel t");
		List<CamposModel> tramaModelM = q.getResultList();
		// System.out.print("CAsa" + tramaModelM.get(0).getNombre());
		return tramaModelM;
	};

	public static List<String> leerCampoCondBD(String campoR, String campoW, String condicion) {
		if (!em.isOpen())
			abrirConexion();
		Query q = em
				.createQuery("select t." + campoR + " from CamposModel t WHERE t." + campoW + "='" + condicion + "'");
		List<String> tramaModelM = q.getResultList();
		// System.out.print("CAsa" + tramaModelM.get(0).getNombre());

		return tramaModelM;

	};

	public static List<CamposModel> leerBDWhere(String campo, String condicion) {

		if (!em.isOpen())
			abrirConexion();
		Query q = em.createQuery("select t from CamposModel t WHERE t." + campo + "='" + condicion + "'");
		List<CamposModel> tramaModelM = q.getResultList();
		// System.out.print("CAsa" + tramaModelM.get(0).getNombre());
		return tramaModelM;

	};

	public static List<TramaModel> leerBDTramaWhere(String campo, String condicion) {

		if (!em.isOpen())
			abrirConexion();
		Query q = em.createQuery("select t from TramaModel t WHERE t." + campo + "='" + condicion + "'");
		List<TramaModel> tramaModelM = q.getResultList();
		// System.out.print("CAsa" + tramaModelM.get(0).getNombre());
		return tramaModelM;

	};

	public static void guardarBD(List<CamposModel> caposGuardar) {

		// ((CamposTramaModel)tramas.get(0).getCampos().get(0)).setDescripcion("cambio5a");
		// em.getTransaction().begin();
		// if(!em.isOpen())
		em.getTransaction().begin();
		em.persist(caposGuardar.get(0));
		em.getTransaction().commit();

	}


	public static void guardarBDCampo(CamposModel caposGuardar) {

		// ((CamposTramaModel)tramas.get(0).getCampos().get(0)).setDescripcion("cambio5a");
		// em.getTransaction().begin();
		// if(!em.isOpen())
		if (!em.isOpen() || !em.getTransaction().isActive())
			abrirConexion();
		em.persist(caposGuardar);
		em.getTransaction().commit();

	}
	
	public static void guardarBDTrama(TramaModel tramaGuardar) {

		// ((CamposTramaModel)tramas.get(0).getCampos().get(0)).setDescripcion("cambio5a");
		// em.getTransaction().begin();
		// if(!em.isOpen())
		if (!em.isOpen() || !em.getTransaction().isActive())
			abrirConexion();
		em.persist(tramaGuardar);
		em.getTransaction().commit();

	}

	public static void borrarBD(CamposModel caposGuardar) {

		// ((CamposTramaModel)tramas.get(0).getCampos().get(0)).setDescripcion("cambio5a");
		// if(!em.isOpen())
		em.getTransaction().begin();
		em.remove(caposGuardar);
		em.getTransaction().commit();

	}

	public static void abrirConexion() {

		// ((CamposTramaModel)tramas.get(0).getCampos().get(0)).setDescripcion("cambio5a");
		// if(!em.isOpen())
		em.getTransaction().begin();

	}

	public static void cerrarConexion() {

		// ((CamposTramaModel)tramas.get(0).getCampos().get(0)).setDescripcion("cambio5a");
		// if(!em.isOpen())
		em.close();
	}

	public static BaseDatos getInstance() {
		return instance;
	}

}
