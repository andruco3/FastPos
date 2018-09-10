package com.witty.webservices;

import java.sql.Timestamp;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.util.StringUtil;
import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.iso.ISOPackager;
import org.jpos.util.LogEvent;
import org.jpos.util.LogSource;
import org.jpos.util.Logger;
import org.jpos.util.NameRegistrar;
import org.jpos.util.NameRegistrar.NotFoundException;
//import com.witty.server.QRestClient;
import com.witty.server.RestListener;

@Path("/jpos-rest/v1/")
public class TestController extends RestListener implements LogSource, Configurable {
	public TestController(ISOPackager packager) {
		super(packager);
	}

	@GET
	@Path(value = "account-status")
	@Produces(MediaType.APPLICATION_JSON)
	public Response accountStatus() {
		try {
			String responseJson = "[{\"msg\":\"this is response\"}]";
			return Response.status(200).entity(responseJson).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(204).build();
	}

	public void setConfiguration(Configuration cfg) throws ConfigurationException {
		// TODO getting the config
	}
}