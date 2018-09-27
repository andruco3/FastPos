package com.witty.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.witty.entity.CamposModel;
import com.witty.entity.Conexion;
import com.witty.entity.TramaModel;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Tab;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.CheckBoxTreeTableCell;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class FieldsMessage {
	
	@FXML
	private JFXComboBox comboBoxRole;
	
	@FXML
	private JFXTreeTableView<CamposModel> tableViewTramas;
	
	private ObservableList<CamposModel> camposModelTableOb = FXCollections.observableArrayList();

	
	
	
	@FXML
	public void initialize() throws IOException {
		
		TreeTableColumn columnaA = new TreeTableColumn("Campo");
		TreeTableColumn columnaB = new TreeTableColumn("Nombre");
		TreeTableColumn columnaC = new TreeTableColumn("Clase");
		TreeTableColumn columnaD = new TreeTableColumn("Nombre");
		tableViewTramas.getColumns().addAll(columnaA, columnaB, columnaC, columnaD);

		columnaA.setCellValueFactory(new TreeItemPropertyValueFactory<CamposModel, String>("nombreConexion"));
		columnaB.setCellValueFactory(new TreeItemPropertyValueFactory<CamposModel, String>("direccionIp"));
		columnaC.setCellValueFactory(new TreeItemPropertyValueFactory<CamposModel, String>("puerto"));
		columnaD.setCellValueFactory(new TreeItemPropertyValueFactory<CamposModel, String>("puertos"));

//		columnaD.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Conexion, Boolean>, //
//				ObservableValue<Boolean>>() {
//			@Override
//			public ObservableValue<Boolean> call(TreeTableColumn.CellDataFeatures<Conexion, Boolean> param) {
//				TreeItem<Conexion> treeItem = param.getValue();
//				Conexion emp = treeItem.getValue();
//				SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(emp.getState());
//
//				// Note: singleCol.setOnEditCommit(): Not work for
//				// CheckBoxTreeTableCell.
//				// When "Single?" column change.
//				booleanProp.addListener(new ChangeListener<Boolean>() {
//
//					@Override
//					public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
//							Boolean newValue) {
//						emp.setState(newValue);
//					}
//				});
//				return booleanProp;
//			}
//		});

//		columnaD.setCellFactory(new Callback<TreeTableColumn<Conexion, Boolean>, TreeTableCell<Conexion, Boolean>>() {
//			@Override
//			public TreeTableCell<Conexion, Boolean> call(TreeTableColumn<Conexion, Boolean> p) {
//				CheckBoxTreeTableCell<Conexion, Boolean> cell = new CheckBoxTreeTableCell<Conexion, Boolean>();
//				cell.setEditable(true);
//				cell.setAlignment(Pos.CENTER);
//				return cell;
//			}
//		});

		TreeItem<CamposModel> root = new RecursiveTreeItem<>(camposModelTableOb, RecursiveTreeObject::getChildren);
		tableViewTramas.setEditable(true);
		tableViewTramas.setRoot(root);
		tableViewTramas.setShowRoot(false);
		
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
		
		getTramas();
	}
	
	
	
	
	public void getTramas() {

		System.out.println("Leer Conexion");

		try {

			ResteasyClient client = new ResteasyClientBuilder().build();
			ResteasyWebTarget target = client.target("http://localhost:8080/interpreter/getTramaService");
			Response response = target.request().get();
			String value = response.readEntity(String.class);

			response.close();
			Gson gson = new Gson();
			Type conexionListType = new TypeToken<List<TramaModel>>() {
			}.getType();
			System.out.println("\nconexionid" +value);
			List<TramaModel> tramaModel = gson.fromJson(value, conexionListType);
		
			camposModelTableOb.clear();
			camposModelTableOb.addAll(tramaModel.get(0).getCampos());

		} catch (Exception e) {
			System.out.println("\nError while calling Crunchify REST Service");
			e.printStackTrace();
		}

	}
	
	
}
