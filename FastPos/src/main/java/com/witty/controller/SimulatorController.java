package com.witty.controller;

import javax.persistence.EntityManager;

import org.jpos.q2.iso.QMUX;
import org.jpos.util.NameRegistrar;

import com.witty.entity.CasosPrueba;
import com.witty.entity.Conexion;
import com.witty.persistence.CasosPersistence;
import com.witty.persistence.ConectionPersistence;
import com.witty.persistence.ConfigMessagePersistence;
import com.witty.persistence.CrudPersistence;
import com.witty.persistence.JPAUtility;

public class SimulatorController {

	public CasosPersistence persistenceCasosPrueba;

	public SimulatorController() {

		persistenceCasosPrueba = new CasosPersistence();
	}

	public CasosPersistence getPersistenceCasos() {
		return new CasosPersistence();

	}
}
