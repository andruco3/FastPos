package com.witty.webservices;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/simulator")
public class Simulador {
	
	
	@POST
	@Path("/getCasesService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getCases(InputStream incomingData) {
		
		return Response.status(200).entity("saldo").build();
	}
	
	
	@POST
	@Path("/setCasesService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setCases(InputStream incomingData) {
		
		return Response.status(200).entity("saldo").build();
	}
	
	@POST
	@Path("/setCommandService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setCommand(InputStream incomingData) {
		
		return Response.status(200).entity("saldo").build();
	}
	
	@POST
	@Path("/deleteCasesService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteCasesService(InputStream incomingData) {
		
		return Response.status(200).entity("saldo").build();
	}
	
	@POST
	@Path("/setConfigStressService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setConfigurationStress(InputStream incomingData) {
		
		return Response.status(200).entity("saldo").build();
	}
	
	@POST
	@Path("/getFieldsService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getFieldsService(InputStream incomingData) {
		
		return Response.status(200).entity("saldo").build();
	}

}
