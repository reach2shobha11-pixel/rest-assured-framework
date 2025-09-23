package com.example.tests;
import com.example.utils.keyGen;
import com.fasterxml.jackson.databind.ObjectMapper;


import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.io.File;

public class tokenGentest {

    @Test(enabled = true)
    public void callTokenGenerator() {
        Object[][] loginData = loginDataProvider();
        int records = loginData.length;
        int index = (int) (Math.random() * records);

        String username = (String) loginData[index][0];
        String password = (String) loginData[index][1];
        System.out.println("credentials: " + username + " / " + password);

      //  String apikey = keyGen.generateKey(username, password);
        //Assert.assertNotNull(apikey, "API key should not be null");
        //System.out.println("apikey: " + apikey);
    }

    @Test
    public void callOpenWeatherMap() {
        String apiKey = "f6169e137a1c1cb7cf5a427b9ef40262"; // Replace with your key
       io.restassured.RestAssured.baseURI = "https://api.openweathermap.org";
        Response response = given()
            .queryParam("q", "London")
            .queryParam("appid", apiKey)
            .when()
            .get("/data/2.5/weather")
            .then()
            .statusCode(200)
            .extract()
            .response();

        System.out.println("Weather response: " + response.asString());
    }

    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            loginPojo[] logins = mapper.readValue(new File("src/test/resources/logins.json"), loginPojo[].class);
            Object[][] data = new Object[logins.length][2];
            for (int i = 0; i < logins.length; i++) {
                data[i][0] = logins[i].getUsername();
                data[i][1] = logins[i].getPassword();
            }
            return data;
        } catch (Exception e) {
            throw new RuntimeException("Failed to read login data from JSON", e);
        }
    }
}