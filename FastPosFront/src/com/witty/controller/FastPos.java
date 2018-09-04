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

	@Override
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader();			
			loader.setLocation(getClass()
	                    .getResource("../view/Interpreter.fxml"));
			
			Scene scene = new Scene(loader.load());
			primaryStage.setScene(scene);
			primaryStage.show();
			 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
