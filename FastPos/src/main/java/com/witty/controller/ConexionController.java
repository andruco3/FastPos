package com.witty.controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jpos.q2.Q2;
import org.jpos.q2.iso.ChannelAdaptor;
import org.jpos.q2.iso.QMUX;
import org.jpos.q2.iso.QServer;
import org.jpos.util.NameRegistrar;

import com.witty.entity.CamposConexion;
import com.witty.entity.Conexion;
import com.witty.entity.ConfigMessage;
import com.witty.entity.TramaModel;
import com.witty.persistence.ConectionPersistence;
import com.witty.persistence.ConfigMessagePersistence;
import com.witty.persistence.CrudPersistence;
import com.witty.persistence.JPAUtility;
import com.witty.persistence.TramaModelPersistence;

import miscelanea.Archivos;

public class ConexionController {
	
	
	public ConectionPersistence persistence;
	public ConfigMessagePersistence persistenceConfig;
//	public TramaModelPersistence tramaModelPersisten;
	
	final int START = 1;
	final int STOP = 2;
	

	
	public ConexionController(){
		
		
		persistence=new ConectionPersistence();
		persistenceConfig=new ConfigMessagePersistence();
	}
	
	
	
	
	public ConectionPersistence getPersistence() {
		return new ConectionPersistence();
		
	}
	
	
	public boolean setConection(Conexion conexion) {
		
		for(CamposConexion coll:conexion.getCamposConexion()) {
			coll.setIdConexion(conexion);			
		}
		persistence.create(conexion);
		
		if (conexion.getServer())
			addConexionServer(conexion);
		else
			addConexionChannel(conexion);

		addConexionMux(conexion);
		
		
		return true;
	}
	
public void updateServerProcess(Conexion conexion) {
		
		for(CamposConexion coll:conexion.getCamposConexion()) {
			coll.setIdConexion(conexion);			
		}
		
		Archivos.deleteArchivo("50_server_" + conexion.getId() + ".xml");
		Archivos.deleteArchivo("20_mux_" + conexion.getId() + ".xml");
		addConexionServer(conexion);
		addConexionMux(conexion);
		persistence.update(conexion);
	}


	public void commandConexion(int command, int id) {

		Conexion conection = persistence.find(id);
		QServer server=null;
		ChannelAdaptor channel=null;
		
		
		try {
			
			if(conection.getServer())
				server = (QServer) NameRegistrar.get("HostQServer"+id);
			else
				channel = (ChannelAdaptor)NameRegistrar.get("HostChannel"+id);
			QServer mux = (QServer) NameRegistrar.get("mux"+id);
			// final QMUX mux = (QMUX) NameRegistrar.get("mux.host-mux-1");
			switch (command) {
			case START:
				if(conection.getServer()) 
					server.startService();					
				else 
					channel.startService();		
				mux.startService();
				break;
			case STOP:
				if(conection.getServer()) 
					server.stopService();					
				else 
					channel.stopService();		
				mux.stopService();
				break;
			case 3:
				mux.stopService();
				break;
			}

			mux.stopService();
		} catch (NameRegistrar.NotFoundException e) {
			System.out.print((e.toString()));

		}

	}


	public void deleteServerProcess(int id) {
		Archivos.deleteArchivo("50_server_" + id + ".xml");
		Archivos.deleteArchivo("20_mux_" + id + ".xml");
		persistence.delete(id);
	}

	

	public void createClienteProcess() {

	}

