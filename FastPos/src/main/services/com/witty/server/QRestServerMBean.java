package com.witty.server;

import org.jpos.q2.QBeanSupportMBean;
public interface QRestServerMBean extends QBeanSupportMBean {
  void setPort(int port);
  int getPort();
}