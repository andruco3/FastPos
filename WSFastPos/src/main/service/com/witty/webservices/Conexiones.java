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

import org.json.JSONObject;

import com.google.gson.Gson;

import com.witty.entity.CamposConexion;
import com.witty.entity.Conexion;
import com.witty.persistence.ConexionController;
import com.witty.persistence.JPAUtility;


@Path("/conections")
public class Conexiones {

	public ConexionController persistence=new ConexionController();
	
	
   	@POST
	@Path("/getConectionService")
   	@Produces(MediaType.APPLICATION_JSON)
	public List<Conexion> getConections(InputStream incomingData) {
		
   		List<Conexion> listaConexion= persistence.findAll();
   		String json = new Gson().toJson(listaConexion );
		return listaConexion;
	}
	
	
	@POST
	@Path("/putConectionService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setConections(Conexion conexion) {		
		
		System.out.print("Ingrese al Pos Conection");
		
//		persistence.getEntityManager().getTransaction().begin();
//		persistence.getEntityManager().persist(conexion);
//		persistence.getEntityManager().getTransaction().commit();
//		persistence.getEntityManager().close();
		persistence.create(conexion);
		persistence.createServerProcess(conexion.getId());
 		return Response.status(200).entity("Conexion Exitosa").build();
	}
	
	@GET
	@Path("/stateConectionService")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getEstadoConexion(InputStream incomingData) {
		String result = "CrunchifyRESTService Successfully started..";
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(result).build();
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
	
	@GET
	@Path("/deleteConectionService")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteConection(InputStream incomingData) {
		String result = "CrunchifyRESTService Successfully started..";
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(result).build();
	}
	

}
