package com.witty.control;

import java.util.Formatter;
import java.util.List;

import org.analyzer.model.CamposModel;
import org.analyzer.model.TramaModel;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.log4j.Logger;

public class Descomponer {

	final int MENSAJE_MASTERCARD = 0;
	final int MENSAJE_VISA = 1;
	final int MENSAJE_BASE24 = 2;
	final int MENSAJE_JCB = 3;
	private static Logger log = Logger.getLogger(Descomponer.class);

	public Descomponer() {

	}
	// ****
	// Entradas: tramaEntrada: Corresponde a la trama de entrada, o trama a
	// descomponer
	// Salidas: Devuelve el Objeto Trama Model con todos los campos calculados
	// Este metodo basado en las longitud almacenado para cada trama descopone
	// todos los campos
	// Para saber que campos debe calcular llama a la funcion getBitMap
	// ***

	public static TramaModel DescomponerTrama(String tramaEntrada) {

		TramaModel tramaMasterCard = null;
		try {

			log.debug("Trama de Entrada:" + tramaEntrada);
			String tramaEntradaTpm = tramaEntrada;
			List<TramaModel> tramaModel;
			tramaMasterCard = SerializationUtils.clone(BaseDatos.leerBDTramaWhere("tipo", "MC").get(0));

			log.debug("Lectura de Base de ok:" + tramaEntrada);
			// Obtener el header
			// tramaMasterCard.getHeader().getLongitud() -> obtiene la longitud
			// del campo
			tramaMasterCard.getHeader()
					.setValor(tramaEntradaTpm.substring(0, tramaMasterCard.getHeader().getLongitud()));
			tramaEntradaTpm = tramaEntradaTpm.substring(tramaMasterCard.getHeader().getLongitud());
			log.debug("Trama restante Header:" + tramaMasterCard.getMti().getLongitud());
			// Obtener el MTI
			tramaMasterCard.getMti().setValorCampoMti(tramaEntradaTpm.substring(0, tramaMasterCard.getMti().getLongitud()));
			tramaEntradaTpm = tramaEntradaTpm.substring(tramaMasterCard.getMti().getLongitud());
			log.debug(" MTI:" + tramaMasterCard.getMti().getValor() + " - Trama restante: " + tramaMasterCard.getMti().getLongitud());
			// Asignar valor general al campo principal
			tramaMasterCard.getCampos().setValor(tramaEntradaTpm);

			// Se calculan los campos presentes en el BitMap primario
			int campos[] = getBitMap(tramaEntradaTpm.substring(0, 16));
						
			// Se verifica Si tiene BitMap Secundario
			if (campos[0] == 1) {
				log.debug("La trama tiene BitMap Secundario");
				campos = getBitMap(tramaEntradaTpm.substring(0, 32));
				tramaEntradaTpm=tramaEntradaTpm.substring(16);
			} else
				log.debug("Solo Bit Map Primario");

			// Se descompone los 128 campos.
			CamposModel campoTrama = null;
			for (int campo : campos) {
				campoTrama = (CamposModel) tramaMasterCard.getCampos().getCampos().get(campo);
				tramaEntradaTpm = campoTrama.setValorCampo(tramaEntradaTpm);
				log.debug("Campo :" + campoTrama.getCampo() + " - nombre: " + campoTrama.getNombre());
				log.debug("valor :" + campoTrama.getValor());
				log.debug("trama restante :" + tramaEntradaTpm);

			}
		} catch (Exception e) {

			log.error("Error en descomposicion de la trama: " + e);
			for (StackTraceElement element : e.getStackTrace())
				log.error(element);

		} finally {

			log.debug("Se finaliza la descomposicion de la trama> " +tramaMasterCard.getMti().getValor());
			return tramaMasterCard;

		}

	}

	public static int[] getBitMap(String bitmap) {

		log.trace("getBitMap - entrada: " + bitmap);
		char campos[];
		int decimal = 0;
		String binary = "";
		int temp = 0;
		char campoP[] = bitmap.toCharArray();
		for (int i = 0; i < campoP.length; i++) {
			decimal = Integer.parseInt("" + campoP[i], 16);
			temp = Integer.parseInt(Integer.toBinaryString(decimal));
			binary = binary.concat(String.valueOf(new Formatter().format("%04d", temp)));
		}

		int camposPresentes[] = new int[binary.replace("0","").length()];
		campos = binary.toCharArray();

		log.trace("getBitMap - Bitmap: " + binary + " - campos size: " + campos.length);
		int j = 0;
		for (int i = 0; i < campos.length - 1; i++) {
			if (campos[i] == '1') {
				camposPresentes[j] = i + 1;
				log.trace("getBitMap campos: " + camposPresentes[j]);
				j++;
			}

		}

		return camposPresentes;

	}

}
