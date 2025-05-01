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
@Story("Delete Customer")
public class DeleteCustomerTest extends BaseTest {

    @Test
    @Description("Test to delete a customer")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Deleting a customer")
    public void deleteCustomer() {
        // First delete the customer
        given()
                .filter(new AllureRestAssured())
                .when()
                .delete("/customers/" + TestData.getCustomerId())
                .then()
                .statusCode(200)
                .body("deleted", equalTo(true));

        // Verify customer is deleted
        given()
                .filter(new AllureRestAssured())
                .when()
                .get("/customers/" + TestData.getCustomerId())
                .then()
                .statusCode(200)
                .body("deleted", equalTo(true));
    }
} 