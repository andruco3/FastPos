package com.witty.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class Interpreter {
	
	@FXML
	private JFXDrawer draweInter;

	@FXML
	private JFXHamburger hamburgerInter;
	
	
	@FXML
	public void initialize() throws IOException {
		
		 
        try {
            VBox box = FXMLLoader.load(getClass().getResource("SidePanelContent.fxml"));
            draweInter.setSidePane(box);
        } catch (IOException ex) {
            //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburgerInter);
        transition.setRate(-1);
        hamburgerInter.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
            transition.setRate(transition.getRate()*-1);
            transition.play();
            
            if(draweInter.isShown())
            {
                draweInter.close();
            }else
                draweInter.open();
        });
	}

}
