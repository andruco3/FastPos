package com.witty.server;

import com.constant.Constants;
import com.witty.entity.CamposModel;
import com.witty.entity.TramaModel;

import java.util.ArrayList;

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
 * Created by ggpratama on 10/7/2015.
 */
public class ServerApplicationListener implements ISORequestListener,Configurable{

    private Configuration configuration;
    public void setConfiguration(Configuration configuration) throws ConfigurationException {
        this.configuration = configuration;
    }

    public boolean process(ISOSource isoSource, ISOMsg isoMsg) {
    	

    	System.out.print("Ingreseeee a el listener Server");
        String spaceN = configuration.get("space");
        Long timeout = configuration.getLong("spaceTimeout");
        String queueN = configuration.get("queue");
        Context context = new Context();
        Space<String,Context> space = SpaceFactory.getSpace(spaceN);
        try {
        	ISOMsg respMsg = new ISOMsg();
        	TramaModel trama = new TramaModel();
        	
        	for(int i = 0; i<128;i++) {    		
        		respMsg.set(i,((CamposModel)((ArrayList)trama.getCampos().getCampos()).get(i)).getValor());
        	} 	
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
