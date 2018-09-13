package com.witty.entity.view;

import java.util.ArrayList;
import java.util.List;

import com.witty.entity.ConfigMessage;

public class InitConfig {
	
	
	private List<ConfigMessage> configMessage;
	private List<String> mti=new ArrayList<String>();
	private List<String> sense=new ArrayList<String>();
	private List<String> product=new ArrayList<String>();
	
	public InitConfig(){
		
		mti.add("400");
		mti.add("410");
		mti.add("200");
		mti.add("210");
		mti.add("220");
		mti.add("230");
		mti.add("800");
		mti.add("810");
		
		sense.add("IN");
		sense.add("OUT");
		
		product.add("POS");
		product.add("ATM");
		
	}

	public List<ConfigMessage> getConfigMessage() {
		return configMessage;
	}

	public void setConfigMessage(List<ConfigMessage> configMessage) {
		this.configMessage = configMessage;
	}
	
	
	

}
