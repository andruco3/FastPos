package com.witty.control;

import java.util.List;

import org.analyzer.model.CamposModel;
import org.analyzer.model.TramaModel;
import org.apache.log4j.Logger;

public class Componer {
	
	final int MENSAJE_MASTERCARD = 0;
	final int MENSAJE_VISA = 1;
	final int MENSAJE_BASE24 = 2;
	final int MENSAJE_JCB = 3;
	private static Logger log = Logger.getLogger(Componer.class);
	
	
	public static String componerTrama(TramaModel tramaSalida){
		
		String tramaSalidaStr=null;
		
		//Se arma el header de la trama
	//	log.debug("valor del header: " + CampoSalida.getHeader().getValor()); 
	//	tramaSalida=CampoSalida.getHeader().getValor();
		
		//Se arma el tipo de mensaje
		tramaSalidaStr=tramaSalidaStr + tramaSalida.getMti().getValorCampoMti();
		
		//Se arma los campos
		List<CamposModel> campos=tramaSalida.getCampos().getCampos();
		
		for(CamposModel campo:campos){
			log.debug("campo.getPresente(): "+campo.getPresente());
			if("M".equals(campo.getPresente()))
				tramaSalidaStr=tramaSalidaStr+campo.getValorCampo();
		}
		return tramaSalidaStr;
		
	}

}
