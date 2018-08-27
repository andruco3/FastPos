package com.witty.participant;

import com.constant.Constants;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.transaction.Context;
import org.jpos.transaction.TransactionParticipant;

import java.io.Serializable;

/**
 * Created by ggpratama on 10/7/2015.
 */
public class TransactionResponseParticipant implements TransactionParticipant{
   
    public int prepare(long l, Serializable serializable) {
        Context ctx = (Context)serializable;
        ISOMsg reqMsg = (ISOMsg)ctx.get(Constants.REQUEST_KEY);
        ISOMsg respMsg = (ISOMsg)ctx.get(Constants.RESPONSE_KEY);
        try {
        	respMsg.setMTI(reqMsg.getMTI());
        	respMsg.setHeader(reqMsg.getHeader());
        	respMsg.setResponseMTI();
            respMsg.set(39,"00");
            ctx.put(Constants.RESPONSE_KEY,respMsg);
        } catch (ISOException e) {
            e.printStackTrace();
        }
        return PREPARED;
    }

    
    public void commit(long l, Serializable serializable) {

    }

   
    public void abort(long l, Serializable serializable) {

    }
}
