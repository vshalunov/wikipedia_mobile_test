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

    private static final String platformName = SELENOID_CONFIG.platformName();
    private static final String deviceName = SELENOID_CONFIG.deviceName();
    private static final String Version = SELENOID_CONFIG.Version();
    private static final String locale = SELENOID_CONFIG.locale();
    private static final String language = SELENOID_CONFIG.language();
    private static final String appPackage = SELENOID_CONFIG.appPackage();
    private static final String appActivity = SELENOID_CONFIG.appActivity();
    private static final String app = SELENOID_CONFIG.app();
    private static final String selenoidURL = SELENOID_CONFIG.selenoidURL();
    private static final String login = SELENOID_CONFIG.login();
    private static final String password = SELENOID_CONFIG.password();
    private static final String remoteURL = format("https://%s:%s@%s", login, password, selenoidURL);

    public static URL getLocalstackUrl() {
        try {
            return new URL(remoteURL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("platformName", platformName);
        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("version", Version);
        desiredCapabilities.setCapability("locale", locale);
        desiredCapabilities.setCapability("language", language);
        desiredCapabilities.setCapability("appPackage", appPackage);
        desiredCapabilities.setCapability("appActivity", appActivity);
        desiredCapabilities.setCapability("app", apkUrl());

        desiredCapabilities.setCapability("enableVNC", true);
        desiredCapabilities.setCapability("enableVideo", true);

        return new AndroidDriver(getLocalstackUrl(), desiredCapabilities);
    }

    private URL apkUrl() {
        try {
            return new URL(app);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
