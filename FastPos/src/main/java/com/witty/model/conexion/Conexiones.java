package com.witty.model.conexion;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "conexiones_cnf")
public class Conexiones {
	
	private int idPoceso;
	private int nombreProceso;
	private String timeInbound;
	private String timeOutbound;
	private String tipoConexion;
	private String header;
	private String rol;

	

}
