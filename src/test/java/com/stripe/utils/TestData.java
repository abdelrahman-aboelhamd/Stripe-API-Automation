package com.stripe.utils;

import com.stripe.tests.CreateCustomerTest;


public class TestData {
    private static String customerId;

    public static String getCustomerId() {
        if (customerId == null) {
            initializeCustomerId();
        }
        return customerId;
    }

    public static void setCustomerId(String id) {
        customerId = id;
    }

    private static void initializeCustomerId() {
        CreateCustomerTest createCustomerTest = new CreateCustomerTest();
        createCustomerTest.createCustomer();
    }
} 