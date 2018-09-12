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
import com.witty.controller.ConexionController;
import com.witty.entity.CamposConexion;
import com.witty.entity.Conexion;
import com.witty.entity.TramaModel;
import com.witty.persistence.InterpreterPersitence;
import com.witty.persistence.JPAUtility;
import com.witty.server.RestListener;


@Path("/interpreter")
public class Interpreter extends RestListener implements LogSource, Configurable {
	public Interpreter(ISOPackager packager) {
		super(packager);
	}

	public InterpreterPersitence persistence=new InterpreterPersitence();
	
	
   	@GET
	@Path("/getTramasService")
   	@Produces(MediaType.APPLICATION_JSON)
	public List<TramaModel> getConections() {
		
   		List<TramaModel> listaConexion= persistence.findAll();
   		String json = new Gson().toJson(listaConexion );
		return listaConexion;
	}
	
	
	@POST
	@Path("/putTramaService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setConections(TramaModel tramaModel) {		
		
		persistence.create(tramaModel);

 		return Response.status(200).entity("Conexion Exitosa").build();
	}
	
	@GET
	@Path("/getTramaService")
	@Produces(MediaType.TEXT_PLAIN)
	public TramaModel getConection(String data) {
		JSONObject recoData = new JSONObject(data);
		
		TramaModel tramaModel = persistence.find(recoData.getInt("id"));
		// return HTTP response 200 in case of success
		return tramaModel;
	}
	

	
//	@GET
//	@Path("/sendCommandService")
//	@Consumes(MediaType.TEXT_PLAIN)
//	public Response sendCommand(String data) {
//		JSONObject recoData = new JSONObject(data);
//	
// 
//		persistence.commandConexion(recoData.getInt("command"),recoData.getLong("id") );
//		// return HTTP response 200 in case of success
//		return Response.status(200).entity("ok").build();
//	}
	
	@GET
	@Path("/deleteTramaService")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteConection(String data) {
		JSONObject recoData = new JSONObject(data);
		
		
		persistence.delete(recoData.getLong("id"));
		// return HTTP response 200 in case of success
		return Response.status(200).entity("Ok").build();
	}


	public void setConfiguration(Configuration cfg) throws ConfigurationException {
		// TODO Auto-generated method stub
		
	}
	

}
