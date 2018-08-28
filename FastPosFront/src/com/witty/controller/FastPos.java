package com.witty.controller;
	
import java.io.IOException;

import com.jfoenix.controls.JFXTabPane;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class FastPos extends Application {
	Parent rooti ;

	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader();			
			loader.setLocation(getClass()
	                    .getResource("../view/principal.fxml"));
			
			Scene scene = new Scene(loader.load());
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			Home home=loader.getController();
			home.printMessage();
			primaryStage.show();
			//System.out.print("Soy un ejemplo: "+ tabPaneFP.getTabs().get(0).getText());
			 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showConections() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			//System.err.println("FXML resource-: " + AnalyzerApp.class);
			loader.setLocation(getClass()
                    .getResource("../view/Conections.fxml"));
			AnchorPane conections = (AnchorPane) loader.load();

			Tab conexiones=new Tab();
			conexiones.setContent(conections);
			
			
			// Set person overview into the center of root layout.
			//rooti.setCenter(Analyzer);
			//AnalyzerController controller = loader.getController();
			//controller.setMainApp(this);
		} catch (IOException e) {
			//log.error("Se presento un error");
			//log.error(e);

		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
