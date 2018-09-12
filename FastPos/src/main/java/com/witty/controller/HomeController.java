package com.witty.controller;

import java.util.List;

import com.witty.entity.ConfigMessage;
import com.witty.persistence.ConectionPersistence;
import com.witty.persistence.ConfigMessagePersistence;

public class HomeController {

	
	public ConectionPersistence persistenceConection;
	public ConfigMessagePersistence persistenceConfig;
	
	HomeController(){
		
		
		persistenceConection=new ConectionPersistence();
		persistenceConfig=new ConfigMessagePersistence();
	}
	
	public List<ConfigMessage> getConfigMessage() {
		
		return persistenceConfig.findAll();
				
	}
	
	
	public List<TramaModel> getConfigMessage() {
		
		return persistenceConfig.findAll();
				
	}
	
	
}
