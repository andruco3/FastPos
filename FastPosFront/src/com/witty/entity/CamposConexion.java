package com.witty.entity;

import com.google.gson.annotations.Expose;

public class CamposConexion {
	
	@Expose private int idCampo;
		
	@Expose private String opcion;
	
	@Expose private Conexion conexion;
		
	public CamposConexion(int id, String opcion) {
		super();
		this.idCampo = id;
		this.opcion = opcion;
	}
	
	
	
	
	
	public int getIdCampo() {
		return idCampo;
	}





	public void setIdCampo(int idCampo) {
		this.idCampo = idCampo;
	}





	public String getOpcion() {
		return opcion;
	}





	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}





	public Conexion getConexion() {
		return conexion;
	}





	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}





	public String toString() {
		
		return idCampo +"-"+opcion;
		
		
	}
	
	

}
