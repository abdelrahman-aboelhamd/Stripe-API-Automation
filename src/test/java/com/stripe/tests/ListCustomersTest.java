package com.stripe.tests;

import com.stripe.base.BaseTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;

@Epic("Stripe API Testing")
@Feature("Customer Management")
@Story("List Customers")
public class ListCustomersTest extends BaseTest {

    @Test
    @Description("Test to list all customers")
    @Severity(SeverityLevel.NORMAL)
    @Step("Listing all customers")
    public void listCustomers() {
        given()
                .filter(new AllureRestAssured())
                .when()
                .get("/customers")
                .then()
                .statusCode(200)
                .body("object", equalTo("list"))
                .body("data", notNullValue());
    }
} 