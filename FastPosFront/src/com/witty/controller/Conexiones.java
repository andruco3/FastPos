package com.witty.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.witty.entity.CamposConexion;
import com.witty.entity.Conexion;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.CheckBoxTreeTableCell;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

public class Conexiones {

	@FXML
	private JFXTextField textFieldIP;

	@FXML
	private JFXTextField textFieldPort;

	@FXML
	private JFXTextField textFieldIPName;

	@FXML
	private JFXTextField textFieldAdd;

	@FXML
	private JFXComboBox comboBoxSense;

	@FXML
	private JFXComboBox comboBoxType;

	@FXML
	private JFXComboBox comboBoxProduct;

	@FXML
	private JFXComboBox comboBoxMessage;

	@FXML
	private JFXButton buttonOK;

	@FXML
	private JFXButton buttonClear;
	
	@FXML
	private JFXButton buttonDelete;

	@FXML
	private JFXButton buttonUpdate;

	@FXML
	private JFXTreeTableView<Conexion> tableViewConections;

	@FXML
	private GridPane gridPaneFields;

	@FXML
	private JFXToggleButton toogleButtonField;

	private ObservableList<String> optionscomboBoxType = FXCollections.observableArrayList();
	private ObservableList<String> optionscomboBoxMessage = FXCollections.observableArrayList();
	private ObservableList<String> optionscomboBoxSense = FXCollections.observableArrayList();
	private ObservableList<String> optionscomboBoxProduct = FXCollections.observableArrayList();

	private ObservableList<Conexion> conexionTableOb = FXCollections.observableArrayList();

	Conexion conexion = new Conexion();
	ArrayList<CamposConexion> camposOk = new ArrayList<CamposConexion>();

