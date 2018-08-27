package com.witty.participant;

import com.constant.Constants;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOSource;
import org.jpos.transaction.Context;
import org.jpos.transaction.TransactionParticipant;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by ggpratama on 10/7/2015.
 */
public class NetworkParticipant implements TransactionParticipant{

    public int prepare(long l, Serializable serializable) {
    	System.out.print("Ingreseeee al NEtwordk ");
        Context ctx = (Context)serializable;
        
        //Set Response for Network Check
        ISOSource source= (ISOSource)ctx.get(Constants.RESOURCE_KEY);
        ISOMsg respMsg = (ISOMsg)ctx.get(Constants.RESPONSE_KEY);
        ISOMsg reqMsg = (ISOMsg)ctx.get(Constants.REQUEST_KEY);
        sendEchoTestResponse(respMsg,reqMsg);
		ctx.put(Constants.RESPONSE_KEY,respMsg);
        return PREPARED;
    }

    public void commit(long l, Serializable serializable) {

    }


    public void abort(long l, Serializable serializable) {
    }
    
	/**
	 * Send echo test response.
	 * 
	 * @param source
	 *             channel
	 * @param m
	 *            message from client
	 */
	private void sendEchoTestResponse(ISOMsg msg, ISOMsg reqMsg) {
		try {
			msg.setHeader("ISO006000040".getBytes());
			msg.set(7,  reqMsg.getString(7));
			msg.set(11, reqMsg.getString(11));
			msg.set(39, "25");
			msg.set(70, "001");

		} catch (ISOException e) {
			e.printStackTrace();
		}
	}
 
}
