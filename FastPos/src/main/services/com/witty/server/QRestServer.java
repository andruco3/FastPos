package com.witty.server;

import java.lang.reflect.Constructor;
import java.util.Iterator;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.jdom.Element;
import org.jpos.iso.ISOPackager;
import org.jpos.q2.QBeanSupport;
import org.jpos.q2.QFactory;
import org.jpos.util.NameRegistrar;
/**
 * Starting the jetty server
 * @author Didik Hari
 * @since 26 May 2016
 */
public class QRestServer extends QBeanSupport implements QRestServerMBean {
  private Server server;
  private int port;
  
  public QRestServer() {
    super();
  }
  
  @Override
  protected void startService() throws Exception {
    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");
    context.addServlet(new ServletHolder(new ServletContainer(resourcesConfig())), "/*");
    
    server = new Server(port);
    server.setHandler(context);    
    server.start();
    NameRegistrar.register(getName(), this);
  }
  
  @SuppressWarnings("rawtypes")
  private ResourceConfig resourcesConfig() throws Exception {
    ResourceConfig resourceConfig = new ResourceConfig();
    QFactory factory = getFactory();
    Iterator iterator = getPersist().getChildren("rest-listener").iterator();
    while (iterator.hasNext()) {
      Element l = (Element) iterator.next();
      
      Class<?> cl = Class.forName(l.getAttributeValue ("class"));
      Constructor<?> cons = cl.getConstructor(ISOPackager.class);
      
      String packagerName = l.getAttributeValue ("packager");
      ISOPackager packager = null;
          if (packagerName != null) {
              packager = (ISOPackager) factory.newInstance (packagerName);
          }
          RestListener listener = (RestListener) cons.newInstance(packager);
          
      factory.setLogger (listener, l);
            factory.setConfiguration (listener, l);
            
            resourceConfig.register(listener);
    }
    return resourceConfig;
  }
  @Override
  protected void stopService() throws Exception {
    server.stop();
    server.destroy();
    NameRegistrar.unregister(getName());
  }
  public void setPort(int port) {
    this.port = port;
  }
  public int getPort() {
    return this.port;
  }
}