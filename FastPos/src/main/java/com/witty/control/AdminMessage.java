package com.witty.control;
//
//import java.util.List;
//
//import org.analyzer.model.CamposBase24;
//import org.analyzer.model.CamposMasterCard;
//import org.analyzer.model.CamposModel;
//import org.analyzer.model.TramaModel;
//import org.analyzer.procesamiento.Mensaje;
//import org.apache.commons.lang3.SerializationUtils;
//import org.apache.log4j.Logger;
//
public class AdminMessage{}
//public class AdminMessage extends Mensaje {
//
//	private static final String SIGN_ON = "001";
//	private static final String SIGN_OFF = "002";
//	private static final String ECHO_TEST = "F2F7F0";
//	private static final String PEK_EXCHANGE = "161";
//	private static final String PEK_EXCHANGE_ON_DEM = "162";
//	
//	private static Logger log = Logger.getLogger(Descomponer.class);
//
//	public AdminMessage(TramaModel trama) {
//
//	}
//
//	public static TramaModel responseAdminMessage(TramaModel tramaEntrada) {
//		
//		log.debug("Se contestara el mensaje 0800" + tramaEntrada.getTipo() +" - " + ((CamposModel)tramaEntrada.getCampos().getCampos().get(70)).getValor());
//
//		switch (((CamposModel)tramaEntrada.getCampos().getCampos().get(70)).getValor()) {
//		case SIGN_ON:
//			return adminMessageSingOn(tramaEntrada);
//		case SIGN_OFF:
//			return adminMessageSingOff(tramaEntrada);
//		case ECHO_TEST:
//			return adminMessageSingEcho(tramaEntrada);
//		case PEK_EXCHANGE:
//			return adminMessagePekExchange(tramaEntrada);
//		case PEK_EXCHANGE_ON_DEM:
//			return adminMessagePekExchangeOnDemand(tramaEntrada);
//		}
//
//		return null;
//	}
//
//	public static TramaModel adminMessageSingOn2(TramaModel tramaEntrada) {
//
//		TramaModel tramaSalida = getCamposTrama();
//		List<CamposModel> camposEntrada = tramaEntrada.getCampos().getCampos();
//		List<CamposModel> camposSalida = tramaSalida.getCampos().getCampos();
//
//		//setP39Exitoso(camposSalida);
//		setDE63(camposSalida);
//		super.armarCamposVisibles();
//		return tramaSalida;
//
//	}
//
//	public static TramaModel adminMessageSingOff(TramaModel campos) {
//
//		return new TramaModel();
//	}
//
//	public static TramaModel adminMessageSingEcho(TramaModel tramaEntrada) {
//		
//		TramaModel tramaSalida = getCamposTrama();
//		List<CamposModel> camposEntrada = tramaEntrada.getCampos().getCampos();
//		List<CamposModel> camposSalida = tramaSalida.getCampos().getCampos();
//		setDE63(camposSalida);
//		
//		return new TramaModel();
//	}
//
//	public static TramaModel adminMessagePekExchange(TramaModel campos) {
//
//		return new TramaModel();
//	}
//
//	public static TramaModel adminMessagePekExchangeOnDemand(TramaModel campos) {
//
//		return new TramaModel();
//	}
//
//	public static CamposModel getCamposActive() {
//
//		return new CamposMasterCard();
//	}
//
//	public static TramaModel getCamposTrama() {
//
//		return SerializationUtils.clone(BaseDatos.leerBDTramaWhere("tipo", "810").get(0));
//	}
//
//	public static void setDE63(List<CamposModel> camposSalida){
//		
//		camposSalida.get(63).setValor("MCCRLJQD8");
//		
//	}
//}