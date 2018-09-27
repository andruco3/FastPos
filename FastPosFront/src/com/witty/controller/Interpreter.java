package com.witty.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import com.witty.entity.Conexion;
import com.witty.entity.ConfigMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Interpreter implements Initializable {

      @FXML
      private JFXButton buttonPlay;
      
      @FXML
      private JFXButton buttonFields;
      
      @FXML
      private JFXTreeTableView treeTableTCampos;
      
      @FXML
      private JFXTextArea textAreaIn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //rootP = root;
        
     
    }

    @FXML
	public void convertMessage() {

		
    	JsonObject jsonObject = new JsonObject();		
		
		jsonObject.addProperty("id", textAreaIn.getText());
		// Step2: Now pass JSON File Data to REST Service
		try {
			URL url = new URL("http://localhost:8080/interpreter/convertToFieldsService");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			out.write(jsonObject.toString());
			out.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			while (in.readLine() != null) {
			}
			System.out.println("\nCrunchify REST Service Invoked Successfully..");
			in.close();
		} catch (Exception e) {
			System.out.println("\nError while calling Crunchify REST Service");
			System.out.println(e);
		}

    }
    
    @FXML
    public void viewFields(){
    	
    	
    	

		FXMLLoader loader = new FXMLLoader();			
		loader.setLocation(getClass()
                    .getResource("../view/Fields.fxml"));
		
		Scene scene;
		try {
			scene = new Scene(loader.load());
			Stage primaryStage=new Stage();
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	
    }
    
    
}
