package com.witty.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.log4j.*;

import com.witty.control.Descomponer;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "Campos_2")
public class CamposModel implements Serializable {
	
	protected int idCampo;
	protected String campo;
	protected String nombre;
	protected String clase;
	protected int longitud;
	protected String valor;
	protected boolean opciones;

	private static Logger log = Logger.getLogger(CamposModel.class);

/*	public abstract String setValorCampo(String tramaAsignar);
	public abstract void setValorCampoMti(String tramaAsignar);
	public abstract String getValorCampo();
	public abstract String getValorCampoMti();
	public abstract TramaModel procesarMensaje(TramaModel tramaEntrada);
	*/
	public CamposModel(){}
	public CamposModel(String campo, String nombre, String descripcion, Boolean variable, int longitud,
			String tipo, String presente) {
		
		this.campo=campo;
		this.nombre = nombre;
		this.longitud = longitud;

	}

//	public CamposModel() {
//
//	}
//
//	public CamposModel(String campo, String nombre, String descripcion, Boolean variable, int longitud,
//			String tipo) {
//		this.nombre = nombre;
//		this.description = descripcion;
//		this.longitud = longitud;
//		this.variable = variable;
//
//
//	}
	
//	public abstract void subFieldToField();
//	public abstract void FieldToSubField();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_Campo")
	public final int getIdCampo() {
		return idCampo;
	}

	public final void setIdCampo(int idCampo) {
		this.idCampo = idCampo;
	}
	

	@Column(name = "nombre")
	public final String getNombre() {
		return nombre;
	}

	public final void setNombre(String nombre) {
		this.nombre = nombre;
	}



	@Column(name = "longitud")
	public final int getLongitud() {
		return longitud;
	}

	public final void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public final String getValor() {
		return valor;
	}

	public final void setValor(String valor) {
		this.valor = valor;
	}

	
//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	protected CamposModel oneCampo;
//	
//	
//	public final CamposModel  getCampo() {
//		return oneCampo;
//	}
//
//	public final void setCampo(CamposModel  campos) {
//		this.oneCampo = campos;
//	}
	
	

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected Collection<CamposModel> campos;
	
	
	public final Collection<CamposModel>  getCampos() {
		return campos;
	}

	public final void setCampos(Collection<CamposModel>  campos) {
		this.campos = campos;
	}

	@Column(name = "campo")
	public final String getCampo() {
		return campo;
	}

	public final void setCampo(String campo) {
		this.campo = campo;
	}
	
    public int campoHexToInt(String hex) {

        return Integer.parseInt(hex.replace("F", ""));

    }
	@Column(name = "clase")
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}

    
    
}
