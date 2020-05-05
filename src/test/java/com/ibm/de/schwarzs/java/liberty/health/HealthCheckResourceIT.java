package com.ibm.de.schwarzs.java.liberty.health;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HealthCheckResourceIT {

	private static String baseUrl;
	private static final String HEALTH_ENDPOINT = "/api/health";

	private Client client;
	private Response response;

	@BeforeAll
	public static void oneTimeSetup() {
		final String port = System.getProperty("http.port", "9080");
		baseUrl = "http://localhost:" + port;
	}

	@BeforeEach
	public void setup() {
		this.response = null;
		this.client = ClientBuilder.newClient();
	}

	@AfterEach
	public void teardown() {
		this.response.close();
		this.client.close();
	}

	@Test
	public void testHealthEndpoint() {
		this.response = this.client.target(baseUrl + HEALTH_ENDPOINT).request().get();
		Assertions.assertEquals(200, this.response.getStatus(), "Incorrect response code.");
	}
}
