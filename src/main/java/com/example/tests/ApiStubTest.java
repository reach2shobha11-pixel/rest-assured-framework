package com.example.tests;
import org.testng.annotations.*;
import com.github.tomakehurst.wiremock.WireMockServer;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class ApiStubTest {
    private WireMockServer wireMockServer;

    @BeforeClass
    public void setup() {
        wireMockServer = new WireMockServer(8080);
        wireMockServer.start();
        configureFor("localhost", 8080);

        // Stub POST /posts
        stubFor(post(urlEqualTo("/posts"))
            .willReturn(aResponse()
                .withStatus(201)
                .withHeader("Content-Type", "application/json")
                .withBody("{ \"title\": \"mytitle\", \"body\": \"mybody\", \"userId\": 214912, \"id\": 214912 }")));

        // Stub GET /posts/214912
        stubFor(get(urlEqualTo("/posts/214912"))
            .willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody("{ \"title\": \"mytitle\", \"body\": \"mybody\", \"userId\": 214912, \"id\": 214912 }")));
    
    
   

     // Stub put /posts?id=214912
       stubFor(put(urlPathEqualTo("/posts"))
       .withQueryParam("id", equalTo("214912"))
    .willReturn(aResponse()
        .withStatus(200)
        .withHeader("Content-Type", "application/json")
        .withBody("{ \"title\": \"myupdatedtitle\", \"body\": \"mybody\", \"userId\": 214912, \"id\": 214912 }")));
    
    
     stubFor(post(urlEqualTo("/pojos"))
            .willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody("{ \"title\": \"pojotitle\", \"body\": \"mypojobody\", \"userId\": 214912, \"id\": 214912 }")));


    
    
    }
    @AfterClass
    public void teardown() {
        wireMockServer.stop();
    }
}