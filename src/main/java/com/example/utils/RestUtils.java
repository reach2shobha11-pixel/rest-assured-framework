package com.example.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestUtils {

    private static RequestSpecification requestSpecification;

    public static RequestSpecification getRequestSpecification() {
        if (requestSpecification == null) {
            requestSpecification = RestAssured.given()
                    .header("Content-Type", "application/json");
        }
        return requestSpecification;
    }

    public static Response sendGetRequest(String endpoint) {
        return getRequestSpecification()
                .when()
                .get(endpoint);
    }

    public static Response sendPostRequest(String endpoint, String body) {
        return getRequestSpecification()
                .body(body)
                .when()
                .post(endpoint);
    }

    public static Response sendPutRequest(String endpoint, String body) {
        return getRequestSpecification()
                .body(body)
                .when()
                .put(endpoint);
    }

    public static Response sendDeleteRequest(String endpoint) {
        return getRequestSpecification()
                .when()
                .delete(endpoint);
    }
}