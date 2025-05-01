package com.stripe.tests;

import com.stripe.base.BaseTest;
import com.stripe.utils.TestData;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;

@Epic("Stripe API Testing")
@Feature("Customer Management")
@Story("Retrieve Customer")
public class RetrieveCustomerTest extends BaseTest {

    @Test
    @Description("Test to retrieve the created customer by ID")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Retrieving the created customer")
    public void retrieveCustomer() {
        given()
                .filter(new AllureRestAssured())
                .when()
                .get("/customers/" + TestData.getCustomerId())
                .then()
                .statusCode(200)
                .body("id", equalTo(TestData.getCustomerId()))
                .body("name", equalTo("Test Customer"));
    }
} 