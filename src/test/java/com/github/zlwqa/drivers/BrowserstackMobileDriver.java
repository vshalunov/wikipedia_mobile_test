package com.github.zlwqa.drivers;

import com.codeborne.selenide.WebDriverProvider;
import com.github.zlwqa.config.BrowserstackConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    private static final BrowserstackConfig BROWSERSTACK_CONFIG = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    private static final String USERNAME = BROWSERSTACK_CONFIG.userName();
    private static final String ACCESS_KEY = BROWSERSTACK_CONFIG.accessKey();
    private static final String APP_URL = BROWSERSTACK_CONFIG.appUrl();
    private static final String DEVICE_NAME = BROWSERSTACK_CONFIG.deviceName();
    private static final String OS_VERSION = BROWSERSTACK_CONFIG.osVersion();
    private static final String REMOTE_URL = BROWSERSTACK_CONFIG.remoteURL();

    public static URL getBrowserstackUrl() {
        try {
            return new URL(REMOTE_URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", USERNAME);
        desiredCapabilities.setCapability("browserstack.key", ACCESS_KEY);

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", APP_URL);

        // Specify device and os_version for testing

        desiredCapabilities.setCapability("device", DEVICE_NAME);
        desiredCapabilities.setCapability("os_version", OS_VERSION);

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", "First Java Project");
        desiredCapabilities.setCapability("build", "browserstack-build-1");
        desiredCapabilities.setCapability("name", "first_test");

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }
}
