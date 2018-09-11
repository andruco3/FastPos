package com.witty.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "config_message")
@XmlRootElement
public class ConfigMessage implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose private int id;

	public ConfigMessage() {

	}

	@Column(name = "type")
	@Expose private String messageType;

	@Column(name = "channel")
	@Expose private String messageChannel;

	@Column(name = "packager")
	@Expose private String messagePackager;

	@Column(name = "packConfig")
	@Expose private String messagePackConfig;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
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


	
	
	
	

}
