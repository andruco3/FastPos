/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miscelanea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.witty.control.BaseDatos;
import com.witty.entity.CamposModel;
import com.witty.entity.ConfigMessage;
import com.witty.entity.TramaModel;
import com.witty.persistence.CamposModelPersistence;
import com.witty.persistence.ConfigMessagePersistence;
import com.witty.persistence.TramaModelPersistence;

/**
 *
 * @author root
 */
public class Miscelanea {

	public static int hex2decimal(String s) {
		String digits = "0123456789ABCDEF";
		s = s.toUpperCase();
		int val = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int d = digits.indexOf(c);
			val = 16 * val + d;
		}
		return val;
	}

	// public static void cargarArchivoIso8583() {
	//
	// File archivo = null;
	// FileReader fr = null;
	// BufferedReader br = null;
	// List<CamposTramaModel> T1inial = new ArrayList<>();
	// CamposTramaModel trama = new CamposTramaModel();
	// trama.setNombre("ISO8583");
	// trama.setDescripcion("Trama base del estandar ISO8583");
	// trama.settipo("C");
	// List<CamposTramaModel> campos = new ArrayList<>();
	// trama.setCampos(campos);
	// try {
	// // Apertura del fichero y creacion de BufferedReader para poder
	// // hacer una lectura comoda (disponer del metodo readLine()).
	// archivo = new File("..//CamposISO8583");
	// fr = new FileReader(archivo);
	// br = new BufferedReader(fr);
	// System.out.println("Retornare");
	// String linea;
	// // public CamposTramaModel(String nombre,String descripcion,Boolean
	// // variable,
	// // String longitud,String tipo){
	// br.readLine();
	// while ((linea = br.readLine()) != null) {
	// String[] campoSplit = new String[3];
	// campoSplit = linea.split("\t");
	//
	// // System.out.print( "\nimpresiokn: "+campoSplit[1].split("
	// // ")[1]);
	//
	// CamposTramaModel campo = new CamposTramaModel(campoSplit[0],
	// campoSplit[2], "",
	// campoSplit[1].contains("."), campoSplit[1].split(" ")[1].replace(".",
	// "").trim(),
	// campoSplit[1].split(" ")[0]);
	// campos.add(campo);
	//
	// }
	// T1inial.add(trama);
	// BaseDatos.guardarBD(T1inial);
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// // En el finally cerramos el fichero, para asegurarnos
	// // que se cierra tanto si todo va bien como si salta
	// // una excepcion.
	// try {
	// if (null != fr) {
	//
	// fr.close();
	//
	// }
	// } catch (Exception e2) {
	// e2.printStackTrace();
	//
	// }
	// }
	//
	// }

	public static void cargarArchivoMasters(String mti) {

		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		TramaModel TramaMasterCard = new TramaModel();
		//TramaMasterCard.setTipo("MC"+mti);
		CamposModel trama = new CamposModel();
		trama.setNombre("Trama MasterCard "+mti);
		Collection<CamposModel> campos = new ArrayList<CamposModel>();
		
		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File("//home//andres//Escritorio//CamposMastercard"+mti);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			System.out.println("Retornare");
			String linea;
			// public CamposTramaModel(String nombre,String descripcion,Boolean
			// variable,
			// String longitud,String tipo){
			br.readLine();
			while ((linea = br.readLine()) != null) {
				String[] campoSplit = new String[4];
				campoSplit = linea.split("\t");

				System.out.print("\nimpresiokn: " + linea);

				CamposModel campo = new CamposModel(campoSplit[0], campoSplit[1], "", campoSplit[3].contains("."),
						Integer.parseInt(campoSplit[3].replace(".", "").trim()), campoSplit[2],campoSplit[4]);
				BaseDatos.guardarBDCampo(campo);
				campos.add(campo);

			}
			
			//TramaMasterCard.setCampos(trama);
			//BaseDatos.guardarBDCampo(trama);
			
			trama.setCampos(campos);
			BaseDatos.guardarBDCampo(trama);
	/*		
			//Adciionar Header//
			CamposModel campoHeader = new CamposMasterCard();
			campoHeader.setLongitud(0);
			TramaMasterCard.setHeader(campoHeader);
			BaseDatos.guardarBDCampo(campoHeader);
			//Adicionar MTI
			CamposModel campoMTI= new CamposMasterCard();
			campoMTI.setLongitud(8);
			TramaMasterCard.setMti(campoMTI);
			BaseDatos.guardarBDCampo(campoMTI);
			
			///
			BaseDatos.guardarBDTrama(TramaMasterCard);
*/
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {

					fr.close();

				}
			} catch (Exception e2) {
				e2.printStackTrace();

			}
		}

	}

	// public static void actualizarArchivoMaster() {
	//
	// List<CamposTramaModel> trama = BaseDatos.leerBDWhere("tipo", "C");
	//
	// for (int i = 0; i < trama.get(1).getCampos().size(); i++) {
	// ((CamposTramaModel) trama.get(1).getCampos().get(i)).setValor(null);
	//
	// }
	// BaseDatos.guardarBD(trama);
	// System.out.print("\nok");
	// }

	public static void writeFile2() {
		FileWriter fw;
		try {
			fw = new FileWriter("out.txt");
			for (int i = 0; i < 10; i++) {
				fw.write("something");
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public static void loadFields(String nombre) {
		
		  try {
	            File archivo = new File(System.getProperty("user.dir")+System.getProperty("file.separator")+"cfg"+System.getProperty("file.separator")+"packager"+System.getProperty("file.separator")+"base24.xml");
	            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
	            Document document = documentBuilder.parse(archivo);
	            document.getDocumentElement().normalize();
	            System.out.println("Elemento raiz:" + document.getDocumentElement().getNodeName());
	            NodeList isofield = document.getElementsByTagName("isofield");
	            TramaModel trama=new TramaModel();
	            trama.setNombre(nombre);
	            ConfigMessagePersistence config =new ConfigMessagePersistence();
	            ConfigMessage cMessage = config.find(0);
	            trama.setTipo(cMessage);
	            CamposModel campos=new CamposModel();
	            Collection<CamposModel> camposM=new ArrayList<CamposModel>();
	            campos.setCampos(camposM);
	            CamposModelPersistence camposPer=new CamposModelPersistence();
	            
	            for (int temp = 0; temp < isofield.getLength(); temp++) {
	                Node nodo = isofield.item(temp);
	                System.out.println("Elemento:" + nodo.getNodeName());
	                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
	                    Element element = (Element) nodo;
	                    CamposModel campo1=new CamposModel();
	                    campo1.setNCampo(element.getAttribute("id"));
	                    campo1.setLongitud(Integer.parseInt(element.getAttribute("length")));
	                    campo1.setNombre(element.getAttribute("name"));
	                    campo1.setFormato(element.getAttribute("class"));
	                    camposPer=new CamposModelPersistence();
	                    camposPer.create(campo1);
	                    camposM.add(campo1);
	                    System.out.println("id: " + element.getAttribute("id"));
	                    System.out.println("Nombre: " + element.getAttribute("length"));
	                    System.out.println("username: " + element.getAttribute("name"));
	                    System.out.println("password: " + element.getAttribute("class"));
	                }
	            }
	            camposPer=new CamposModelPersistence();
                camposPer.create(campos);
	            trama.setCampos(campos);
	            TramaModelPersistence tramaPe=new TramaModelPersistence();
	            tramaPe.create(trama);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    
		
		
		
		
	}

}
