package com.witty.controller;

import java.io.IOException;

import com.jfoenix.controls.JFXTabPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

public class Home {

	
	@FXML
	private JFXTabPane tabPaneFP2;
	
	
	@FXML
	public void initialize() throws IOException {
		
		showConections();
		showInterpreter();
		showAutomation();
		showSimulator();
	}
	
	
	public void showConections() throws IOException {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass()
                .getResource("../view/Conections.fxml"));
		AnchorPane conections = (AnchorPane) loader.load();

		Tab conexiones=new Tab("Conections");
		conexiones.setContent(conections);
		tabPaneFP2.getTabs().add(conexiones);
		Conexiones conection=loader.getController();
	}
	
	public void showInterpreter() throws IOException {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass()
                .getResource("../view/Interpreter.fxml"));
		AnchorPane conections = (AnchorPane) loader.load();

		Tab interpreter=new Tab("Interpreter");
		interpreter.setContent(conections);
		tabPaneFP2.getTabs().add(interpreter);
		
		
	}
	
	public void showAutomation() throws IOException {
		
		
	}
	
	public void showSimulator() throws IOException {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass()
                .getResource("../view/SimulationV2.fxml"));
		AnchorPane conections = (AnchorPane) loader.load();

		Tab simulator=new Tab("Simulator");
		simulator.setContent(conections);
		tabPaneFP2.getTabs().add(simulator);
		
	}
	
	
	
	
}
