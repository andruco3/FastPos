package com.witty.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTabPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Home {

	
	@FXML
	private JFXTabPane tabPaneFP2;
	
//    @FXML
//    private JFXDrawer drawer;
//
//    @FXML
//    private JFXHamburger hamburger;
    
	
	
	@FXML
	public void initialize() throws IOException {
		
		showConections();
		showInterpreter();
		showAutomation();
		showSimulator();
		
//		   try {
//	            VBox box = FXMLLoader.load(getClass().getResource("../view/SidePanelContent.fxml"));
//	            drawer.setSidePane(box);
//	        } catch (IOException ex) {
//	            Logger.getLogger(Interpreter.class.getName()).log(Level.SEVERE, null, ex);
//	        }
//	        
//	        
//	        
//	        //HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
//	        HamburgerSlideCloseTransition task = new HamburgerSlideCloseTransition(hamburger);
//	        task.setRate(-1);
//	        hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED,(Event event)->{
//	        	drawer.toggle();
//	        });
//	        drawer.setOnDrawerOpening((event) -> {
//	            task.setRate(task.getRate() * -1);
//	            task.play();
//	            drawer.toFront();
//	        });
//	        drawer.setOnDrawerClosed((event) -> {
//	            drawer.toBack();
//	            task.setRate(task.getRate() * -1);
//	            task.play();
//	        });
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
		StackPane conections = (StackPane) loader.load();

		Tab interpreter=new Tab("Interpreter");
		interpreter.setContent(conections);
		tabPaneFP2.getTabs().add(interpreter);
		
		
	}
	
	public void showAutomation() throws IOException {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass()
                .getResource("../view/Automotion.fxml"));
		AnchorPane conections = (AnchorPane) loader.load();

		Tab simulator=new Tab("Automotion");
		simulator.setContent(conections);
		tabPaneFP2.getTabs().add(simulator);
		
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
