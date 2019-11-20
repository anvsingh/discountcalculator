package com.discountcalculator.demo.calculator;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

class DiscountCalculatorTest {

	@Test
	void testAmountPayable() throws URISyntaxException {
		//fail("Not yet implemented");
		RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:8080/discount/employee/groceries";/*+ randomServerPort + "/employees";*/
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertEquals(true, result.getBody().equals(String.valueOf(95)));
	}

}
