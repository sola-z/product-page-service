package com.example.productpage;

import com.example.productpage.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductPageControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getProductsTest() {
		ResponseEntity<Product[]> response = restTemplate.getForEntity(createURL("/api/products?page=1&size=15"), Product[].class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertTrue(response.getBody().length <= 15);
	}

	@Test
	public void getProductsPageOverflowTest() {
		ResponseEntity<Product[]> response = restTemplate.getForEntity(createURL("/api/products?page=100&size=15"), Product[].class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(0, response.getBody().length);
	}

	@Test
	public void getProductsSizeOverflowTest() {
		ResponseEntity<Product[]> response = restTemplate.getForEntity(createURL("/api/products?page=1&size=50"), Product[].class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertTrue(response.getBody().length <= 30);
	}

	private String createURL(String uri) {
		return "http://localhost:" + port + uri;
	}
}
