package com.witty.model.conexion;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "conexiones_activas")
public class ConexionesActivas {
	
	private int idConexion;
	private String nombreConexion;
	private String ip;
	private String puerto;
	private String proceso;

	
	
}
