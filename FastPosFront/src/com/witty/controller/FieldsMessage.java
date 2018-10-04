package com.witty.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import com.witty.entity.ConfigMessage;
import com.witty.entity.TramaModel;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.CheckBoxTreeTableCell;
import javafx.scene.control.cell.ComboBoxTreeTableCell;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class FieldsMessage {
	
	@FXML
	private JFXComboBox comboBoxTramas;
	
	@FXML
	private JFXTreeTableView<CamposModel> tableViewTramas;
	
	private ObservableList<CamposModel> camposModelTableOb = FXCollections.observableArrayList();

	
	private ObservableList<TramaModel> optionscomboBoxTramas = FXCollections.observableArrayList();
	
	@FXML
	public void initialize() throws IOException {
		
		optionscomboBoxTramas.clear();
		
		
		
		comboBoxTramas.setCellFactory(new Callback<ListView<TramaModel>,ListCell<TramaModel>>(){
			 
            @Override
            public ListCell<TramaModel> call(ListView<TramaModel> p) {
                 
                final ListCell<TramaModel> cell = new ListCell<TramaModel>(){
 
                    @Override
                    protected void updateItem(TramaModel t, boolean bln) {
                        super.updateItem(t, bln);
                         
                        if(t != null){
                            setText(t.getNombre());
                        }else{
                            setText(null);
                        }
                    }
  
                };
                 
                return cell;
            }
        });
		
		
		TreeTableColumn columnaA = new TreeTableColumn("Campo");
		TreeTableColumn columnaB = new TreeTableColumn("Nombre");
		TreeTableColumn columnaC = new TreeTableColumn("Clase");
		TreeTableColumn columnaD = new TreeTableColumn("Nombre");
		tableViewTramas.getColumns().addAll(columnaA, columnaB, columnaC,columnaD);

		columnaA.setCellValueFactory(new TreeItemPropertyValueFactory<CamposModel, String>("campo"));
		columnaB.setCellValueFactory(new TreeItemPropertyValueFactory<CamposModel, String>("nombre"));
		columnaC.setCellValueFactory(new TreeItemPropertyValueFactory<CamposModel, String>("clase"));
		

		columnaD.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<CamposModel, String>, //
				ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CamposModel, String> param) {
				TreeItem<CamposModel> treeItem = param.getValue();
				CamposModel emp = treeItem.getValue();
				SimpleStringProperty booleanProp = new SimpleStringProperty(emp.getClase());

				// Note: singleCol.setOnEditCommit(): Not work for
				// CheckBoxTreeTableCell.
				// When "Single?" column change.
				booleanProp.addListener(new ChangeListener<String>() {

					@Override
					public void changed(ObservableValue<? extends String> observable, String oldValue,
							String newValue) {
						emp.setClase(newValue);
					}
				});
				return booleanProp;
			}
		});

//		columnaD.setCellFactory(new Callback<TreeTableColumn<CamposModel, String>, TreeTableCell<CamposModel, String>>() {
//			@Override
//			public TreeTableCell<CamposModel, String> call(TreeTableColumn<CamposModel, String> p) {
//				ComboBoxTreeTableCell<CamposModel, String> cell = new ComboBoxTreeTableCell<CamposModel, String>();
//				cell.setEditable(true);
//				cell.setAlignment(Pos.CENTER);
//				return cell;
//			}
//		});
		
		ObservableList<String> optionscomboBoxClass = FXCollections.observableArrayList();
		optionscomboBoxClass.add("combo");
		optionscomboBoxClass.add("combo2");
		
		columnaD.setCellFactory(ComboBoxTreeTableCell.forTreeTableColumn(optionscomboBoxClass));

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
		comboBoxTramas.setItems(optionscomboBoxTramas);
		comboBoxTramas.getSelectionModel().select(0);
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
			optionscomboBoxTramas.addAll(tramaModel);
			System.out.println("\nconexionid" +tramaModel.get(0).getCampos().getCampos().size());
			camposModelTableOb.clear();
			camposModelTableOb.addAll(tramaModel.get(0).getCampos().getCampos());

		} catch (Exception e) {
			System.out.println("\nError while calling Crunchify REST Service");
			e.printStackTrace();
		}

	}
	
	
	@FXML
	public void updateFields() {

		System.out.print("Update");
		
		TramaModel tramaModel = ((TramaModel)comboBoxTramas.getSelectionModel().getSelectedItem());
		
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String jsonSaveConexion = gson.toJson(tramaModel);
		// conexionTableOb.add(conexion.);
		System.out.print(jsonSaveConexion);
		// Step2: Now pass JSON File Data to REST Service
		try {
			URL url = new URL("http://localhost:8080/interpreter/updateTramaService");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			out.write(jsonSaveConexion);
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
