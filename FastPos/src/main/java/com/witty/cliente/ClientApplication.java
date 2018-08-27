package com.witty.cliente;

import com.constant.Constants;
import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOFieldPackager;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOServer;
import org.jpos.iso.ISOSource;
import org.jpos.iso.packager.ISO87APackager;
import org.jpos.q2.QBeanSupport;
import org.jpos.q2.iso.QMUX;
import org.jpos.q2.iso.QServer;
import org.jpos.space.Space;
import org.jpos.space.SpaceFactory;
import org.jpos.transaction.Context;
import org.jpos.util.NameRegistrar;

import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by andruco on 13/08/2018.
 */
public class ClientApplication extends QBeanSupport {

    private ISOServer isoServer;

    @Override
    protected void startService() throws Exception {

        final QMUX qmux = (QMUX) NameRegistrar.getIfExists("mux.host-mux-1");
        isoServer = ISOServer.getServer("HostQServer501");
        	
             	
        	Timer timer = new Timer();
        	
    		timer.schedule(new TimerTask() {    			
    			public void run() {
    				//System.out.print("Holllllaaaaaaa9999aaaaaaaaaaaaa1:" + qmux.isConnected()  +" ------"  + (isoServer.getConnections() > 0));
    				if (qmux != null && false) {
    					sendEchoTest(qmux);
    				}
    			}
    		}, 0, 400);

    		
        	
        
    }
    
    
    private void sendEchoTest(QMUX qmux) {
		String stanId = "000001";
		Map<String, String> date = getDate();
		// ISOMsg reply = null;

		try {
			ISOMsg msg = new ISOMsg();
			String header= "ISO006000040";
			msg.setHeader(header.getBytes());
			msg.setMTI("0800");
			msg.set(7, date.get("bit7"));
			msg.set(11, stanId);
			msg.set(70, "301");
			msg.setPackager(new ISO87APackager());

			try {
				 qmux.request(msg,5000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (ISOException e) {
			e.printStackTrace();
		}
	}
    
    
    private static HashMap<String, String> getDate() {
		DateFormat dateFormat1 = new SimpleDateFormat("MMdd");
		DateFormat dateFormat2Bit7 = new SimpleDateFormat("HH");
		DateFormat dateFormat2Bit12 = new SimpleDateFormat("HH");
		DateFormat dateFormat3 = new SimpleDateFormat("mmss");

		TimeZone timeZone = TimeZone.getTimeZone("GMT+00");
		TimeZone timeZone2 = TimeZone.getTimeZone("GMT+07");

		dateFormat1.setTimeZone(timeZone);
		dateFormat2Bit7.setTimeZone(timeZone); // CR#3
		dateFormat2Bit12.setTimeZone(timeZone2); // CR#3
		dateFormat3.setTimeZone(timeZone);

		Date newDate = new Date();
		String bit7 = dateFormat1.format(newDate) + dateFormat2Bit7.format(newDate) + dateFormat3.format(newDate);
		String bit12 = dateFormat2Bit12.format(newDate) + dateFormat3.format(newDate);
		String bit13 = dateFormat1.format(newDate);
		String bit15 = Integer.toString(Integer.parseInt(bit13) + 1);

		HashMap<String, String> result = new HashMap<String, String>();

		result.put("bit7", bit7);
		result.put("bit12", bit12);
		result.put("bit13", bit13);
		result.put("bit15", bit15);

		return result;
	}

}
