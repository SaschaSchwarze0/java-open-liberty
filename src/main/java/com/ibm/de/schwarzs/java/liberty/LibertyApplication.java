package com.ibm.de.schwarzs.java.liberty;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.ibm.de.schwarzs.java.liberty.health.HealthCheckResource;
import com.ibm.de.schwarzs.java.liberty.health.HealthCheckServiceImpl;

@ApplicationPath("/api")
public class LibertyApplication extends Application {

	@Override
	public Set<Object> getSingletons() {
		final Set<Object> set = new HashSet<>();
		set.add(new HealthCheckResource(new HealthCheckServiceImpl()));
		return set;
	}
}
