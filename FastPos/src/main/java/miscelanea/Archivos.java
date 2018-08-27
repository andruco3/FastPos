package miscelanea;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Archivos {

	public static String[] leerArchivoTramas(String archivo) throws FileNotFoundException, IOException {
		String cadena;
		String temp = "";
		String temp2 = "";
		String mensajes[] = new String[100000];
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);
		int k = 0;
		while ((cadena = b.readLine()) != null && k < 100000) {
			if (cadena.contains("17/03/13")) {
				// Archivos.EscribirArchivo(temp);
				if (temp2 != "" && temp2 != "\n") {
					mensajes[k] = temp2;
					// Archivos.EscribirArchivo(temp);
					k++;
					temp2 = "";
				}

				temp = cadena;
			} else {
				temp = temp + "\n" + cadena;
				if (!cadena.contains("SOURCE") && !cadena.contains("DEST") && cadena != "\n" && cadena != ""
						&& !cadena.contains("$DATA") && !cadena.contains("RECD")) {
					if (temp2 != "")
						temp2 = temp2 + "\n" + cadena;
					else
						temp2 = cadena;

				}

			}

		}
		b.close();
		return mensajes;
	}

	public static void EscribirArchivo(String mensaje) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {

			fichero = new FileWriter("C:/Users/usrapl/Documents/DIEGO-CORREDOR/prueba.txt", true);
			pw = new PrintWriter(fichero);
			// System.out.println(mensaje);

			pw.append(mensaje);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
	
	
	public static String leerArchivo(String archivo) throws FileNotFoundException, IOException {
		String cadena;
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);
		cadena = b.readLine();
		b.close();
		System.out.println("cadena:" + cadena);
		return cadena;
	}

}
