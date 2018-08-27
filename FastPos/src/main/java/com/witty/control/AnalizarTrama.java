package com.witty.control;

import org.analyzer.model.CamposModel;
import org.analyzer.model.TramaModel;
import org.analyzer.procesamiento.ProcesarMensajeMasterCard;
import org.apache.log4j.Logger;

import application.Main2;
import logger.LoggerAnalyzer;

public class AnalizarTrama {

	private static final String M_800 = "F0F8F1F0";
	private static final String M_810 = "F0F8F1F0";
	private static final String M_200 = "200";
	private static final String M_100 = "100";
	private static final String M_400 = "400";
	private static final String M_600 = "600";
	
	private static Logger log = Logger.getLogger(AnalizarTrama.class);


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoggerAnalyzer.configurarLogger();
		log.info("Iniciando Analyzer5 ");
		miscelanea.miscelanea.cargarArchivoMasters("");
		miscelanea.miscelanea.cargarArchivoMasters("810");
		//Main2.main(null);
		String tramaentrada = "F0F8F1F0C2200000820000020400000000000000F0F5F0F2F6F4F6F0F2F1F2F1F5F1F9F5F4F6F3F8F7F8F7F0F6F0F0F2F6F4F6F0F0F0F0F9D4C3C3D9D3D1D8C4F8F2F7F0";
		AnalizarTrama.analizarTrama(tramaentrada);

	}

	public static void analizarTrama(String tramaEntrada) {

		TramaModel trama = Descomponer.DescomponerTrama(tramaEntrada);
		TramaModel TramaSalida=null;
		trama.procesarMensaje();
		log.debug("El mensaje es" + trama.getMti().getValor());
		ProcesarMensajeMasterCard tramaMC = new	ProcesarMensajeMasterCard(trama);
		TramaSalida = tramaMC.procesarMensajeSalidaMasterCard();
		log.debug("Campo en Mensaje: valor: "+ ((CamposModel)TramaSalida.getCampos().getCampos().get(1)).getValor());
//		switch (trama.getMti().getValor()) {
//		case M_800:
//			TramaSalida=tramaMC.;
//		case M_200:
//			TramaSalida=AdminMessage.responseAdminMessage(trama);
//		case M_100:
//			TramaSalida=AdminMessage.responseAdminMessage(trama);
//		case M_400:
//			TramaSalida=AdminMessage.responseAdminMessage(trama);
//		case M_600:
//			TramaSalida=AdminMessage.responseAdminMessage(trama);
//
//		}
		
		
		String tramaSalidaString = Componer.componerTrama(TramaSalida);
		log.debug("Trama de Salida es: " + tramaSalidaString);
		
		
		

	}

}
