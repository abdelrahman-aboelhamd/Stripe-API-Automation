package com.stripe.tests;

import com.stripe.base.BaseTest;
import com.stripe.utils.TestData;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;
import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;

@Epic("Stripe API Testing")
@Feature("Customer Management")
@Story("Create Customer")
public class CreateCustomerTest extends BaseTest {
    private String customerId;

    @Test
    @Description("Test to create a new customer with name, email, and description")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Creating a new customer")
    public void createCustomer() {
        Response response = given()
                .filter(new AllureRestAssured())
                .contentType("application/x-www-form-urlencoded")
                .formParam("name", "Test Customer")
                .formParam("email", "test@example.com")
                .formParam("description", "Test customer for API automation")
                .when()
                .post("/customers")
                .then()
                .statusCode(200)
                .body("name", equalTo("Test Customer"))
                .body("email", equalTo("test@example.com"))
                .body("description", equalTo("Test customer for API automation"))
                .extract()
                .response();

        customerId = response.path("id");
        assertNotNull(customerId, "Customer ID should not be null");
        
        // Store the customer ID for other tests
        TestData.setCustomerId(customerId);
    }
} 