package com.witty.model.conexion;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "llaves")
public class Llaves {
	
	private int idLlaves;
	private String idProceso;

	
	
	

}
