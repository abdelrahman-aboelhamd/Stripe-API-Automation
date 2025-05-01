package com.stripe.suites;

import com.stripe.base.BaseTest;
import com.stripe.tests.CreateCustomerTest;
import com.stripe.tests.RetrieveCustomerTest;
import com.stripe.tests.UpdateCustomerTest;
import com.stripe.tests.ListCustomersTest;
import com.stripe.tests.SchemaValidationTest;
import com.stripe.tests.DeleteCustomerTest;
import org.testng.annotations.Test;

public class CustomerTestSuite extends BaseTest {

    @Test(priority = 1)
    public void createCustomerTest() {
        CreateCustomerTest createTest = new CreateCustomerTest();
        createTest.createCustomer();
    }

    @Test(priority = 2)
    public void retrieveCustomerTest() {
        RetrieveCustomerTest retrieveTest = new RetrieveCustomerTest();
        retrieveTest.retrieveCustomer();
    }

    @Test(priority = 3)
    public void updateCustomerTest() {
        UpdateCustomerTest updateTest = new UpdateCustomerTest();
        updateTest.updateCustomer();
    }

    @Test(priority = 4)
    public void listCustomersTest() {
        ListCustomersTest listTest = new ListCustomersTest();
        listTest.listCustomers();
    }

    @Test(priority = 5)
    public void schemaValidationTest() {
        SchemaValidationTest schemaTest = new SchemaValidationTest();
        schemaTest.validateSchema();
    }

    @Test(priority = 6)
    public void deleteCustomerTest() {
        DeleteCustomerTest deleteTest = new DeleteCustomerTest();
        deleteTest.deleteCustomer();
    }

} 