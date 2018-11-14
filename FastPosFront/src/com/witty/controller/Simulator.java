package com.witty.controller;

import java.io.IOException;

import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTreeTableView;
import com.witty.entity.CamposModel;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;

public class Simulator {
	
//	@FXML
//	private JFXTabPane tabPaneSimulator;
	
	@FXML
	private JFXTreeTableView<CamposModel> tableViewServer;
	
	@FXML
	private JFXTreeTableView<CamposModel> tableViewClient;
	
	@FXML
	private JFXTreeTableView<CamposModel> tableViewCases;
	
	
	@FXML
	public void initialize() throws IOException {
		
		System.out.println("Soy un evolucionado");
		
		
	}


}
