package com.witty.webservices;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceUnit;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.iso.ISOPackager;
import org.jpos.util.LogSource;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.witty.entity.CamposConexion;
import com.witty.entity.Conexion;
import com.witty.persistence.ConexionController;
import com.witty.persistence.JPAUtility;
import com.witty.server.RestListener;

@Stateless
@Path("/conections")
public class Conexiones extends RestListener implements LogSource, Configurable {
	public Conexiones(ISOPackager packager) {
		super(packager);
	}

	public ConexionController persistence;
	
	
   	@GET
	@Path("/getConectionsService")
   	@Produces(MediaType.APPLICATION_JSON)
	public String getConections() {
   		System.out.print("Soy un error");
   		persistence=new ConexionController();
   		System.out.print("Soy un error2");
   		List<Conexion> listaConexion= persistence.findAll();
   		System.out.print("Soy un error "+listaConexion.get(0).getNombreConexion() );
		Gson gson =  new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
   		String json = gson.toJson(listaConexion );
   		System.out.print("Soy un error 88"+json );
		return json;
	}
	
	
	@POST
	@Path("/putConectionService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setConections(Conexion conexion) {
		persistence=new ConexionController();
		
		for(CamposConexion coll:conexion.getCamposConexion()) {
			coll.setIdConexion(conexion);
			
		}
		
		persistence.create(conexion);
		persistence.createServerProcess(conexion);
 		return Response.status(200).entity("Conexion Exitosa").build();
	}
	
	@GET
	@Path("/getConectionService")
	@Produces(MediaType.TEXT_PLAIN)
	public Conexion getConection(String data) {
		JSONObject recoData = new JSONObject(data);
		
		Conexion conexion = persistence.find(recoData.getLong("id"));
		// return HTTP response 200 in case of success
		return conexion;
	}
	

	
	@GET
	@Path("/sendCommandService")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response sendCommand(String data) {
		JSONObject recoData = new JSONObject(data);
	
 
		persistence.commandConexion(recoData.getInt("command"),recoData.getLong("id") );
		// return HTTP response 200 in case of success
		return Response.status(200).entity("ok").build();
	}
	
	@POST
	@Path("/deleteConectionService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteConection(String data) {
		persistence=new ConexionController();
		JSONObject recoData = new JSONObject(data);
		
		System.out.print("ide" + recoData.getLong("id"));
		persistence.deleteServerProcess(recoData.getLong("id"));
		// return HTTP response 200 in case of success
		return Response.status(200).entity("Ok").build();
	}


	public void setConfiguration(Configuration cfg) throws ConfigurationException {
		// TODO Auto-generated method stub
		
	}
	

}