	@FXML
	public void initialize() {

		optionscomboBoxMessage.addAll("800", "810", "200", "210", "420", "430", "220", "230", "other");
		optionscomboBoxType.addAll("MasterCard", "Visa", "Amex", "Base24", "ISO8583");
		optionscomboBoxSense.addAll("In", "Out", "Both");
		optionscomboBoxProduct.addAll("ATM", "POS", "BASE");
		comboBoxType.setItems(optionscomboBoxType);
		comboBoxSense.setItems(optionscomboBoxSense);
		comboBoxProduct.setItems(optionscomboBoxProduct);
		comboBoxMessage.setItems(optionscomboBoxMessage);

		toogleButtonField.setSelected(false);

		comboBoxMessage.setDisable(true);
		comboBoxSense.setDisable(true);
		comboBoxProduct.setDisable(true);
		gridPaneFields.setDisable(true);
		textFieldAdd.setDisable(true);
		gridPaneFields.setHgap(20.0);
		gridPaneFields.setVgap(0.0);

		leerConexion();

		TreeTableColumn columnaA = new TreeTableColumn("Name");
		TreeTableColumn columnaB = new TreeTableColumn("Type");
		TreeTableColumn columnaC = new TreeTableColumn("State");
		TreeTableColumn columnaD = new TreeTableColumn("State");
		tableViewConections.getColumns().addAll(columnaA, columnaB, columnaC, columnaD);

		columnaA.setCellValueFactory(new TreeItemPropertyValueFactory<Conexion, String>("nombreConexion"));
		columnaB.setCellValueFactory(new TreeItemPropertyValueFactory<Conexion, String>("direccionIp"));
		columnaC.setCellValueFactory(new TreeItemPropertyValueFactory<Conexion, String>("puerto"));

		columnaD.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Conexion, Boolean>, //
				ObservableValue<Boolean>>() {
			@Override
			public ObservableValue<Boolean> call(TreeTableColumn.CellDataFeatures<Conexion, Boolean> param) {
				TreeItem<Conexion> treeItem = param.getValue();
				Conexion emp = treeItem.getValue();
				SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(emp.getState());

				// Note: singleCol.setOnEditCommit(): Not work for
				// CheckBoxTreeTableCell.
				// When "Single?" column change.
				booleanProp.addListener(new ChangeListener<Boolean>() {

					@Override
					public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
							Boolean newValue) {
						emp.setState(newValue);
					}
				});
				return booleanProp;
			}
		});

		columnaD.setCellFactory(new Callback<TreeTableColumn<Conexion, Boolean>, TreeTableCell<Conexion, Boolean>>() {
			@Override
			public TreeTableCell<Conexion, Boolean> call(TreeTableColumn<Conexion, Boolean> p) {
				CheckBoxTreeTableCell<Conexion, Boolean> cell = new CheckBoxTreeTableCell<Conexion, Boolean>();
				cell.setEditable(true);
				cell.setAlignment(Pos.CENTER);
				return cell;
			}
		});

		TreeItem<Conexion> root = new RecursiveTreeItem<>(conexionTableOb, RecursiveTreeObject::getChildren);
		tableViewConections.setEditable(true);
		tableViewConections.setRoot(root);
		tableViewConections.setShowRoot(false);
		
		buttonDelete.setVisible(false);
		buttonUpdate.setVisible(false);

	}

	@FXML
	public void updateConexion() {
		// check the table's selected item and get selected item
		if (tableViewConections.getSelectionModel().getSelectedItem() != null) {
			Conexion conexion = tableViewConections.getSelectionModel().getSelectedItem().getValue();
			textFieldIPName.setText(conexion.getNombreConexion());
			textFieldIP.setText(conexion.getDireccionIp());
			textFieldPort.setText(conexion.getPuerto());
			comboBoxType.getSelectionModel().select(0);
			comboBoxSense.getSelectionModel().select(0);
			comboBoxProduct.getSelectionModel().select(0);
			comboBoxMessage.getSelectionModel().select(0);
			camposOk = (ArrayList) conexion.getCamposConexion();
			int j = 0;
			gridPaneFields.getChildren().clear();
			for (int i = 0; i < camposOk.size(); i++) {
				gridPaneFields.addColumn(j, new JFXButton(camposOk.get(i).toString() + "  X"));
				if ((i + 1) % 16 == 0)
					j++;

			}

			buttonDelete.setVisible(true);
			buttonUpdate.setVisible(true);
		}
	}

	@FXML
	public void deleteConexion() {

		System.out.print("Cerrar");
		
		JsonObject jsonObject = new JsonObject();		
		Conexion conection = tableViewConections.getSelectionModel().getSelectedItem().getValue();
		
		jsonObject.addProperty("id", conection.getId());
		System.out.print(jsonObject.toString());
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target("http://localhost:8080/conections/deleteConectionService");
		Response response = target.request().post(Entity.entity(jsonObject.toString(), MediaType.APPLICATION_JSON));
		String value = response.readEntity(String.class);
		leerConexion();

	}
	
	@FXML
	public void updateConection() {

		System.out.print("Update");
		
		Conexion conection = tableViewConections.getSelectionModel().getSelectedItem().getValue();
		
		conexion = new Conexion(textFieldIPName.getText(), textFieldIP.getText(), textFieldPort.getText(),
				((String) comboBoxType.getSelectionModel().getSelectedItem()),
				((String) comboBoxSense.getSelectionModel().getSelectedItem()),
				((String) comboBoxProduct.getSelectionModel().getSelectedItem()),
				((String) comboBoxMessage.getSelectionModel().getSelectedItem()), camposOk);
		
		conexion.setId(conection.getId());

		Gson gson = new Gson();
		String jsonSaveConexion = gson.toJson(conexion);
		// conexionTableOb.add(conexion.);
		System.out.print(jsonSaveConexion);
		// Step2: Now pass JSON File Data to REST Service
		try {
			URL url = new URL("http://localhost:8080/conections/updateConectionService");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			out.write(jsonSaveConexion);
			out.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			leerConexion();

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
	public void clearForm() {

		crearForm();
		buttonDelete.setVisible(false);
		buttonUpdate.setVisible(false);
		


	}
	
	public void crearForm() {
		
		
		textFieldIPName.setText("");
		textFieldIP.setText("");
		textFieldPort.setText("");
		comboBoxType.getSelectionModel().clearSelection();
		comboBoxSense.getSelectionModel().clearSelection();
		comboBoxProduct.getSelectionModel().clearSelection();
		comboBoxMessage.getSelectionModel().clearSelection();
		camposOk = (ArrayList) new ArrayList<CamposConexion>();
		gridPaneFields.getChildren().clear();
		
		
	}

	@FXML
	public void activeFields() {

		if (toogleButtonField.isSelected()) {
			comboBoxMessage.setDisable(false);
			comboBoxSense.setDisable(false);
			comboBoxProduct.setDisable(false);
			gridPaneFields.setDisable(false);
			textFieldAdd.setDisable(false);
		} else {
			comboBoxMessage.setDisable(true);
			comboBoxSense.setDisable(true);
			comboBoxProduct.setDisable(true);
			gridPaneFields.setDisable(true);
			textFieldAdd.setDisable(true);
		}

	}

	@FXML
	public void updateFields() {

//		GridPane gridPaneFields = new GridPane();
//		comboBoxField.getValue().toString()
//

		gridPaneFields.getChildren().clear();
		String camposAdd[] = textFieldAdd.getText().split(",");
		boolean valido = true;
		for (int i = 0; i < camposAdd.length; i++) {
			int campo1 = Integer.parseInt(camposAdd[i].substring(0, camposAdd[i].length() - 1));
			;
			for (int j = i + 1; j < camposAdd.length; j++) {
				System.out.println(camposAdd[i]);
				int campo2 = Integer.parseInt(camposAdd[j].substring(0, camposAdd[j].length() - 1));
				if (campo1 == campo2) {
					valido = false;
				}

			} // String.format("%03d",
			if (valido)
				this.camposOk.add(new CamposConexion(campo1,
						camposAdd[i].substring(camposAdd[i].length() - 1, camposAdd[i].length())));

			valido = true;
		}

		int j = 0;
		for (int i = 0; i < camposOk.size(); i++) {
			gridPaneFields.addColumn(j, new JFXButton(camposOk.get(i).toString() + "  X"));
			if ((i + 1) % 16 == 0)
				j++;

		}

	}
	
	
	
	//Consumo de WEb Services de Aqui en Adelante

	public void leerConexion() {

		System.out.println("Leer Conexion");

		try {

			ResteasyClient client = new ResteasyClientBuilder().build();
			ResteasyWebTarget target = client.target("http://localhost:8080/conections/getConectionsService");
			Response response = target.request().get();
			String value = response.readEntity(String.class);

			response.close();
			Gson gson = new Gson();
			Type conexionListType = new TypeToken<List<Conexion>>() {
			}.getType();
			List<Conexion> conexion = gson.fromJson(value, conexionListType);
			System.out.println("\nconexionid" +value);
			conexionTableOb.clear();
			conexionTableOb.addAll(conexion);

		} catch (Exception e) {
			System.out.println("\nError while calling Crunchify REST Service");
			e.printStackTrace();
		}

	}

	public void saveConexion() {

		System.out.println("Guardar");

		conexion = new Conexion(textFieldIPName.getText(), textFieldIP.getText(), textFieldPort.getText(),
				((String) comboBoxType.getSelectionModel().getSelectedItem()),
				((String) comboBoxSense.getSelectionModel().getSelectedItem()),
				((String) comboBoxProduct.getSelectionModel().getSelectedItem()),
				((String) comboBoxMessage.getSelectionModel().getSelectedItem()), camposOk);

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String jsonSaveConexion = gson.toJson(conexion);
		// conexionTableOb.add(conexion.);
		System.out.print(jsonSaveConexion);
		// Step2: Now pass JSON File Data to REST Service
		try {
			URL url = new URL("http://localhost:8080/conections/putConectionService");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			out.write(jsonSaveConexion);
			out.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			leerConexion();

			while (in.readLine() != null) {
			}
			System.out.println("\nCrunchify REST Service Invoked Successfully..");
			in.close();
		} catch (Exception e) {
			System.out.println("\nError while calling Crunchify REST Service");
			System.out.println(e);
		}

	}

	public void initConexion() {

		System.out.println("InitConexion");

		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("command", "play");

		// Step2: Now pass JSON File Data to REST Service
		try {
			URL url = new URL("http://localhost:8080/conections/sendCommandService");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			out.write(jsonObject.getAsString());
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

}
