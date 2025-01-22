package com.ju.library_ddd;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;

@SpringBootTest
class LibraryDddApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void test() {
		ApplicationModules.of(LibraryDddApplication.class).verify();
	}

}
