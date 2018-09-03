package com.witty.entity;

import com.google.gson.annotations.Expose;

public class CamposConexion {
	

	@Expose private int id;
	@Expose private String opcion;
	
	public CamposConexion(int id, String opcion) {
		super();
		this.id = id;
		this.opcion = opcion;
	}
	
	
	
	public String toString() {
		
		return id +"-"+opcion;
		
		
	}
	
	

}
