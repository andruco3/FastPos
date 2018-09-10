package com.witty.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.MapsId;


@Entity
@Table(name = "conexiones_casos")
@IdClass(com.witty.entity.ConexionesCasosPk.class)
public class ConexionesCasos implements Serializable{
	

	
	@Id
	private int idCasosPrueba;
		
	@Id
	private int idConexiones;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name = "idCasosPrueba", insertable=false, updatable=false)
	private CasosPrueba casoPrueba;
	
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name = "idConexiones", insertable=false, updatable=false)
	private Conexion conexion;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Collection<TramaModel> tramas_caso;
	
	public ConexionesCasos(){};
	
	public ConexionesCasos(CasosPrueba casoPrueba){
		
		this.idCasosPrueba=casoPrueba.getId();
		this.casoPrueba=casoPrueba;
		
	}
	
	
	
	public int getIdConexiones() {
		return idConexiones;
	}

	public void setIdConexiones(int idConexiones) {
		this.idConexiones = idConexiones;
	}
	


	
	public int getIdCasoPrueba() {
		return idCasosPrueba;
	}

	public void setIdCasoPrueba(int idCasoPrueba) {
		this.idCasosPrueba = idCasoPrueba;
	}



	
	



	


	
	//@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "Id_Tramas")
	//private Collection<TramaModel> pruebas;
	

	
	
	
	

}
