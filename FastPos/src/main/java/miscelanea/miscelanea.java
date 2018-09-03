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

import com.witty.control.BaseDatos;
import com.witty.entity.CamposModel;
import com.witty.entity.TramaModel;

/**
 *
 * @author root
 */
public class miscelanea {

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
		TramaMasterCard.setTipo("MC"+mti);
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

}
