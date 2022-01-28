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

    private static final String userName = BROWSERSTACK_CONFIG.userName();
    private static final String accessKey = BROWSERSTACK_CONFIG.accessKey();
    private static final String appUrl = BROWSERSTACK_CONFIG.appUrl();
    private static final String deviceName = BROWSERSTACK_CONFIG.deviceName();
    private static final String osVersion = BROWSERSTACK_CONFIG.osVersion();
    private static final String remoteURL = BROWSERSTACK_CONFIG.remoteURL();

    public static URL getBrowserstackUrl() {
        try {
            return new URL(remoteURL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", userName);
        desiredCapabilities.setCapability("browserstack.key", accessKey);

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", appUrl);

        // Specify device and os_version for testing

        desiredCapabilities.setCapability("device", deviceName);
        desiredCapabilities.setCapability("os_version", osVersion);

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", "First Java Project");
        desiredCapabilities.setCapability("build", "browserstack-build-1");
        desiredCapabilities.setCapability("name", "first_test");

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }

}
