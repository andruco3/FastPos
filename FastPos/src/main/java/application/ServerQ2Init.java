package application;

import org.jpos.q2.Q2;

public class ServerQ2Init {
	
	
	public ServerQ2Init(){
		
		
        Q2 q2 = new Q2();
	        q2.start();
	        System.out.print("Started Q2 Service");
		
		
	}

}
