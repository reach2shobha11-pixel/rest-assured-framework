package com.example.utils;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class keyGen {



      // Define the generateKey method
    public static String generateKey(String username, String password) {
        // Example implementation: make a POST request to get the token
        Response response = RestAssured.given()
            .baseUri("https://reqres.in")
            .contentType("application/json")
            .body("{\"email\":\"" + username + "\", \"password\":\"" + password + "\"}")
            .when()
            .post("/api/login")
            .then()
        
            .extract()
            .response();

             System.out.println("Response: " + response.asString());
    System.out.println("Status code: " + response.getStatusCode());


        // Extract token from response (assuming response JSON has a "token" field)
        return response.jsonPath().getString("token");
    }
    
}
