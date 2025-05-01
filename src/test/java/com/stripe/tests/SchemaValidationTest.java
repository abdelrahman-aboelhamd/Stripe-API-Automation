package com.stripe.tests;

import com.stripe.base.BaseTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;

@Epic("Stripe API Testing")
@Feature("Customer Management")
@Story("Schema Validation")
public class SchemaValidationTest extends BaseTest {

    @Test
    @Description("Test to validate response schema for customer operations")
    @Severity(SeverityLevel.NORMAL)
    @Step("Validating response schema")
    public void validateSchema() {
        // Create a customer
        String customerId = given()
                .filter(new AllureRestAssured())
                .contentType("application/x-www-form-urlencoded")
                .formParam("name", "Test Customer")
                .formParam("email", "test@example.com")
                .when()
                .post("/customers")
                .then()
                .statusCode(200)
                .body("id", notNullValue())
                .body("object", equalTo("customer"))
                .body("name", equalTo("Test Customer"))
                .body("email", equalTo("test@example.com"))
                .extract()
                .path("id");

        // Retrieve the customer and validate schema
        given()
                .filter(new AllureRestAssured())
                .when()
                .get("/customers/" + customerId)
                .then()
                .statusCode(200)
                .body("id", notNullValue())
                .body("object", equalTo("customer"))
                .body("name", equalTo("Test Customer"))
                .body("email", equalTo("test@example.com"));

        // Clean up
        given()
                .filter(new AllureRestAssured())
                .when()
                .delete("/customers/" + customerId)
                .then()
                .statusCode(200)
                .body("deleted", equalTo(true));
    }
} 