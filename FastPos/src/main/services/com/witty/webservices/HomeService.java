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
import com.witty.controller.ConexionController;
import com.witty.controller.HomeController;
import com.witty.entity.CamposConexion;
import com.witty.entity.Conexion;
import com.witty.entity.ConfigMessage;
import com.witty.persistence.JPAUtility;
import com.witty.server.RestListener;

@Stateless
@Path("/conections")
public class HomeService extends RestListener implements LogSource, Configurable {
	public HomeService(ISOPackager packager) {
		super(packager);
	}
	
	public HomeController homeController=new HomeController();
	
	
   	@GET
	@Path("/getConectionsService")
   	@Produces(MediaType.APPLICATION_JSON)
	public String readGeneral(String data) {
   		homeController.
		JSONObject recoData = new JSONObject(data);
		
		ConfigMessage configMessage=new ConfigMessage();
		ConfigMessage configMessage = persistence.findAll();
		
		
		
		
		
		Gson gson =  new Gson();
   		String json = gson.toJson(listaConexion );
		
		persistence.deleteServerProcess(recoData.getInt("id"));
		// return HTTP response 200 in case of success
		return Response.status(200).entity("Ok").build();
	}
	
	

	public void setConfiguration(Configuration cfg) throws ConfigurationException {
		// TODO Auto-generated method stub
		
	}

	


}
