package com.witty.selector;

import com.constant.Constants;
import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.transaction.Context;
import org.jpos.transaction.GroupSelector;

import java.io.Serializable;

/**
 * Created by ggpratama on 10/7/2015.
 */
public class Selector implements GroupSelector,Configurable{
    private Configuration configuration;
    
    public void setConfiguration(Configuration configuration) throws ConfigurationException {
        this.configuration = configuration;
    }

    
    public String select(long l, Serializable serializable) {
    	System.out.print("Ingreseeee a el Selector ");
        Context ctx = (Context)serializable;
        ISOMsg resIsoMsg = (ISOMsg)ctx.get(Constants.REQUEST_KEY);
        String selector = "";
        try {
            selector = configuration.get(resIsoMsg.getMTI());
        } catch (ISOException e) {
            e.printStackTrace();
        }
        return selector;
    }

    
    public int prepare(long l, Serializable serializable) {
        return PREPARED|ABORTED|NO_JOIN;
    }

    
    public void commit(long l, Serializable serializable) {

    }

    
    public void abort(long l, Serializable serializable) {

    }
}
