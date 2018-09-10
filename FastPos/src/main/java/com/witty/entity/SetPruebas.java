package com.witty.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "set_pruebas")
public class SetPruebas  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private int casosPruebas;
	private int casosEjecutadas;
	private int casosExitosos;
	private int casosMedio;
	private int casosfallidos;
	private Usuario usuario;
	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private Collection<Casos> casos;
//	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Collection<CasosPrueba> casosPrueba;
	
	private float avance;
	

}
