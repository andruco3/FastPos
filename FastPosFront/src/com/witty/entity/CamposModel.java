package com.witty.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;


public class CamposModel extends RecursiveTreeObject<CamposModel> implements Serializable  {
	
	protected int idCampo;
	protected String nCampo;
	protected String nombre;
	protected String clase;
	protected int longitud;
	protected String valor;
	protected boolean opciones;


	public CamposModel(){}

}
