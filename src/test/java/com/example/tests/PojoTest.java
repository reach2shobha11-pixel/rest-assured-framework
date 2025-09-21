package com.example.tests;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.annotations.*;
import org.testng.asserts.*;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class PojoTest extends ApiStubTest {

    static {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com"; // Replace with your API base URL
    }

     

    @Test(enabled = true)
    public void testPojoPostEndpoint() {

         io.restassured.RestAssured.baseURI = "http://localhost:8080";

        pojo pojo = new pojo();
        pojo.setTitle("myPojoTitle");
        pojo.setBody("myPojoBody");
        pojo.setUserId(214912);
        pojo.setId(214912);

        Response response = given()
            .contentType("application/json")
            .body(pojo)
            .when()
            .post("/pojos")
            .then()
            .extract()
            .response();


            String resp = response.jsonPath().prettyPrint();
            System.out.println("pojo post: " + resp);
        org.testng.Assert.assertEquals(response.getStatusCode(), 200);
        org.testng.Assert.assertEquals(response.jsonPath().getString("title"), "pojotitle");
        org.testng.Assert.assertEquals(response.jsonPath().getString("body"), "mypojobody");
        org.testng.Assert.assertEquals(response.jsonPath().getInt("userId"), 214912);
        org.testng.Assert.assertEquals(response.jsonPath().getInt("id"), 214912); // Should match stubbed value
    }
}
