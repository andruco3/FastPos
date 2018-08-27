package com.witty.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.IdClass;


  public class ConexionesCasosPk implements Serializable{
	
	

	private int idCasosPrueba;
	
	private int idConexiones;
	

	
	public int getIdcasos() {
		return idConexiones;
	}
	public void setIdConexiones(int idConexiones) {
		this.idConexiones = idConexiones;
	}
	public int getIdConexiones() {
		return idCasosPrueba;
	}
	public void setIdCasoPrueba(int idCasoPrueba) {
		this.idCasosPrueba = idCasoPrueba;
	}
	
	
	
	 @Override
	public int hashCode(){
		
		return super.hashCode();
		
	}
	
	 @Override
	public boolean equals(Object o){
		
		return true;
		
	}
	
	
	
	
	
	
	
}