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
import com.witty.controller.InterpreterController;
import com.witty.entity.CamposConexion;
import com.witty.entity.Conexion;
import com.witty.entity.TramaModel;
import com.witty.persistence.JPAUtility;
import com.witty.persistence.TramaModelPersistence;
import com.witty.server.RestListener;


@Path("/interpreter")
public class InterpreterService extends RestListener implements LogSource, Configurable {
	public InterpreterService(ISOPackager packager) {
		super(packager);
	}

	public InterpreterController interpreterController;
	
	
//   	@GET
//	@Path("/getTramasService")
//   	@Produces(MediaType.APPLICATION_JSON)
//	public List<TramaModel> getConections() {
//   		interpreterController=new InterpreterController();
//   		List<TramaModel> listaConexion= interpreterController.persistence.findAll();
//   		String json = new Gson().toJson(listaConexion );
//		return listaConexion;
//	}
//	
//	
	@POST
	@Path("/putTramaService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setTramas(TramaModel tramaModel) {		
		TramaModelPersistence tramaModelPersistence= new TramaModelPersistence();
		tramaModelPersistence.create(tramaModel);

 		return Response.status(200).entity("Conexion Exitosa").build();
	}
	
	@GET
	@Path("/getTramaService")
	@Produces(MediaType.TEXT_PLAIN)
	public TramaModel getTramas(String data) {
		JSONObject recoData = new JSONObject(data);
		
		TramaModelPersistence tramaModelPersistence= new TramaModelPersistence();
		TramaModel tramaModel = tramaModelPersistence.find(recoData.getInt("id"));
		// return HTTP response 200 in case of success
		return tramaModel;
	}
//	
//
//	
////	@GET
////	@Path("/sendCommandService")
////	@Consumes(MediaType.TEXT_PLAIN)
////	public Response sendCommand(String data) {
////		JSONObject recoData = new JSONObject(data);
////	
//// 
////		persistence.commandConexion(recoData.getInt("command"),recoData.getLong("id") );
////		// return HTTP response 200 in case of success
////		return Response.status(200).entity("ok").build();
////	}
//	
//	@GET
//	@Path("/deleteTramaService")
//	@Produces(MediaType.TEXT_PLAIN)
//	public Response deleteConection(String data) {
//		JSONObject recoData = new JSONObject(data);
//		
//		
//		persistence.delete(recoData.getLong("id"));
//		// return HTTP response 200 in case of success
//		return Response.status(200).entity("Ok").build();
//	}
	
	@POST
	@Path("/convertToFieldsService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response convertToFields(String data) {

		System.out.print("-----"+data);
		interpreterController=new InterpreterController();		
		String trama1="";
		interpreterController.convertToFields(trama1);
		
		
		//conexionController.deleteServerProcess(recoData.getInt("trama"));
		// return HTTP response 200 in case of success
		return Response.status(200).entity("Ok").build();
	}
	



	public void setConfiguration(Configuration cfg) throws ConfigurationException {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
