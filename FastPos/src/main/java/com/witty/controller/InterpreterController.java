package com.witty.controller;

import javax.persistence.EntityManager;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.packager.GenericPackager;

import com.witty.entity.Conexion;
import com.witty.entity.TramaModel;
import com.witty.persistence.ConectionPersistence;
import com.witty.persistence.ConfigMessagePersistence;
import com.witty.persistence.CrudPersistence;
import com.witty.persistence.JPAUtility;

public class InterpreterController{
	
	public ConectionPersistence persistence;
	public ConfigMessagePersistence persistenceConfig;
	
	public InterpreterController(){
		
		
		persistence=new ConectionPersistence();
		persistenceConfig=new ConfigMessagePersistence();
	}
	
	public String convertToFields(String trama) {
		
		GenericPackager packager;
	
		try {
			packager = new GenericPackager(System.getProperty("user.dir")+System.getProperty("file.separator")
					+ "cfg"+System.getProperty("file.separator")+"packager"+System.getProperty("file.separator")+"europay.xml");
			ISOMsg isoMsg = new ISOMsg();
			isoMsg.setPackager(packager);
			byte[] bmsg =ISOUtil.hex2byte(trama);
			isoMsg.unpack(bmsg);
			isoMsg.pack();
			System.out.print(isoMsg.toString());
		} catch (ISOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "";
		
	}

}
