package com.example.tests;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.annotations.*;
import org.testng.asserts.*;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest extends ApiStubTest {

    static {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com"; // Replace with your API base URL
    }

     

    @Test(enabled = true)
    public void testStubbedPostEndpoint() {
        //String requestBody = "{\"title\":\"foo\",\"body\":\"bar\",\"userId\":214912}";
        String requestBody = "{}";
        io.restassured.RestAssured.baseURI = "http://localhost:8080";
        Response response = given()
            .contentType("application/json")
            .body(requestBody)
            .when()
            .post("/posts")
            .then()
            .extract()
            .response();

        String responseBody = response.getBody().asString();
        System.out.println("post stub: " + responseBody);
        org.testng.Assert.assertEquals(response.getStatusCode(), 201);
        org.testng.Assert.assertEquals(response.jsonPath().getString("title"), "mytitle");
        org.testng.Assert.assertEquals(response.jsonPath().getString("body"), "mybody");
        org.testng.Assert.assertEquals(response.jsonPath().getInt("userId"), 214912);
        org.testng.Assert.assertEquals(response.jsonPath().getInt("id"), 214912); // Should match stubbed value
    }

     @Test(enabled = true)
    public void stubGetEndpoint() {
        io.restassured.RestAssured.baseURI = "http://localhost:8080";
        Response response = given()
                .when()
                .get("/posts/214912")
                .then()
                .statusCode(200)
                .extract()
                .response();

        String responseBody = response.getBody().asString();
        System.out.println("get stub: " + responseBody);
    // Add assertions inside the method
    org.testng.Assert.assertEquals(response.getStatusCode(), 200);
    org.testng.Assert.assertEquals(response.jsonPath().getString("title"), "mytitle");
    org.testng.Assert.assertEquals(response.jsonPath().getString("body"), "mybody");
    org.testng.Assert.assertEquals(response.jsonPath().getInt("userId"), 214912);
    org.testng.Assert.assertEquals(response.jsonPath().getInt("id"), 214912);
    }


     @Test(enabled = true)
    public void stubPutEndpoint() {
        io.restassured.RestAssured.baseURI = "http://localhost:8080";
         String requestBody = "{}";
        Response response = given()
        
                .when()
                .put("/posts?id=214912")
                .then()
                .statusCode(200)
                .extract()
                .response();

        String responseBody = response.getBody().asString();
        System.out.println("put stub: " + responseBody);
    // Add assertions inside the method
    org.testng.Assert.assertEquals(response.getStatusCode(), 200);
    org.testng.Assert.assertEquals(response.jsonPath().getString("title"), "myupdatedtitle");
    org.testng.Assert.assertEquals(response.jsonPath().getString("body"), "mybody");
    org.testng.Assert.assertEquals(response.jsonPath().getInt("userId"), 214912);
    org.testng.Assert.assertEquals(response.jsonPath().getInt("id"), 214912);
    }

    // Additional test methods can be added here

}

    // Additional test methods can be added here
