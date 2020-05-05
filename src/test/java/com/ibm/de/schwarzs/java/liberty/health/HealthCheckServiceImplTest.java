package com.ibm.de.schwarzs.java.liberty.health;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HealthCheckServiceImplTest {

	@Test
	public void testIsJvmHealthy() {
		final HealthCheckService healthCheckService = new HealthCheckServiceImpl();
		Assertions.assertTrue(healthCheckService.isJvmHealthy());
	}
}
