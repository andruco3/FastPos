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
@Table(name = "proyecto")
public class Proyecto  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String fechaInicio;
	private String fechaFin;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Collection<SetPruebas> setPruebas;
	
	
	

}
