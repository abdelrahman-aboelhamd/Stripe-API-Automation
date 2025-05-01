package com.stripe.base;

import com.stripe.config.Config;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public static RequestSpecification requestSpec;

    @BeforeTest
    public void setup() {
        String baseUrl = Config.getBaseUrl();
        String apiKey = Config.getApiKey();

        // Clear any existing specifications
        RestAssured.requestSpecification = null;
        
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .addHeader("Authorization", "Bearer " + apiKey)
                .setContentType(ContentType.URLENC.withCharset("UTF-8"))
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();

        // Set as default for all requests
        RestAssured.requestSpecification = requestSpec;
    }
} 