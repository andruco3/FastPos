package com.witty.entity;

import java.io.Serializable;


import com.google.gson.annotations.Expose;

public class ConfigMessage implements Serializable {

	@Expose private int id;

	public ConfigMessage() {

	}

	@Expose private String messageName;

	@Expose private String messageChannel;

	@Expose private String messagePackager;

	@Expose private String messagePackConfig;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessageType() {
		return messageName;
	}

	public void setMessageType(String messageType) {
		this.messageName = messageType;
	}

	public String getMessageChannel() {
		return messageChannel;
	}

	public void setMessageChannel(String messageChannel) {
		this.messageChannel = messageChannel;
	}

	public String getMessagePackager() {
		return messagePackager;
	}

	public void setMessagePackager(String messagePackager) {
		this.messagePackager = messagePackager;
	}

	public String getMessagePackConfig() {
		return messagePackConfig;
	}

	public void setMessagePackConfig(String messagePackConfig) {
		this.messagePackConfig = messagePackConfig;
	}


	
	
	@Override
    public String toString() {
        return messageName;
    }

	

}
