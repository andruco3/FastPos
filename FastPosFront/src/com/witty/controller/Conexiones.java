package com.witty.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;

public class Conexiones {
	
	
	@FXML
	private JFXTextField textFieldIP;
	
	@FXML
	private JFXTextField textFieldPort;
	
	@FXML
	private JFXTextField textFieldIPName;
	
	@FXML
	private JFXComboBox comboBoxSense;
	
	@FXML
	private JFXComboBox comboBoxProduct;
	
	@FXML
	private JFXComboBox comboBoxField;
	
	@FXML
	private JFXButton buttonOK;

	@FXML
	private JFXButton buttonCancel;
	
	@FXML
	private JFXTreeTableView tableViewConections;
	
	@FXML
	private JFXTabPane tabPaneFields;
	

	
	private ObservableList<String> optionscomboBoxField = FXCollections.observableArrayList();
	
	

	@FXML
	public void initialize() {
		
		optionscomboBoxField.addAll("800","810","200","210","420","430","220","230","other");
		
		comboBoxField.setItems(optionscomboBoxField);
		

		
		
	}
	
	
	@FXML
	public void addFields() {
		
		GridPane gridPaneFields=new GridPane();
		
		Tab message=new Tab(comboBoxField.getValue().toString());
		gridPaneFields.setHgap(20.0);
		gridPaneFields.setVgap(10.0);
		
	
	
	int j =0;
	for(int i=0;i<128;i++) {
		gridPaneFields.addColumn(j, new JFXRadioButton(String.valueOf(i+1)));
		if((i+1) % 16 == 0)
			j++;
		
	}
	message.setContent(gridPaneFields);
	tabPaneFields.getTabs().add(message)	;
	
	}

	
	
	
	
	
	
}
