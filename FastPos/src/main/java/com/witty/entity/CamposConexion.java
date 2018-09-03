package com.witty.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "campos_conexion")
@XmlRootElement
public class CamposConexion {
	
	@Id
	private int id;

	
	@Column(name = "opcion")
	private String opcion;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name = "casoPrueba", insertable=false, updatable=false)
	private CasosPrueba casoPrueba;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getOpcion() {
		return opcion;
	}


	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}


	public CasosPrueba getCasoPrueba() {
		return casoPrueba;
	}


	public void setCasoPrueba(CasosPrueba casoPrueba) {
		this.casoPrueba = casoPrueba;
	}
	
	
	
	
	

}
