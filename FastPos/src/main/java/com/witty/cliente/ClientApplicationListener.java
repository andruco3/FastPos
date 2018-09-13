package com.witty.cliente;

import com.constant.Constants;
import com.witty.controller.ConexionController;
import com.witty.entity.Conexion;

import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOFieldPackager;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOSource;
import org.jpos.space.Space;
import org.jpos.space.SpaceFactory;
import org.jpos.transaction.Context;


/**
 * Created by andruco on 10/7/2015.
 */
public class ClientApplicationListener implements ISORequestListener,Configurable{

	
	ConexionController conexionController;
	private Configuration configuration;
    public void setConfiguration(Configuration configuration) throws ConfigurationException {
        this.configuration = configuration;
    }

    public boolean process(ISOSource isoSource, ISOMsg isoMsg) {
    	conexionController=new ConexionController();
    	System.out.print("Ingreseeee a el listener cliente");
        String spaceN = configuration.get("space");
        Long timeout = configuration.getLong("spaceTimeout");
        String queueN = configuration.get("queue");
        String mux = configuration.get("mux");
        mux.replaceAll(mux, "");        
        
        Conexion conexion = conexionController.getPersistence().find(Integer.parseInt(mux));
        System.out.print(isoMsg.getChildren().get(1) + " ----- " + conexion.getNombreConexion());
        
        Context context = new Context();
        Space<String,Context> space = SpaceFactory.getSpace(spaceN);

        try {
            
        	
        	ISOMsg respMsg = new ISOMsg();
            System.out.print(isoMsg.getPackager().getDescription());
        
            isoMsg.dump(System.out, "");
            respMsg.setMTI("0810");
            //respMsg.setResponseMTI();
            respMsg.set(39,"20");

            context.put(Constants.REQUEST_KEY,isoMsg);
            context.put(Constants.RESPONSE_KEY,respMsg);
            context.put(Constants.RESOURCE_KEY,isoSource);

        } catch (ISOException e) {
            e.printStackTrace();
        }

        space.out(queueN,context,timeout);
        return false;
    }
}
