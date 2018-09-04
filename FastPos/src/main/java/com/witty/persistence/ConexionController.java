package com.witty.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jpos.q2.Q2;

import com.witty.entity.Conexion;

import miscelanea.Archivos;

public class ConexionController extends CrudPersistence<Conexion>{

    //@PersistenceContext(unitName="FastPos")
    protected EntityManager em;
	
	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

	@Override
	public Class<Conexion> getEntityClass() {
		// TODO Auto-generated method stub
		return Conexion.class;
	}
	
	
	 public ConexionController() {
		em=JPAUtility.getEntityManager();

	 }

	
	 public void commandConexion(long id) {
		 	 
		 
		  
		 
		 
	 }	
	 
	 public void createServerProcess(long id) {
		 addConexionServer(id);
		 addConexionMux(id);
		 
	 }
	 
	 public void createClienteProcess() {
		 
		 
		 
	 }
	 
	 
	 public void addConexionServer(long id) {
		 
		 Conexion conexion = this.find(id);
		 
		  String chanel= "<server class=\"org.jpos.q2.iso.QServer\" logger=\"Q2\" name=\"HostQServer501\">\n" + 
		  		"    <attr name=\"port\" type=\"java.lang.Integer\">"+conexion.getPuerto()+"</attr>\n" + 
		  		"    <attr name=\"maxSessions\" type=\"java.lang.Integer\">20</attr>\n" + 
		  		"    <attr name=\"minSessions\" type=\"java.lang.Integer\">10</attr>\n" + 
		  		"\n" + 
		  		"    <channel class=\"org.jpos.iso.channel.ASCIIChannel\" name=\"ASCIIChannel\" logger=\"Q2\"\n" + 
		  		"		 packager=\"org.jpos.iso.packager.GenericPackager\" header=\"cas\">\n" + 
		  		"       <property name=\"packager-config\" value=\"cfg/packager/"+conexion.getTipo()+".xml\"/>\n" + 
		  		"        <!--<property name=\"packager-logger\" value=\"Q2\"/>-->\n" + 
		  		"    </channel>\n" + 
		  		"\n" + 
		  		"    <request-listener class=\"com.witty.server.ServerApplicationListener\" logger=\"Q2\" name=\"isoListener\">\n" + 
		  		"        <property name=\"space\" value=\"transient:default\" />\n" + 
		  		"        <property name=\"queue\" value=\"TXNQueue\" />\n" + 
		  		"        <property name=\"spaceTimeout\" value=\"60000\" />\n" + 
		  		"    </request-listener>\n" + 
		  		"	<in>NETWORK_IN</in>\n" + 
		  		"	<out>NETWORK_OUT</out>\n" + 
		  		"\n" + 
		  		"</server>\n" + 
		  		"";
		 
		 
		  Archivos.EscribirArchivo(chanel, "50_server_" + id);
		 
	 }
	 
	 
	 public void addConexionMux(long id) {
		 

		  String Mux= "<mux class=\"org.jpos.q2.iso.QMUX\" logger=\"Q2\" name=\"qserver-mux\">\n" + 
		  		" <in>NETWORK_OUT</in>\n" + 
		  		" <out>NETWORK_IN</out>\n" + 
		  		" <key>11</key>\n" + 
		  		" <unhandled>unhandled</unhandled>\n" + 
		  		"</mux>\n" + 
		  		"\n" + 
		  		"";		
		  
		  
		  Archivos.EscribirArchivo(Mux, "20_mux_" + id);
	 }
	 
	 
	 public void addConexionChannel(long id) {
		 

		  String Mux= "<?xml version=\"1.0\" ?>\n" + 
		  		"<channel-adaptor name='HostConnection-1' \n" + 
		  		"    class=\"org.jpos.q2.iso.ChannelAdaptor\" logger=\"Q2\">\n" + 
		  		" <channel class=\"org.jpos.iso.channel.BASE24TCPChannel\" logger=\"Q2\" realm=\"channel-1\"\n" + 
		  		"       packager=\"org.jpos.iso.packager.GenericPackager\" header= \"ISO006000099\">   \n" + 
		  		"   <property name=\"packager-config\" value=\"cfg/packager/base24.xml\"/>	   \n" + 
		  		"  <property name=\"host\" value='10.9.200.74' />\n" + 
		  		"  <property name=\"port\" value=\"9015\" />\n" + 
		  		"  <property name=\"timeout\" value=\"1000000\" />\n" + 
		  		"  <property name=\"keep-alive\" value=\"true\" />  \n" + 
		  		"</channel>\n" + 
		  		" <in>host1-send</in>\n" + 
		  		" <out>host-receive</out>\n" + 
		  		" <reconnect-delay>10000</reconnect-delay>\n" + 
		  		" </channel-adaptor>";		
		  
		  
		  Archivos.EscribirArchivo(Mux, "10_channel_" + id);
	 }
	 
	
	
//	
//    public static ConexionPersistence getConexion() {
//        if (conexionMe == null){
//        	conexionMe = new ConexionPersistence();
//        }
//       
//        return conexionMe;
//    }
	
	

}
