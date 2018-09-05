package com.crunchify.tutorials;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.jpos.q2.Q2;

import com.sun.jersey.spi.container.servlet.ServletContainer;

import application.ServerQ2Init;

public class FastPosServlet extends ServletContainer
{
 
    public void init() throws ServletException
    {
    	
    	super.init();
          System.out.println("----------");
          System.out.println("---------- CrunchifyServletExample Initialized successfully ----------");
          System.out.println("----------");
          
          ServerQ2Init q2Server=new ServerQ2Init();
    }

}
