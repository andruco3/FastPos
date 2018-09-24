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

import com.witty.controller.ConexionController;
import com.witty.controller.SimulatorController;
import com.witty.entity.CasosPrueba;
import com.witty.entity.Conexion;

@Path("/simulator")
public class SimulatorService {
	
	
	public SimulatorController persistence;
	
	@POST
	@Path("/getCasesService")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CasosPrueba> getCases() {
					
		persistence=new SimulatorController();
		return persistence.getPersistenceCasos().findAll();
	}
	
	
	@POST
	@Path("/setCasesService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setCases(CasosPrueba casosPrueba) {
		persistence=new SimulatorController();
		persistence.getPersistenceCasos().create(casosPrueba);
 		return Response.status(200).entity("Conexion Exitosa").build();

	}
	
	@POST
	@Path("/setCommandService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setCommand(String data) {
		JSONObject recoData = new JSONObject(data);
	
 
		//persistence.commandSimulator(recoData.getInt("command"),recoData.getLong("id") );
		
		return Response.status(200).entity("Ok").build();
	}
	
	@POST
	@Path("/deleteCasesService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteCasesService(String data) {
		JSONObject recoData = new JSONObject(data);
		
		
		persistence.getPersistenceCasos().delete(recoData.getInt("id"));
		// return HTTP response 200 in case of success
		return Response.status(200).entity("Ok").build();
	}
	



}
