package com.testing;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APITests {

	@Test
    public void testRestApi() throws JsonMappingException, JsonProcessingException {
        // Base URL for the REST APIhttps
        RestAssured.baseURI = "https://api.github.com";

        // Perform a GET request to the API endpoint
        Response response = RestAssured.given()
                .when()
                .get("/repos/SuvarchalaJaldu/TestnG"); // Replace with your API endpoint

        // Validate the response body or specific elements in the response
        String responseBody = response.getBody().asString();
        System.out.println("API Response Body: " + responseBody);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseBody);
        String name = jsonNode.get("name").asText();
        long id = jsonNode.get("id").asLong();
        boolean isprivate= jsonNode.get("private").asBoolean();
        
        //validate the RestCall Response
        AssertJUnit.assertEquals(isprivate, false);
        AssertJUnit.assertEquals(id, 630108865);
        
        // Validate the response status code
        AssertJUnit.assertEquals(response.getStatusCode(), 200);

	}

}
