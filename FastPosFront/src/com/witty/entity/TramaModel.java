package com.witty.entity;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class TramaModel implements Serializable {//Solo las bases de datos serializables pueden ser clonadas
	
	
	@Expose protected  int idTrama;
	@Expose protected String nombre;
	 protected String tipo;
	 protected String sense;//Este campo se refiere al sentido de la trama: Entrada, salida o ambas




	
	public final int getIdTrama() {
		return idTrama;
	}
	public final void setIdTrama(int idTrama) {
		this.idTrama = idTrama;
	}
	
	

	protected CamposModel header;
	public final CamposModel getHeader() {
		return header;
	}
	
	public final void setHeader(CamposModel header) {
		this.header = header;
	}
	
	
	
	protected CamposModel mti;
	
	public final CamposModel getMti() {
		return mti;
	}
	public final void setMti(CamposModel mti) {
		this.mti = mti;
	}
	
	public final String getSense() {
		return sense;
	}
	public final void setSense(String sense) {
		this.sense = sense;
	}
	
	public final String getNombre() {
		return nombre;
	}
	public final void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public final String getTipo() {
		return tipo;
	}
	public final void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
//	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "Id_Campo")
//	protected List<CamposModel>  campos;
//	public final List getCampos() {
//		return campos;
//	}
//	public final void setCampos(List campos) {
//		this.campos = campos;
//	}
	
	
	@Expose protected CamposModel  campos;
	
	public final CamposModel getCampos() {
		return campos;
	}
	public final void setCampos(CamposModel campos) {
		this.campos = campos;
	}
	
	
	
//	public TramaModel procesarMensaje(){
//		
//		getCampos().procesarMensaje(this);
//		
//		return new TramaModel();
//		
//		
//		
//	}


	
		

}
