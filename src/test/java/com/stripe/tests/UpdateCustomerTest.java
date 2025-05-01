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
@Story("Update Customer")
public class UpdateCustomerTest extends BaseTest {

    @Test
    @Description("Test to update customer details")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Updating customer information")
    public void updateCustomer() {
        given()
                .filter(new AllureRestAssured())
                .contentType("application/x-www-form-urlencoded")
                .formParam("name", "Updated Test Customer")
                .formParam("email", "updated@example.com")
                .when()
                .post("/customers/" + TestData.getCustomerId())
                .then()
                .statusCode(200)
                .body("name", equalTo("Updated Test Customer"))
                .body("email", equalTo("updated@example.com"));
    }
} 