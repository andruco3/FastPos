package com.witty.webservices;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/conections")
public class Conexiones {
	
		
	@POST
	@Path("/getConectionService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getConections(InputStream incomingData) {
		
		return Response.status(200).entity("saldo").build();
	}
	
	
	@GET
	@Path("/putConectionService")
	@Produces(MediaType.TEXT_PLAIN)
	public Response setConections(InputStream incomingData) {
		String result = "CrunchifyRESTService Successfully started..";
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(result).build();
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
	@Produces(MediaType.TEXT_PLAIN)
	public Response sendCommand(InputStream incomingData) {
		String result = "CrunchifyRESTService Successfully started..";
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(result).build();
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