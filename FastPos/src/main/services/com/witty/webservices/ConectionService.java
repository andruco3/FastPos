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
import com.google.gson.JsonObject;
import com.witty.controller.ConexionController;
import com.witty.entity.CamposConexion;
import com.witty.entity.Conexion;
import com.witty.entity.TramaModel;
import com.witty.persistence.JPAUtility;
import com.witty.server.RestListener;

@Stateless
@Path("/conections")
public class ConectionService extends RestListener implements LogSource, Configurable {
	public ConectionService(ISOPackager packager) {
		super(packager);
	}

	public ConexionController conexionController=new ConexionController();
	
 	@GET
	@Path("/getDataConfig")
   	@Produces(MediaType.APPLICATION_JSON)
	public String getDataConfig() {
 		List<TramaModel> listaConexion= conexionController.getTramasModel();
 		Gson gson =  new Gson();
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("mti", "800");
		jsonObject.addProperty("mti", "810");
		jsonObject.addProperty("mti", "400");
		jsonObject.addProperty("mti", "410");
		jsonObject.addProperty("sense", "In");
		jsonObject.addProperty("sense", "Out");
		jsonObject.addProperty("product", "POS");
		jsonObject.addProperty("product", "ATM");
		jsonObject.addProperty("TramaModel",gson.toJson(listaConexion));		
 
		return jsonObject.toString();
	}
	
	
   	@GET
	@Path("/getConectionsService")
   	@Produces(MediaType.APPLICATION_JSON)
	public String getConections() {
   		List<Conexion> listaConexion= conexionController.getPersistence().findAll();
   		
   		Gson gson=new Gson();
   		gson.
   		
   		Gson Gson =  new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
   		String json = Gson.toJson(listaConexion );
		return json;
	}
		
	@POST
	@Path("/putConectionService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setConections(Conexion conexion) {
		
		conexionController.setConection(conexion);
		return Response.status(200).entity("Conexion Exitosa").build();
	}
	
	@GET
	@Path("/getConectionService")
	@Produces(MediaType.TEXT_PLAIN)
	public Conexion getConection(String data) {
		JSONObject recoData = new JSONObject(data);		
		Conexion conexion = conexionController.getPersistence().find(recoData.getInt("id"));
		return conexion;
	}
	

	@GET
	@Path("/sendCommandService")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response sendCommand(String data) {
		JSONObject recoData = new JSONObject(data); 
		conexionController.commandConexion(recoData.getInt("command"),recoData.getInt("id") );
		return Response.status(200).entity("ok").build();
	}
	
	@POST
	@Path("/deleteConectionService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteConection(String data) {
		JSONObject recoData = new JSONObject(data);
		conexionController.deleteServerProcess(recoData.getInt("id"));
		// return HTTP response 200 in case of success
		return Response.status(200).entity("Ok").build();
	}
	
	@POST
	@Path("/updateConectionService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateConection(Conexion conexion) {

		conexionController.updateServerProcess(conexion);
 		return Response.status(200).entity("Conexion Exitosa").build();
	}


	public void setConfiguration(Configuration cfg) throws ConfigurationException {
		// TODO Auto-generated method stub
		
	}
	

}
