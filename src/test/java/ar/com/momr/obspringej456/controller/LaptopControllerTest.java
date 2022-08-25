package ar.com.momr.obspringej456.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import ar.com.momr.obspringej456.entities.Laptop;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

	private TestRestTemplate testRestTemplate;

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	@LocalServerPort
	private int port;

	@BeforeEach
	void setUp() {
		restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
		testRestTemplate = new TestRestTemplate(restTemplateBuilder);
	}

	@Test
	void testFindAll() {
		// fail("Not yet implemented");

		ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/api/laptops", Laptop[].class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(200, response.getStatusCodeValue());

	}

	@Test
	void testFindOneById() {
		// fail("Not yet implemented");

		ResponseEntity<Laptop> response = testRestTemplate.getForEntity("/api/laptops/1", Laptop.class);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

	@Test
	void testCreate() {
		// fail("Not yet implemented");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		String json = """
								{
				    "brand": "MSI con JUNIT TEST",
				    "os": "Windows 10",
				    "ram": 32,
				    "disc": 1000.0,
				    "usbPorts": 4
				}
								""";
		
		HttpEntity<String> request = new HttpEntity<>(json,headers);
		
		ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.POST, request, Laptop.class);
		Laptop result = response.getBody();
		
		assertEquals(1L, result.getId());
		assertEquals("MSI con JUNIT TEST", result.getBrand());
		assertEquals(32, result.getRam());
	}

}
