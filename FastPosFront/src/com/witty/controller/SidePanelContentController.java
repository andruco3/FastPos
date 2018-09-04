package com.witty.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;


public class SidePanelContentController implements Initializable {

    @FXML
    private JFXButton b1;
    @FXML
    private JFXButton b2;
    @FXML
    private JFXButton b3;
    @FXML
    private JFXButton exit;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void changeColor(ActionEvent event) {
        JFXButton btn = (JFXButton) event.getSource();
        System.out.println(btn.getText());
        switch(btn.getText())
        {
            case "Color 1":
                break;
            case "Color 2":
                break;
            case "Color 3":
                break;
        }
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }
    
}
