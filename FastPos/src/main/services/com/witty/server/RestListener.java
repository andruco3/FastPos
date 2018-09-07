package com.witty.server;

import org.jpos.iso.ISOPackager;
import org.jpos.util.LogSource;
import org.jpos.util.Logger;
/**
 * This class is used for manual packager injection (future usage)<br/>
 * limit: one Listener only have one packager
 * @author Didik Hari
 *
 */
public class RestListener implements LogSource {
  protected ISOPackager packager;
  protected Logger logger;
  protected String realm;
  
  public RestListener(ISOPackager packager) {
    this.packager = packager;
  }
  public void setLogger(Logger logger, String realm) {
    this.logger = logger;
    this.realm = realm;
  }
  
  public String getRealm() {
    return this.realm;
  }
  
  public Logger getLogger() {
    return this.logger;
  }
  
}