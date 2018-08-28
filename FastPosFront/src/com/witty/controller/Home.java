package com.witty.controller;

import com.jfoenix.controls.JFXTabPane;

import javafx.fxml.FXML;

public class Home {

	
	@FXML
	private JFXTabPane tabPaneFP2;
	
	
	
	public void printMessage() {
		
		
		System.out.print("Soy un ejemplo: "+ tabPaneFP2.getTabs().get(0).getText());
	}
}
