package com.stripe.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Properties properties = new Properties();
    private static final String CONFIG_FILE = "config.properties";

    static {
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                System.err.println("Error: Could not find " + CONFIG_FILE + " in classpath");
                throw new RuntimeException("Unable to find " + CONFIG_FILE);
            }
            properties.load(input);
        } catch (IOException e) {
            System.err.println("Error loading configuration: " + e.getMessage());
            throw new RuntimeException("Failed to load configuration file", e);
        }
    }

    public static String getBaseUrl() {
        String url = properties.getProperty("stripe.api.base.url");
        if (url == null) {
            System.err.println("Warning: stripe.api.base.url not found in config");
        }
        return url;
    }

    public static String getApiKey() {
        String key = properties.getProperty("stripe.api.key");
        if (key == null) {
            System.err.println("Warning: stripe.api.key not found in config");
        }
        return key;
    }
} 