package com.github.zlwqa.drivers;

import com.codeborne.selenide.WebDriverProvider;
import com.github.zlwqa.config.LocalConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static com.github.zlwqa.utils.FileUtils.getAbsolutePath;

public class LocalMobileDriver implements WebDriverProvider {

    private static final LocalConfig LOCAL_MOBILE_DRIVER = ConfigFactory.create(LocalConfig.class, System.getProperties());

    private static final String PLATFORM_NAME = LOCAL_MOBILE_DRIVER.platformName();
    private static final String DEVICE_NAME = LOCAL_MOBILE_DRIVER.deviceName();
    private static final String VERSION = LOCAL_MOBILE_DRIVER.Version();
    private static final String LOCALE = LOCAL_MOBILE_DRIVER.locale();
    private static final String LANGUAGE = LOCAL_MOBILE_DRIVER.language();
    private static final String APP_PACKAGE = LOCAL_MOBILE_DRIVER.appPackage();
    private static final String APP_ACTIVITY = LOCAL_MOBILE_DRIVER.appActivity();
    private static final String APP = LOCAL_MOBILE_DRIVER.app();
    private static final String REMOTE_URL = LOCAL_MOBILE_DRIVER.remoteURL();

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
        desiredCapabilities.setCapability("app", getAbsolutePath(APP));

        return new AndroidDriver(getLocalstackUrl(), desiredCapabilities);
    }
}
