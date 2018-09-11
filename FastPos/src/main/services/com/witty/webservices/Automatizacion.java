package com.witty.webservices;

import java.io.InputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.witty.entity.Conexion;
import com.witty.entity.SetPruebas;
import com.witty.persistence.AutomotionPersistence;
import com.witty.persistence.ConexionController;

@Path("/automation")
public class Automatizacion {
	
	
	
	public AutomotionPersistence persistence=new AutomotionPersistence();
	
	@POST
	@Path("/getAutomationService")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SetPruebas> getAutomation() {
		
		List<SetPruebas> listaSetPruebas= persistence.findAll();
   		String json = new Gson().toJson(listaSetPruebas );
		return listaSetPruebas;
	}
	
	@POST
	@Path("/setAutomationService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setAutomation(SetPruebas setPruebas) {
		
		
		persistence.create(setPruebas);		
 		return Response.status(200).entity("Conexion Exitosa").build();
	}
	
	@POST
	@Path("/sendCommandService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response sendCommand(String data) {
		JSONObject recoData = new JSONObject(data);
	
 
		persistence.commandConexion(recoData.getInt("command"),recoData.getLong("id") );
		// return HTTP response 200 in case of success
		return Response.status(200).entity("ok").build();
	}
	
	@POST
	@Path("/viewAutomationCaseService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response viewAutomationCase(InputStream incomingData) {
		
		return Response.status(200).entity("saldo").build();
	}
	
	@POST
	@Path("/deleteAutomationCaseService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteAutomationCase(String data) {
		JSONObject recoData = new JSONObject(data);
		
		
		persistence.delete(recoData.getInt("id"));
		// return HTTP response 200 in case of success
		return Response.status(200).entity("Ok").build();
	}
	
}
