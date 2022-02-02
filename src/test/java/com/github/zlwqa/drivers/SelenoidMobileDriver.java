package com.github.zlwqa.drivers;

import com.codeborne.selenide.WebDriverProvider;
import com.github.zlwqa.config.SelenoidConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.String.format;

public class SelenoidMobileDriver implements WebDriverProvider {

    private static final SelenoidConfig SELENOID_CONFIG = ConfigFactory.create(SelenoidConfig.class, System.getProperties());

    private static final String PLATFORM_NAME = SELENOID_CONFIG.platformName();
    private static final String DEVICE_NAME = SELENOID_CONFIG.deviceName();
    private static final String VERSION = SELENOID_CONFIG.Version();
    private static final String LOCALE = SELENOID_CONFIG.locale();
    private static final String LANGUAGE = SELENOID_CONFIG.language();
    private static final String APP_PACKAGE = SELENOID_CONFIG.appPackage();
    private static final String APP_ACTIVITY = SELENOID_CONFIG.appActivity();
    private static final String APP_URL = SELENOID_CONFIG.appURL();
    private static final String SELENOID_URL = SELENOID_CONFIG.selenoidURL();
    private static final String LOGIN = SELENOID_CONFIG.login();
    private static final String PASSWORD = SELENOID_CONFIG.password();
    private static final String REMOTE_URL = format("https://%s:%s@%s", LOGIN, PASSWORD, SELENOID_URL);

    public static URL getLocalstackUrl() {
        try {
            return new URL(REMOTE_URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("platformName", PLATFORM_NAME);
        desiredCapabilities.setCapability("deviceName", DEVICE_NAME);
        desiredCapabilities.setCapability("version", VERSION);
        desiredCapabilities.setCapability("locale", LOCALE);
        desiredCapabilities.setCapability("language", LANGUAGE);
        desiredCapabilities.setCapability("appPackage", APP_PACKAGE);
        desiredCapabilities.setCapability("appActivity", APP_ACTIVITY);
        desiredCapabilities.setCapability("app", apkUrl());

        desiredCapabilities.setCapability("enableVNC", true);
        desiredCapabilities.setCapability("enableVideo", true);

        return new AndroidDriver(getLocalstackUrl(), desiredCapabilities);
    }

    private URL apkUrl() {
        try {
            return new URL(APP_URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
