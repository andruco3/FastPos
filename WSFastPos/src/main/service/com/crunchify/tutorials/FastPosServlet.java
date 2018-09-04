package com.crunchify.tutorials;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.jpos.q2.Q2;

public class FastPosServlet extends HttpServlet
{
 
    public void init() throws ServletException
    {
          System.out.println("----------");
          System.out.println("---------- CrunchifyServletExample Initialized successfully ----------");
          System.out.println("----------");
          
//          Q2 q2 = new Q2();
//	        q2.start();
//	        System.out.print("Started Q2 Service");
    }

}
