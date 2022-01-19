package com.github.zlwqa.drivers;

import com.codeborne.selenide.WebDriverProvider;
import com.github.zlwqa.config.MobileConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    private static final MobileConfig mobileConfig = ConfigFactory.create(MobileConfig.class, System.getProperties());

    private static final String userName = mobileConfig.userName();
    private static final String accessKey = mobileConfig.accessKey();
    private static final String appUrl = mobileConfig.appUrl();

    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
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
        desiredCapabilities.setCapability("device", "Samsung Galaxy S9");
        desiredCapabilities.setCapability("os_version", "8.0");

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", "First Java Project");
        desiredCapabilities.setCapability("build", "browserstack-build-1");
        desiredCapabilities.setCapability("name", "first_test");

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }

}