	public void addConexionServer(Conexion conexion) {

		String cfgPackager = "";
		if ("GenericPackager".equals(conexion.getTipo().getMessagePackager()))
			cfgPackager = " <property name=\"packager-config\" value=\"cfg/packager/"
					+ conexion.getTipo().getMessagePackConfig() + ".xml\"/>\n";

		String chanel = "<server class=\"org.jpos.q2.iso.QServer\" logger=\"Q2\" name=\"HostQServer" + conexion.getId()
				+ "\">\n" + "    <attr name=\"port\" type=\"java.lang.Integer\">" + conexion.getPuerto() + "</attr>\n"
				+ "    <attr name=\"maxSessions\" type=\"java.lang.Integer\">20</attr>\n"
				+ "    <attr name=\"minSessions\" type=\"java.lang.Integer\">10</attr>\n" + "\n"
				+ "    <channel class=\"org.jpos.iso.channel." + conexion.getTipo().getMessageChannel() + "\" name=\" "
				+ conexion.getTipo().getMessageChannel() + "\" logger=\"Q2\"\n"
				+ "		 packager=\"org.jpos.iso.packager." + conexion.getTipo().getMessagePackager()
				+ "\" header=\"cas\">\n" + cfgPackager
				+ "        <!--<property name=\"packager-logger\" value=\"Q2\"/>-->\n" + "    </channel>\n" + "\n"
				+ "    <request-listener class=\"com.witty.server.ServerApplicationListener\" logger=\"Q2\" name=\"isoListener\">\n"
				+ "			<property name=\"mux\" value=\"mux"+conexion.getId()+"\"  />"
				+ "        	<property name=\"space\" value=\"transient:default\" />\n"
				+ "        	<property name=\"queue\" value=\"TXNQueue\" />\n"
				+ "        	<property name=\"spaceTimeout\" value=\"60000\" />\n" + "    </request-listener>\n"
				+ "	<in>NETWORK_IN_" + conexion.getId() + "</in>\n" + "	<out>NETWORK_OUT_" + conexion.getId()
				+ "</out>\n" + "\n" + "</server>\n" + "";

		Archivos.EscribirArchivo(chanel, "50_server_" + conexion.getId() + ".xml");

	}

	public void addConexionChannel(Conexion conexion) {

		String cfgPackager = "";
		if ("GenericPackager".equals(conexion.getTipo().getMessagePackager()))
			cfgPackager = "   <property name=\"packager-config\" value=\"cfg/packager/base24.xml\"/>	   \n";

		String chanel = "<?xml version=\"1.0\" ?>\n" + "<channel-adaptor name='HostChannel'" + conexion.getId()
				+ " \n" + "    class=\"org.jpos.q2.iso.ChannelAdaptor\" logger=\"Q2\">\n"
				+ " <channel class=\"org.jpos.iso.channel." + conexion.getTipo().getMessageChannel()
				+ "\" logger=\"Q2\" realm=\"channel-1\"\n" + "       packager=\"org.jpos.iso.packager."
				+ conexion.getTipo().getMessagePackager() + "\" header= \"ISO006000099\">   \n" + cfgPackager
				+ "  <property name=\"host\" value=" + conexion.getDireccionIp() + " />\n"
				+ "  <property name=\"port\" value=" + conexion.getPuerto() + " />\n"
				+ "  <property name=\"timeout\" value=\"1000000\" />\n"
				+ "  <property name=\"keep-alive\" value=\"true\" />  \n" + "</channel>\n" + "	<in>NETWORK_IN_"
				+ conexion.getId() + "</in>\n" + "	<out>NETWORK_OUT_" + conexion.getId() + "</out>\n"
				+ " <reconnect-delay>10000</reconnect-delay>\n" + " </channel-adaptor>";

		Archivos.EscribirArchivo(chanel, "10_Channel_" + conexion.getId() + ".xml");

	}

	public void addConexionMux(Conexion conexion) {

		String Mux = "<mux class=\"org.jpos.q2.iso.QMUX\" logger=\"Q2\" name=\"mux" + conexion.getId() + "\">\n"
				+ " <in>NETWORK_OUT_" + conexion.getId() + "</in>\n" + " <out>NETWORK_IN_" + conexion.getId()
				+ "</out>\n" + " <key>11</key>\n" + " <unhandled>unhandled</unhandled>\n" + "</mux>\n" + "\n" + "";

		Archivos.EscribirArchivo(Mux, "20_mux_" + conexion.getId() + ".xml");
	}

	

	
	
	public List<ConfigMessage> getConfigMessage() {
		return persistenceConfig.findAll();
				
	}
//	
//	public List<TramaModel> getTramasModel() {
//		
//		return tramaModelPersisten.findAll();
//				
//	}
	

//	
//    public static ConexionPersistence getConexion() {
//        if (conexionMe == null){
//        	conexionMe = new ConexionPersistence();
//        }
//       
//        return conexionMe;
//    }

}
