package com.witty.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



@Entity
@Access(AccessType.PROPERTY)
@Table(name = "Tramas")
public class TramaModel implements Serializable {//Solo las bases de datos serializables pueden ser clonadas
	
	
	protected  int idTrama;
	protected String nombre;
	protected String tipo;
	protected String sense;//Este campo se refiere al sentido de la trama: Entrada, salida o ambas




	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_Tramas")
	public final int getIdTrama() {
		return idTrama;
	}
	public final void setIdTrama(int idTrama) {
		this.idTrama = idTrama;
	}
	
	

	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
	protected CamposModel header;
	public final CamposModel getHeader() {
		return header;
	}
	
	public final void setHeader(CamposModel header) {
		this.header = header;
	}
	
	
	
	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
    protected CamposModel mti;
	
	public final CamposModel getMti() {
		return mti;
	}
	public final void setMti(CamposModel mti) {
		this.mti = mti;
	}
	
	@Column(name = "sense")
	public final String getSense() {
		return sense;
	}
	public final void setSense(String sense) {
		this.sense = sense;
	}
	
	@Column(name = "nombre")
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
	
	
	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
	protected CamposModel  campos;
	
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
