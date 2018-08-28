package com.witty.webservices;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/automation")
public class Automatizacion {
	
	
	@POST
	@Path("/getAutomationService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAutomation(InputStream incomingData) {
		
		return Response.status(200).entity("saldo").build();
	}
	
	@POST
	@Path("/setAutomationService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setAutomation(InputStream incomingData) {
		
		return Response.status(200).entity("saldo").build();
	}
	
	@POST
	@Path("/sendCommandService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response sendCommand(InputStream incomingData) {
		
		return Response.status(200).entity("saldo").build();
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
	public Response deleteAutomationCase(InputStream incomingData) {
		
		return Response.status(200).entity("saldo").build();
	}
	
}
